package com.example.testXml.Service.Impl;

import com.example.testXml.Utils.ListEntries;

import java.util.Map;

public interface EntriesService {
    Map<String, Object> addEntries(String inputNumber);

    ListEntries getAllEntries();

    String getAllEntriesXslt();

    int sumAllValue();
}
