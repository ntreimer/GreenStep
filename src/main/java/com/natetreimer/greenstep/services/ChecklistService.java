package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Checklist;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ChecklistService {

    List<Checklist> getAllChecklists();

    void saveChecklist(Checklist footprint);

    Checklist getChecklistById(Long id);

    void deleteChecklistById(Long id);

}
