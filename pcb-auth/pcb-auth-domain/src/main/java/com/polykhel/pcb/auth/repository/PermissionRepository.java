package com.polykhel.pcb.auth.repository;

import com.polykhel.pcb.auth.model.Permission;
import com.polykhel.pcb.repository.BaseRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "permission")
public interface PermissionRepository extends BaseRepository<Permission> {
}
