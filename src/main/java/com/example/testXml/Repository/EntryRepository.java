package com.example.testXml.Repository;

import com.example.testXml.Entity.Entry;
import com.example.testXml.Utils.ListEntries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, String> {
}