package com.natetreimer.greenstep.services;

import com.natetreimer.greenstep.models.Footprint;
import com.natetreimer.greenstep.repositories.FootprintRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
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
        System.out.println("this is the id you were looking for" + id);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // find courses where student email matches
        Query query = session.createQuery(
                "SELECT f FROM Footprint f " +
                        "where user_id=:userIdParam"

        );
        query.setParameter("userIdParam", id.toString());

        List<Footprint> footprints = query.getResultList();

        System.out.println(footprints);

        tx.commit();
        session.close();
        factory.close();
        return footprints;
    }
}
