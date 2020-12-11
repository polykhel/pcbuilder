package com.polykhel.pcb.auth.mapper;

import com.polykhel.pcb.auth.model.Role;
import com.polykhel.pcb.dto.RoleDTO;
import org.mapstruct.Mapper;

@Mapper(uses = PermissionMapper.class)
public interface RoleMapper {

    RoleDTO map(Role role);

    Role map(RoleDTO roleDTO);
}
