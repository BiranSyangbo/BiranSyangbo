package com.example.design.pattern.command;

import com.example.design.pattern.command.domain.Command;
import com.example.design.pattern.command.domain.CommandResult;

public interface CommandExecutor<C extends Command, R extends CommandResult> {
    R execute(C command);
}
