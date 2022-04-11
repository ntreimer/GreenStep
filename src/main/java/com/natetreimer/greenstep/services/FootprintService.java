package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Footprint;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FootprintService {

    List<Footprint> getAllFootprints();

    void saveFootprint(Footprint footprint);

    Footprint getFootprintById(Long id);

    void deleteFootprintById(Long id);

}
