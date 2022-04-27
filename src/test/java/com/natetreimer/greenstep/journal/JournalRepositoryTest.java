package com.natetreimer.greenstep.journal;


import com.natetreimer.greenstep.footprint.Footprint;
import com.natetreimer.greenstep.footprint.FootprintRepository;
import com.natetreimer.greenstep.security.User;
import com.natetreimer.greenstep.security.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class JournalRepositoryTest {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Test
    void findJournalByUser_should_return_journals_given_valid_user() {

        User user = userRepository.getById(4L);

        List<Journal> userJournals = journalRepository.findJournalByUser(user);
        Assertions.assertThat(userJournals.get(0).getUser()).isEqualTo(user);
    }
}