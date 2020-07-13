package com.example.demo.dao;

import lombok.Value;

@Value
public class GenerateResponse {

    private final String link;

    public GenerateResponse(String prefix, String link) {
        this.link = prefix + "/" + link;
    }
}
