package com.natetreimer.greenstep.footprint;

import com.natetreimer.greenstep.footprint.Footprint;
import com.natetreimer.greenstep.footprint.FootprintRepository;
import com.natetreimer.greenstep.footprint.FootprintService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootprintServiceImpl implements FootprintService {

    private static final Logger log = LoggerFactory.getLogger(FootprintServiceImpl.class);

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
        log.info("getFootprintById successful");
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
