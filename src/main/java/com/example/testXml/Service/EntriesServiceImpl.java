package com.example.testXml.Service;

import com.example.testXml.Entity.Entry;
import com.example.testXml.Repository.EntryRepository;
import com.example.testXml.Service.Impl.EntriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntriesServiceImpl implements EntriesService {

    private final EntryRepository fieldRepository;

    @Override
    public Map<String, Object> addEntries(String inputNumber) {
        long start = System.currentTimeMillis();

        Map<String, Object> response = new LinkedHashMap<>();

        if (!inputNumber.matches("^[1-9]\\d*$")) {
            response.put("error", true);
            response.put("massage", "Invalid number");
            return response;
        }

        int outputNumber = Integer.parseInt(inputNumber);
        log.info("Число " + outputNumber + " принято");

        for (int temp = 1; temp <= outputNumber; temp++) {
            Entry field = new Entry();
            field.setField(temp);
            fieldRepository.save(field);
        }
        response.put("error", false);
        response.put("massage", "entries are saved");

        long finish = System.currentTimeMillis();
        log.info("Числа c 1 до " + outputNumber + " записаны за " + (finish - start) + "ms");
        return response;
    }

}
