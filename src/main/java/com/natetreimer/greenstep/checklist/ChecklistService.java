package com.natetreimer.greenstep.checklist;

import com.natetreimer.greenstep.checklist.Checklist;
import com.natetreimer.greenstep.security.User;

import java.util.List;


public interface ChecklistService {

    List<Checklist> getAllChecklists();

    List<Checklist> getChecklistByUser(User user);

    void saveChecklist(Checklist footprint);

    Checklist getChecklistById(Long id);

    void deleteChecklistById(Long id);

}
