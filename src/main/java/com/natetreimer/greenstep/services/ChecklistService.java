package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Checklist;
import com.natetreimer.greenstep.security.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChecklistService {

    List<Checklist> getAllChecklists();

    List<Checklist> getChecklistByUser(User user);

    void saveChecklist(Checklist footprint);

    Checklist getChecklistById(Long id);

    void deleteChecklistById(Long id);

}
