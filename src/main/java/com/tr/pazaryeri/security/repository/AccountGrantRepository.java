package com.tr.pazaryeri.security.repository;

import com.tr.pazaryeri.security.model.AccountGrant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountGrantRepository extends JpaRepository<AccountGrant, Long> {
}

