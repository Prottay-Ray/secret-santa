package com.secretsanta.groupactivitiesservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NameAvailableOutputDTO {

    private Boolean isAvailable;
    private Boolean inList;
    private Integer listIndex;
    private Long groupId;

}
