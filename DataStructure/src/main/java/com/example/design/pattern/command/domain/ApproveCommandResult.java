package com.example.design.pattern.command.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApproveCommandResult extends CommandResult {
    private String response;
}
