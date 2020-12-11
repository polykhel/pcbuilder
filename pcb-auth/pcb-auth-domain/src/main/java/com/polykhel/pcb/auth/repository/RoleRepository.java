package com.polykhel.pcb.auth.repository;

import com.polykhel.pcb.auth.model.Role;
import com.polykhel.pcb.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "role")
public interface RoleRepository extends BaseRepository<Role> {
}
