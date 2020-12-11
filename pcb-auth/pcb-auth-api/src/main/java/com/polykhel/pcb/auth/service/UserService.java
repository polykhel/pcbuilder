package com.polykhel.pcb.auth.service;

import com.polykhel.pcb.dto.UserDTO;
import com.polykhel.pcb.service.BaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService, BaseService<UserDTO> {

    Optional<UserDTO> findByUsername(String username);

    @Override
    UserDTO save(UserDTO userDTO);

}
