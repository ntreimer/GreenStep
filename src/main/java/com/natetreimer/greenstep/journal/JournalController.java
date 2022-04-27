package com.natetreimer.greenstep.journal;


import com.natetreimer.greenstep.security.User;
import com.natetreimer.greenstep.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.naming.Binding;
import javax.validation.Valid;
import java.security.Principal;


@Controller
public class JournalController {

    @Autowired
    private JournalService journalService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/journal")
    public String viewJournals(Model model, Principal principal) {
        Journal journal = new Journal();
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("newJournal", journal);
        model.addAttribute("listJournals", journalService.getJournalByUser(user));
        return "journal";
    }

//    @GetMapping("/new_journal")
//    public String createNewJournal(Model model) {
////        Journal journal = new Journal();
////        model.addAttribute("journal", journal);
//        return "new_journal";
//    }

    @PostMapping("/saveJournal")
    public String saveJournal(@ModelAttribute("journal") @Valid Journal journal, Principal principal, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new_journal";
        }
        User user = userRepository.findByEmail(principal.getName());
        journal.setUser(user);
        journalService.saveJournal(journal);
        return "redirect:/journal";
    }

//
//    @GetMapping("/showFormForUpdate/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
//
//        // get  from the service
//        Journal journal = journalService.getJournalById(id);
//
//        // set  as a model attribute to pre-populate the form
//        model.addAttribute("journal", journal);
//        return "update_journal";
//    }
//

    @GetMapping("/deleteJournal/{id}")
    public String deleteJournal(@PathVariable(value = "id") Long id) {

        // call delete journal method
        this.journalService.deleteJournalById(id);
        return "redirect:/journal";
    }
}
