package com.example.design.pattern.command;

import com.example.design.pattern.command.annotation.CommandType;
import com.example.design.pattern.command.domain.ApproveCommand;
import com.example.design.pattern.command.domain.RejectCommand;
import com.example.design.pattern.command.executor.impl.ApproveWorkflow;
import com.example.design.pattern.command.executor.impl.RejectWorkflow;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;

public class MainCommand {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        var map = new HashMap<String, CommandExecutor>();
        map.put("approvalWorkflow", new ApproveWorkflow());
        map.put("rejectWorkflow", new RejectWorkflow());
//        var command = new CommandDispatcherService(map)
//                .prepare();
//        var approve = command.dispatch(new ApproveCommand("Test", true));
//        var reject = command.dispatch(new RejectCommand("Reject the code", true));
//        System.out.println(approve);
//        System.out.println(reject);
        var command = new CommandDispatcherService();
        var approve = command.dispatch(CommandType.APPROVE, new ApproveCommand("Test", true));
        var reject = command.dispatch(CommandType.REJECT, new RejectCommand("Reject the code", false));
        System.out.println(approve);
        System.out.println(reject);
        System.out.println("EDITHHBTFDEV_JRHB_CBS".toLowerCase(Locale.ROOT));
    }
}
