package com.example.testXml.Service;

import com.example.testXml.Entity.Entry;
import com.example.testXml.Repository.EntryRepository;
import com.example.testXml.Service.Impl.EntriesService;
import com.example.testXml.Utils.ListEntries;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class EntriesServiceImpl implements EntriesService {

    private final EntryRepository fieldRepository;

    @Override
    public Map<String, Object> addEntries(String inputNumber) {
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

        log.info("Числа записаны c 1 по " + outputNumber);
        return response;
    }

    @Override
    public ListEntries getAllEntries() {
        log.info("Запрос на получение всех данных в XML");
        ListEntries listEntries = new ListEntries();
        listEntries.setEntries(fieldRepository.findAll());
        log.info("XML сформирован");
        return listEntries;
    }

    @SneakyThrows
    @Override
    public String getAllEntriesXslt() {
        log.info("Запрос на преобразование XSLT");
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource("src/main/resources/templates/pattern.xsl");
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource("http://localhost:8080/api/entries/all-xml");
        StreamResult streamResult = new StreamResult(new StringWriter());
        transformer.transform(xml, streamResult);
        log.info("Преобразование выполнено");
        return streamResult.getWriter().toString();
    }

    @Override
    public int sumAllValue() {
        log.info("Запрос на получение суммы всех значений выполнен");
        return fieldRepository.findAll()
                .stream()
                .map(Entry::getField)
                .reduce(0, Integer::sum);
    }
}
