package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Footprint;
import com.natetreimer.greenstep.repositories.FootprintRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FootprintServiceImpl implements FootprintService {

    @Autowired
    private FootprintRepository footprintRepository;

    @Override
    public List<Footprint> getAllFootprints() {
        return footprintRepository.findAll();
    }

    @Override
    public void saveFootprint(Footprint footprint) {
        this.footprintRepository.save(footprint);
    }

    @Override
    public Footprint getFootprintById(Long id) {
        Optional<Footprint> optional = footprintRepository.findById(id);
        Footprint footprint = null;
        if (optional.isPresent()) {
            footprint = optional.get();
        } else {
            throw new RuntimeException("Footprint not found for id :: " + id);
        }
        return footprint;
    }

    @Override
    public void deleteFootprintById(Footprint footprint) {

    }
}
