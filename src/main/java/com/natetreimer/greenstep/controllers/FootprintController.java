package com.natetreimer.greenstep.controllers;

import com.natetreimer.greenstep.models.Footprint;
import com.natetreimer.greenstep.services.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.naming.Binding;
import javax.validation.Valid;


@Controller
public class FootprintController {

    @Autowired
    private FootprintService footprintService;

    @GetMapping("/footprint")
    public String viewFootprints(Model model) {
        model.addAttribute("listFootprints", footprintService.getAllFootprints());
        return "footprint";
    }

    @GetMapping("/new_footprint")
    public String createNewFootprint(Model model) {
        Footprint footprint = new Footprint();
        model.addAttribute("footprint", footprint);
        return "new_footprint";
    }

    @PostMapping("/saveFootprint")
    public String saveFootprint(@ModelAttribute("footprint") @Valid Footprint footprint, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new_footprint";
        }
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
