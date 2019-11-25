package com.hachicore.commonweb;

import com.hachicore.commonweb.post.Account;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditAware implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        // Spring Security Context 에서 현재 정보 가져올 것
        System.out.println("looking for current user");
        return Optional.empty();
    }
}
