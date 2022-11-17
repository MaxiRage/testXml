package com.example.testXml.Utils;

import com.example.testXml.Entity.Entry;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
@JacksonXmlRootElement(localName = "entries")

public class ListEntries {

    @JacksonXmlProperty(localName = "entry")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Entry> entries = new ArrayList<>();

}
