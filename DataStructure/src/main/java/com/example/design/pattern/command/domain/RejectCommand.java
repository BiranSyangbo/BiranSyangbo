package com.example.design.pattern.command.domain;

import com.example.design.pattern.command.CommandExecutor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RejectCommand extends Command {

    private String comment;

    private boolean reject;
}
