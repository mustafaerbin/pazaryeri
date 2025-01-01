package com.tr.pazaryeri.security.repository;

import com.tr.pazaryeri.security.model.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {

    Optional<AccountRole> findByName(String name);

}

