package com.hachicore.querydsldemo.account;

import com.querydsl.core.types.Predicate;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud() throws Exception {
        // given
        QAccount account = QAccount.account;
        Predicate predicate = account.firstName.containsIgnoreCase("rokuthread")
                .and(account.lastName.startsWith("hachicore"));

        // when
        Optional<Account> one = accountRepository.findOne(predicate);

        // then
        assertThat(one).isEmpty();
    }

}