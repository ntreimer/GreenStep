package com.natetreimer.greenstep.checklist;

import com.natetreimer.greenstep.security.User;
import com.natetreimer.greenstep.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/checklist")
    public String viewChecklist(Principal principal, Model model) throws ChecklistNotFoundException {
        User user = userRepository.findByEmail(principal.getName());

        List<Checklist> allChecklists = checklistService.getAllChecklists();
        ArrayList<ExtendedChecklist> extendedChecklists = new ArrayList<>();

        List<Checklist> myChecklists = checklistService.getChecklistByUser(user);
        allChecklists.forEach((checklist -> extendedChecklists.add(new ExtendedChecklist(false, checklist))));
        myChecklists.forEach(thisChecklist -> {
            extendedChecklists.forEach(extendedChecklist -> {
                if (extendedChecklist.getChecklist() == thisChecklist) {
                    extendedChecklist.setCompleted(true);
                }
            });
        });
        extendedChecklists.forEach(extendedChecklist -> System.out.println(extendedChecklist.isCompleted()));
        model.addAttribute("extendedChecklists", extendedChecklists);

        ExtendedChecklistDto dto = new ExtendedChecklistDto();
        dto.setExtendedChecklists(extendedChecklists);

        model.addAttribute("dto", dto);

        return "checklist";
    }


    @GetMapping("/new_checklist")
    public String createNewChecklist(Model model) {
//        Checklist checklist = new Checklist();
//        model.addAttribute("checklist", checklist);
        return "new_checklist";
    }

        //    @PostMapping("/saveChecklist")
//    public String saveChecklist(@ModelAttribute("extendedChecklists") ArrayList<ExtendedChecklist> extendedChecklists, BindingResult bindingResult) {
//        System.out.println("inside savechecklist!!!!!!!!!!");
//        System.out.println(extendedChecklists);
////        System.out.println(extendedChecklists.size());
////        extendedChecklists.forEach(extendedChecklist -> System.out.println(extendedChecklist.isCompleted()));
////        checklistService.saveChecklist(checklist);
//        System.out.println("at the end!!!!!");
//        return "redirect:/checklist";
//    }


    @PostMapping("/saveChecklist")
    public String saveChecklist(@ModelAttribute("extendedChecklists") ExtendedChecklistDto dto, Principal principal, BindingResult bindingResult) {

        List<ExtendedChecklist> extendedChecklists = dto.getExtendedChecklists();
        Set<Checklist> checklistsToSave = new HashSet<>();

        extendedChecklists.forEach(extendedChecklist -> {
            if (extendedChecklist.isCompleted()) {
                checklistsToSave.add(extendedChecklist.getChecklist());
            }
        });

        User user = userRepository.findByEmail(principal.getName());
        user.setCheckedItems(checklistsToSave);
        userRepository.save(user);

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