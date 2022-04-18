package com.natetreimer.greenstep.controllers;


import com.natetreimer.greenstep.services.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.naming.Binding;
import javax.validation.Valid;


@Controller
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping("/checklist")
    public String viewChecklist(Model model) {
        model.addAttribute("listChecklists", checklistService.getAllChecklists());
        return "checklist";
    }

    @GetMapping("/new_checklist")
    public String createNewChecklist(Model model) {
//        Checklist checklist = new Checklist();
//        model.addAttribute("checklist", checklist);
        return "new_checklist";
    }

//    @PostMapping("/saveChecklist")
//    public String saveChecklist(@ModelAttribute("checklist") @Valid Checklist checklist, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            return "new_checklist";
//        }
//        checklistService.saveChecklist(checklist);
//        return "redirect:/checklist";
//    }

//    @GetMapping("/showFormForUpdate/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
//
//        // get checklist from the service
//        Checklist checklist = checklistService.getChecklistById(id);
//
//        // set checklist as a model attribute to pre-populate the form
//        model.addAttribute("checklist", checklist);
//        return "update_checklist";
//    }
//
//    @GetMapping("/deleteChecklist/{id}")
//    public String deleteChecklist(@PathVariable(value = "id") Long id) {
//
//        // call delete checklist method
//        this.checklistService.deleteChecklistById(id);
//        return "redirect:/checklist";
//    }
}
