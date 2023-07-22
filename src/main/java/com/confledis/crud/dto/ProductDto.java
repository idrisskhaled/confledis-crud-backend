package com.confledis.crud.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends BaseProductDto{
    private UUID id;
}
