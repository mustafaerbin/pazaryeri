package com.tr.pazaryeri.security.model;

import com.tr.pazaryeri.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Data
@Entity(name = "HESAP_ROL")
public class AccountRole extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name; // ROLE_USER, ROLE_ADMIN vb.

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<AccountUser> users;


}
