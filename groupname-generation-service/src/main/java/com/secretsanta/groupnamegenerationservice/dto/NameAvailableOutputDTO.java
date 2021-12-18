package com.secretsanta.groupnamegenerationservice.dto;

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
