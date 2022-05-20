package com.microservice.usermicroservice.ValueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private long todoID;
    private String task;
    private String description;
    private long userID;
}
