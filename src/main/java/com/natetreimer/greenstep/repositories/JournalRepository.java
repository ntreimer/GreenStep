package com.natetreimer.greenstep.repositories;

import com.natetreimer.greenstep.models.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    Journal findJournalById(Long id);
}
