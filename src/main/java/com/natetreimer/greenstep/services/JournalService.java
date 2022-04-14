package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Journal;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JournalService {

    List<Journal> getAllJournals();

    void saveJournal(Journal footprint);

    Journal getJournalById(Long id);

    void deleteJournalById(Long id);

}
