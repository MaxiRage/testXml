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
@RequestMapping("/api/v1/fields")
public class FieldController {

    private final EntriesService entriesService;

//принимаем число 1...N и добавляем такое количество записей с этими значениями

    @GetMapping("/{inputNumber}")
    public ResponseEntity<?> addEntries (@PathVariable String inputNumber) {
        return ResponseEntity.ok().body(entriesService.addEntries(inputNumber));
    }

//Все данные в XML

// + XSLT

// сумму всех значени
}
