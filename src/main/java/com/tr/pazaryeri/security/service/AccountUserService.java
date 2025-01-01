package com.tr.pazaryeri.security.service;

import com.tr.pazaryeri.enumeration.EnumDurum;
import com.tr.pazaryeri.security.model.AccountRole;
import com.tr.pazaryeri.security.model.AccountUser;
import com.tr.pazaryeri.security.repository.AccountRoleRepository;
import com.tr.pazaryeri.security.repository.AccountUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Transactional
public class AccountUserService {

    private final AccountUserRepository accountUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccountRoleRepository accountRoleRepository;

    public AccountUserService(AccountUserRepository accountUserRepository, PasswordEncoder passwordEncoder, AccountRoleRepository accountRoleRepository) {
        this.accountUserRepository = accountUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.accountRoleRepository = accountRoleRepository;
    }

    public AccountUser registerUser(String username, String rawPassword, String name, String surname) {

        AccountRole role = new AccountRole();
        role.setName("ADMIN");
        role.setName("Admin");
        role.setDurum(EnumDurum.AKTIF);
        accountRoleRepository.save(role);

        AccountUser user = new AccountUser();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword)); // Şifreyi hash'le
        user.setName(name);
        user.setSurname(surname);
        user.setActive(true); // Varsayılan olarak aktif
        user.setDurum(EnumDurum.AKTIF);
        // Eğer roller boşsa yeni bir Set başlat
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }
        user.getRoles().add(role);
        accountUserRepository.save(user);

        return user;
    }

}

