package com.techgirl.spring_activemq.model;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String content;

    public String toString(){
        Gson gson = new Gson();

        return gson.toJson(this, Message.class);
    }
}
