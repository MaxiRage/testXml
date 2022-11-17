package com.example.testXml.Controller;

import com.example.testXml.Entity.Entry;
import com.example.testXml.Repository.EntryRepository;
import com.example.testXml.Service.Impl.EntriesService;
import com.example.testXml.Utils.ListEntries;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/entries")
public class EntryController {

    private final EntriesService entriesService;
    private final EntryRepository fieldRepository;


//принимаем число 1...N и добавляем такое количество записей с этими значениями

    @GetMapping("/{inputNumber}")
    public ResponseEntity<?> addEntries(@PathVariable String inputNumber) {
        return ResponseEntity.ok().body(entriesService.addEntries(inputNumber));
    }

    //Все данные в XML
    @GetMapping(value = "/all-xml", produces = "application/xml")
    public ResponseEntity<?> getAllEntriesToXml() {
        ListEntries listEntries = new ListEntries();
        listEntries.setEntries(fieldRepository.findAll());
        return ResponseEntity.ok().body(listEntries);
    }

// + XSLT

    @GetMapping(value = "/all-xslt", produces = "application/xml")
    public ResponseEntity<?> getAllEntriesToXslt() {
        ListEntries listEntries = new ListEntries();
        listEntries.setEntries(fieldRepository.findAll());
        return ResponseEntity.ok().body(listEntries);
    }
// сумму всех значени
}
