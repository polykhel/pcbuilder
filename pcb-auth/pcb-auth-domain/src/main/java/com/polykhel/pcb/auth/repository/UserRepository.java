package com.polykhel.pcb.auth.repository;

import com.polykhel.pcb.auth.model.User;
import com.polykhel.pcb.repository.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUsername(String username);

}
