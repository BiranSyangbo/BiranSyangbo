package com.example.design.pattern.command.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApproveCommand extends Command {
    private String comments;
    private boolean approved;
}
