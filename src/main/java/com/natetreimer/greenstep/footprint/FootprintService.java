package com.natetreimer.greenstep.footprint;

import com.natetreimer.greenstep.footprint.Footprint;

import java.util.List;


public interface FootprintService {

    List<Footprint> getAllFootprints();

    void saveFootprint(Footprint footprint);

    Footprint getFootprintById(Long id);

    void deleteFootprintById(Long id);

    List<Footprint> getFootprintsByUserId(Long id);

}
