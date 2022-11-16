package com.example.testXml.Exceptions;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class NumberFormatInvalid extends NumberFormatException {

    public NumberFormatInvalid() {
        errorMassage();
        log.error("Invalid number");
    }

    private void errorMassage (){
        Map<String, Object> massage = new LinkedHashMap<>();
        massage.put("error", true);
        massage.put("massage", "Invalid number");
    }
}