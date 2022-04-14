package com.natetreimer.greenstep.repositories;

import com.natetreimer.greenstep.models.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    Checklist findChecklistById(Long id);
}
