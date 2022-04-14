package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Journal;
import com.natetreimer.greenstep.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    @Override
    public void saveJournal(Journal journal) {
        this.journalRepository.save(journal);
    }

    @Override
    public Journal getJournalById(Long id) {
        Optional<Journal> optional = journalRepository.findById(id);
        Journal journal = null;
        if (optional.isPresent()) {
            journal = optional.get();
        } else {
            throw new RuntimeException("Journal not found for id :: " + id);
        }
        return journal;
    }

    @Override
    public void deleteJournalById(Long id) {
        this.journalRepository.deleteById(id);
    }
}
