package com.natetreimer.greenstep.repositories;

import com.natetreimer.greenstep.models.Footprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootprintRepository extends JpaRepository<Footprint, Long> {
    Footprint findFootprintById(Long id);

    @Query("SELECT f FROM Footprint f WHERE user_id=:userIdParam")
    public abstract List<Footprint> getFootprintsByUserId(@Param("userIdParam") Long id);
}
