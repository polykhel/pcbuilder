package com.polykhel.pcb.service;

import com.polykhel.pcb.dto.BaseDTO;
import com.polykhel.pcb.exception.InvalidEntityException;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseService<D extends BaseDTO> {
    D save(D dto) throws InvalidEntityException;

    void delete(Long id);
}
