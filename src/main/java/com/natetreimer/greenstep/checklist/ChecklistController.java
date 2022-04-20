package com.natetreimer.greenstep.checklist;


import com.natetreimer.greenstep.checklist.Checklist;
import com.natetreimer.greenstep.security.User;
import com.natetreimer.greenstep.security.UserRepository;
import com.natetreimer.greenstep.checklist.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/checklist")
    public String viewChecklist(Principal principal, Model model) {
        User user = userRepository.findByEmail(principal.getName());


        List<Checklist> allChecklists = checklistService.getAllChecklists();
        List<ExtendedChecklist> extendedChecklists = new ArrayList<>();
        List<Checklist> myChecklists = checklistService.getChecklistByUser(user);
        allChecklists.forEach((checklist -> extendedChecklists.add(new ExtendedChecklist(false, checklist))));
        myChecklists.forEach(checklist -> {
            int index = extendedChecklists.indexOf(checklist);
            extendedChecklists.get(index).setCompleted(true);
        });
        model.addAttribute("extendedChecklist", extendedChecklists);
        return "checklist";
    }


    @GetMapping("/new_checklist")
    public String createNewChecklist(Model model) {
//        Checklist checklist = new Checklist();
//        model.addAttribute("checklist", checklist);
        return "new_checklist";
    }

    @PostMapping("/saveChecklist")
    public String saveChecklist(@ModelAttribute("checklist") @Valid Checklist checklist, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new_checklist";
        }
        checklistService.saveChecklist(checklist);
        return "redirect:/checklist";
    }

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
