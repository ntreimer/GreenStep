package com.natetreimer.greenstep.footprint;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FootprintRepositoryTest {

    @Autowired
    private FootprintRepository footprintRepository;

    @Test
    void getFootprintsByUserId_should_return_footprints_given_valid_userId() {

        List<Footprint> userFootprints = footprintRepository.getFootprintsByUserId(4L);
        Assertions.assertThat(userFootprints.get(0).getUser().getId()).isEqualTo(4L);
    }
}