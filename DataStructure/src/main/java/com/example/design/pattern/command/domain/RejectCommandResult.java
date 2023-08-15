package com.example.design.pattern.command.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RejectCommandResult extends CommandResult {
    private String response;
}
