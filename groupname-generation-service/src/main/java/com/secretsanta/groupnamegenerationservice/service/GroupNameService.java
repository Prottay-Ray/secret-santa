package com.secretsanta.groupnamegenerationservice.service;

import com.secretsanta.groupnamegenerationservice.dto.*;
import org.springframework.stereotype.Service;


public interface GroupNameService {

    //Implementing the principle of "code to interface not to implementation" and adhering to SOLID principles.

    public RandomGroupNameDTO getGroupName();

    public AssignNameOutputDTO assignGroupName(AssignNameInputDTO nameInputDTO);

    public NameAvailableOutputDTO checkName(RandomGroupNameDTO groupNameDTO);

    public ReleaseNameOutputDTO releaseGroupName(AssignNameInputDTO nameInputDTO);

}
