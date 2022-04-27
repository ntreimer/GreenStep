package com.natetreimer.greenstep.journal;

import com.natetreimer.greenstep.journal.Journal;
import com.natetreimer.greenstep.security.User;

import java.util.List;


public interface JournalService {

    List<Journal> getJournalByUser(User user);

    List<Journal> getAllJournals();

    void saveJournal(Journal footprint);

    Journal getJournalById(Long id) throws JournalNotFoundException;

    void deleteJournalById(Long id);

}
