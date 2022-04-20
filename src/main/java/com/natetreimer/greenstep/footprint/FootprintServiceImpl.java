package com.natetreimer.greenstep.footprint;

import com.natetreimer.greenstep.footprint.Footprint;
import com.natetreimer.greenstep.footprint.FootprintRepository;
import com.natetreimer.greenstep.footprint.FootprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public void deleteFootprintById(Long id) {
        this.footprintRepository.deleteById(id);
    }


    @Override
    public List<Footprint> getFootprintsByUserId(Long id) {
        return this.footprintRepository.getFootprintsByUserId(id);
    }

}
