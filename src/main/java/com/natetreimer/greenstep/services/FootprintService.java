package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Footprint;

import java.util.List;

public interface FootprintService {

    List<Footprint> getAllFootprints();

    void saveFootprint(Footprint footprint);

    Footprint getFootprintById(Long id);

    void deleteFootprintById(Footprint footprint);

}
