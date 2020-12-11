package com.polykhel.pcb.auth.mapper;

import com.polykhel.pcb.auth.model.Permission;
import com.polykhel.pcb.dto.PermissionDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PermissionMapper {

    PermissionDTO map(Permission permission);

    Permission map(PermissionDTO permissionDTO);

}
