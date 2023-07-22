package com.confledis.crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseProductDto {
    private Boolean isAvailable= true;
    private Date expiryDate;
    private Integer nbAvailable = 0;
    private Integer nbTotal = 0;
    private String name;
}
