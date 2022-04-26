package com.natetreimer.greenstep.footprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class FootprintRestController {

    @Autowired
    private FootprintService footprintService;


    @GetMapping("/RESTFootprintGET")
    public List<Footprint> getAllFootprints() {
        return footprintService.getAllFootprints();
    }

    @PostMapping("/RESTFootprintPOST")
    public void addEmployee(@RequestBody Footprint footprint) {
        footprintService.saveFootprint(footprint);
    }

}
