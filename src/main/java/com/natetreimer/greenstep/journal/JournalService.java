package com.natetreimer.greenstep.journal;

import com.natetreimer.greenstep.journal.Journal;

import java.util.List;


public interface JournalService {

    List<Journal> getAllJournals();

    void saveJournal(Journal footprint);

    Journal getJournalById(Long id);

    void deleteJournalById(Long id);

}
