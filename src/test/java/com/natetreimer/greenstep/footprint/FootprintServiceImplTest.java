package com.natetreimer.greenstep.footprint;


import com.natetreimer.greenstep.security.Role;
import com.natetreimer.greenstep.security.User;
import com.natetreimer.greenstep.security.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FootprintServiceImplTest {

    @Autowired
    private FootprintService footprintService;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Test
    void getAllFootprints() {
        // arrange
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User user = new User();
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("Email");
        user.setPassword(passwordEncoder.encode("Password"));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        userRepository.save(user);

        // act and assert
        List<Footprint> allFootprints = footprintService.getAllFootprints();
        int beforeAddingMoreFootprints = allFootprints.size();

        Footprint footprint1 = new Footprint();
        footprint1.setUser(user);
        footprint1.setWeight(140.0);
        footprint1.setYear(1999L);
        footprintService.saveFootprint(footprint1);
        int afterAddingMoreFootprints = footprintService.getAllFootprints().size();

        Assertions.assertThat(afterAddingMoreFootprints).isEqualTo(beforeAddingMoreFootprints + 1);
        Assertions.assertThat(allFootprints.contains(footprint1));

        // verify
    }

    @Test
    void getFootprintById() {
        List<Footprint> allFootprints = footprintService.getAllFootprints();
        Footprint footprint1 = allFootprints.get(0);
        if (footprint1 != null) {
            Footprint footprint2 = footprintService.getFootprintById(footprint1.getId());
            Assertions.assertThat(footprint1).isEqualTo(footprint2);
        }
    }
}