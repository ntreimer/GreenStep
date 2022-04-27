package com.natetreimer.greenstep.journal;

import com.natetreimer.greenstep.journal.Journal;
import com.natetreimer.greenstep.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {
    Journal findJournalById(Long id);

    List<Journal> findJournalByUser(User user);
}
