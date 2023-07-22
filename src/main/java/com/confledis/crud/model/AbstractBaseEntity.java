package com.confledis.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class AbstractBaseEntity implements Serializable {


    @Column(name = "creation_date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime creationDate = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "last_update_date", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdateDate = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        LocalDateTime currentDate = LocalDateTime.now();
        this.creationDate = currentDate;
        this.lastUpdateDate = currentDate;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = LocalDateTime.now();
    }

}

