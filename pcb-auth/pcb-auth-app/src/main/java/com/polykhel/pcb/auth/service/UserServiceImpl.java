package com.polykhel.pcb.auth.service;

import com.polykhel.pcb.auth.mapper.UserMapper;
import com.polykhel.pcb.auth.model.User;
import com.polykhel.pcb.auth.repository.UserRepository;
import com.polykhel.pcb.dto.UserDTO;
import com.polykhel.pcb.service.BaseServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDTO, UserRepository> implements UserService {

    private final UserMapper mapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        super(userRepository);
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return repo.findByUsername(username).map(mapper::map);
    }

    @Override
    protected UserDTO toDto(User entity) {
        return mapper.map(entity);
    }

    @Override
    protected User toEntity(UserDTO dto) {
        return mapper.map(dto);
    }
}
