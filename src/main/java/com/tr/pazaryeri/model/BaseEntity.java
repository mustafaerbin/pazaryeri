package com.tr.pazaryeri.model;

import com.tr.pazaryeri.enumeration.EnumDurum;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @Column
    @GeneratedValue
    private Long id;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
    @Version
    private Long version;

    @Enumerated(EnumType.STRING)
    @Column(name = "DURUM")
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private EnumDurum durum;

    @PrePersist
    public void onPrePersist() {
        setCreateDate(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdateDate(new Date());
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "oid='" + id + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", version=" + version +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity that = (BaseEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getCreateDate() != null ? !getCreateDate().equals(that.getCreateDate()) : that.getCreateDate() != null)
            return false;
        if (getUpdateDate() != null ? !getUpdateDate().equals(that.getUpdateDate()) : that.getUpdateDate() != null)
            return false;
        return getVersion() != null ? getVersion().equals(that.getVersion()) : that.getVersion() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getCreateDate() != null ? getCreateDate().hashCode() : 0);
        result = 31 * result + (getUpdateDate() != null ? getUpdateDate().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        return result;
    }

}

