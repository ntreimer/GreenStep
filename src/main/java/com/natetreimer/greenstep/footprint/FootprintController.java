package com.natetreimer.greenstep.footprint;

import com.natetreimer.greenstep.footprint.Footprint;
import com.natetreimer.greenstep.security.User;
import com.natetreimer.greenstep.security.UserRepository;
import com.natetreimer.greenstep.footprint.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class FootprintController {

    @Autowired
    private FootprintService footprintService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/footprint")
    public String viewFootprints(Principal principal, Model model) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("listFootprints", footprintService.getFootprintsByUserId(user.getId()));

        return "footprint";
    }

    @GetMapping("/new_footprint")
    public String createNewFootprint(Model model) {
        Footprint footprint = new Footprint();
        model.addAttribute("footprint", footprint);
        return "new_footprint";
    }

    @PostMapping("/saveFootprint")
    public String saveFootprint(@ModelAttribute("footprint") @Valid Footprint footprint, Principal principal, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new_footprint";
        }
        User user = userRepository.findByEmail(principal.getName());
        footprint.setUser(user);
        footprintService.saveFootprint(footprint);
        return "redirect:/footprint";
    }

    @GetMapping("/updateFootprint/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {

        // get footprint from the service
        Footprint footprint = footprintService.getFootprintById(id);

        // set footprint as a model attribute to pre-populate the form
        model.addAttribute("footprint", footprint);
        return "update_footprint";
    }

    @GetMapping("/deleteFootprint/{id}")
    public String deleteFootprint(@PathVariable(value = "id") Long id) {

        // call delete footprint method
        this.footprintService.deleteFootprintById(id);
        return "redirect:/footprint";
    }
}
