package com.natetreimer.greenstep.journal;

import com.natetreimer.greenstep.journal.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    Journal findJournalById(Long id);
}
