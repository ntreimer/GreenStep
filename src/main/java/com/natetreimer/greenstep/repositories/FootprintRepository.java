package com.natetreimer.greenstep.repositories;

import com.natetreimer.greenstep.models.Footprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootprintRepository extends JpaRepository<Footprint, Long> {
    Footprint findFootprintById(Long id);
}
