package com.example.design.pattern.command;

import com.example.design.pattern.command.annotation.CommandHandler;
import com.example.design.pattern.command.dispatcher.CommandDispatcher;
import com.example.design.pattern.command.domain.Command;
import com.example.design.pattern.command.domain.CommandResult;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.Set;

public class CommandDispatcherService extends CommandDispatcher<Command, CommandResult> {

//    Map<String, CommandExecutor<C, R>> request;

//    public CommandDispatcherService(Map<String, CommandExecutor<C, R>> request) {
//        this.request = request;
//    }
//
//    public CommandDispatcherService<C, R> prepare() {
//        request.forEach((k, v) -> {
//            var result = ((ParameterizedType) request.get(k).getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
//            byClazz.put((Class<C>) result, v);
//        });
//        return this;
//    }


    public CommandDispatcherService() {
        processCommand();
    }

    @SneakyThrows
    public void processCommand() {
//        Class<CommandExecutor<Command, CommandResult>> clazz = (Class<CommandExecutor<Command, CommandResult>>) ClassLoader.getSystemClassLoader().loadClass("com.example.design.pattern.command.executor.impl.ApproveWorkflow");
//        var annotation = clazz.getAnnotation(CommandHandler.class);
//        if (Objects.nonNull(annotation)) {
//            var type = annotation.type();
//            map.put(type, clazz.getDeclaredConstructor().newInstance());
//        }

        Reflections reflections = new Reflections("com.example.design.pattern.command");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(CommandHandler.class);
        for (Class<?> clazz : classes) {
            var annotation = clazz.getAnnotation(CommandHandler.class);
            map.put(annotation.type(), (CommandExecutor<Command, CommandResult>) clazz.getDeclaredConstructor().newInstance());
        }

    }
}
