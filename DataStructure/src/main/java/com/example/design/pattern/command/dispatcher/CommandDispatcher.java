package com.example.design.pattern.command.dispatcher;

import com.example.design.pattern.command.CommandExecutor;
import com.example.design.pattern.command.annotation.CommandType;
import com.example.design.pattern.command.domain.Command;
import com.example.design.pattern.command.domain.CommandResult;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandDispatcher<C extends Command, R extends CommandResult> {

    protected Map<Class<C>, CommandExecutor<C, R>> byClazz = new HashMap<>();

    protected Map<CommandType, CommandExecutor<C, R>> map = new HashMap<>();

    public R dispatch(CommandType type, C command) {
        return map.get(type).execute(command);
    }

    public R dispatchByClass(C command) {
        return byClazz.get(command.getClass()).execute(command);
    }


}
