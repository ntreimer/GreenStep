package com.natetreimer.greenstep.journal;

import com.natetreimer.greenstep.journal.Journal;
import com.natetreimer.greenstep.journal.JournalRepository;
import com.natetreimer.greenstep.journal.JournalService;
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
    public Journal getJournalById(Long id) throws JournalNotFoundException {
        Optional<Journal> optional = journalRepository.findById(id);
        Journal journal;
        if (optional.isPresent()) {
            journal = optional.get();
        } else {
            throw new JournalNotFoundException();
        }
        return journal;
    }

    @Override
    public void deleteJournalById(Long id) {
        this.journalRepository.deleteById(id);
    }
}
