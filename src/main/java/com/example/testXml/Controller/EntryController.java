package com.example.testXml.Controller;

import com.example.testXml.Service.Impl.EntriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/entries")
public class EntryController {

    private final EntriesService entriesService;

//принимаем число 1...N и добавляем такое количество записей с этими значениями

    @GetMapping(value = "/{inputNumber}", produces = "application/json")
    public ResponseEntity<?> addEntries(@PathVariable String inputNumber) {
        return ResponseEntity.ok().body(entriesService.addEntries(inputNumber));
    }

//Все данные в XML
    @GetMapping(value = "/all-xml", produces = "application/xml")
    public ResponseEntity<?> getAllEntriesToXml() {
        return ResponseEntity.ok().body(entriesService.getAllEntries());
    }

// + XSLT

    @GetMapping(value = "/all-xslt", produces = "application/xml")
    public ResponseEntity<?> getAllEntriesToXslt() {
        return ResponseEntity.ok().body(entriesService.getAllEntriesXslt());
    }
// сумму всех значени

    @GetMapping(value = "/sum-all-value", produces = "application/json")
    public ResponseEntity<?> sumAllValue() {
        return ResponseEntity.ok().body(entriesService.sumAllValue());
    }
}
