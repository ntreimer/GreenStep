package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Checklist;
import com.natetreimer.greenstep.repositories.ChecklistRepository;
import com.natetreimer.greenstep.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistServiceImpl implements ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    @Override
    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    @Override
    public List<Checklist> getChecklistByUser(User user) {
        return checklistRepository.findChecklistByCheckedUsers(user);
    }


    @Override
    public void saveChecklist(Checklist checklist) {
        this.checklistRepository.save(checklist);
    }

    @Override
    public Checklist getChecklistById(Long id) {
        Optional<Checklist> optional = checklistRepository.findById(id);
        Checklist checklist = null;
        if (optional.isPresent()) {
            checklist = optional.get();
        } else {
            throw new RuntimeException("Checklist not found for id :: " + id);
        }
        return checklist;
    }

    @Override
    public void deleteChecklistById(Long id) {
        this.checklistRepository.deleteById(id);
    }
}
