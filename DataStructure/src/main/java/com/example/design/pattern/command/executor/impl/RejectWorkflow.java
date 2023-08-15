package com.example.design.pattern.command.executor.impl;

import com.example.design.pattern.command.CommandExecutor;
import com.example.design.pattern.command.annotation.CommandHandler;
import com.example.design.pattern.command.annotation.CommandType;
import com.example.design.pattern.command.domain.RejectCommand;
import com.example.design.pattern.command.domain.RejectCommandResult;

@CommandHandler(type = CommandType.REJECT)
public class RejectWorkflow implements CommandExecutor<RejectCommand, RejectCommandResult> {

    @Override
    public RejectCommandResult execute(RejectCommand command) {
        String response = command.isReject() ? "Rejected" : "Cancelled";
        return new RejectCommandResult(response);
    }
}
