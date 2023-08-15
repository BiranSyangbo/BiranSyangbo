package com.example.design.pattern.command.executor.impl;

import com.example.design.pattern.command.CommandExecutor;
import com.example.design.pattern.command.annotation.CommandHandler;
import com.example.design.pattern.command.annotation.CommandType;
import com.example.design.pattern.command.domain.ApproveCommand;
import com.example.design.pattern.command.domain.ApproveCommandResult;

@CommandHandler(type = CommandType.APPROVE)
public class ApproveWorkflow implements CommandExecutor<ApproveCommand, ApproveCommandResult> {

    @Override
    public ApproveCommandResult execute(ApproveCommand command) {
        String response = command.isApproved() ? "Approved" : "Reject";
        return new ApproveCommandResult(response);
    }

}
