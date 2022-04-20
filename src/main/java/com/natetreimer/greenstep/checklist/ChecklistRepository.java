package com.natetreimer.greenstep.checklist;

import com.natetreimer.greenstep.checklist.Checklist;
import com.natetreimer.greenstep.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    Checklist findChecklistById(Long id);

    List<Checklist> findChecklistByCheckedUsers(User user);
}
