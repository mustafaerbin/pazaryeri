package com.tr.pazaryeri.security.service;

import com.tr.pazaryeri.security.model.AccountUser;
import com.tr.pazaryeri.security.repository.AccountUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Transactional
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountUserRepository accountUserRepository;

    public AccountUserDetailsService(AccountUserRepository accountUserRepository) {
        this.accountUserRepository = accountUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        AccountUser accountUser = accountUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Role ve permission'ları da ekleyebilirsiniz

        User user = new User(accountUser.getUsername(), accountUser.getPassword(), accountUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList()));

        return user;
    }
}

