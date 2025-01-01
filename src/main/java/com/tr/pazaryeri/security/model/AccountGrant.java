package com.tr.pazaryeri.security.model;

import com.tr.pazaryeri.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "HESAP_YETKI")
@Entity
public class AccountGrant extends BaseEntity {

    @Column(name = "grant_code", length = 100, nullable = false, unique = true)
    private String grantCode;

    @Column(name = "grant_name", length = 255, nullable = false)
    private String grantName;

    private String permission; // Örneğin: "READ_PRIVILEGES", "WRITE_PRIVILEGES"

    @ManyToOne
    @JoinColumn(name = "role_id")
    private AccountRole role;

    public String getAuthority() {
        return grantCode;
    }

}
