package com.polykhel.pcb.auth.mapper;

import com.polykhel.pcb.auth.model.User;
import com.polykhel.pcb.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {

    User map(UserDTO userDTO);

    UserDTO map(User user);

}
