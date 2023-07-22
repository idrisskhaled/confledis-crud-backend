package com.confledis.crud.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "T_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product extends AbstractBaseEntity{
    @Id
    private UUID id;

    @Column
    private String name;

    @NonNull
    @Column(columnDefinition = "Boolean default true")
    private Boolean isAvailable= true;

    @Column
    private Date expiryDate;

    @Column(columnDefinition = "INT default 0")
    @NonNull
    private Integer nbAvailable = 0;

    @Column(columnDefinition = "INT default 0")
    @NonNull
    private Integer nbTotal = 0;

}
