package com.polykhel.pcb.service;

import com.polykhel.pcb.dto.BaseDTO;
import com.polykhel.pcb.exception.InvalidEntityException;
import com.polykhel.pcb.exception.UnknownEntityException;
import com.polykhel.pcb.model.BaseEntity;
import com.polykhel.pcb.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class BaseServiceImpl<E extends BaseEntity, D extends BaseDTO, R extends BaseRepository<E>>
        implements BaseService<D> {

    protected R repo;

    public BaseServiceImpl(R repo) {
        this.repo = repo;
    }

    @Transactional
    public D save(D dto) throws InvalidEntityException {
        if (!isValid(dto)) {
            throw new InvalidEntityException(dto.toString());
        }
        E entity = toEntity(dto);
        E saved = repo.save(entity);
        return toDto(saved);
    }

    @Transactional
    public void delete(Long id) {
        Optional<E> optionalD = repo.findById(id);
        if (optionalD.isEmpty()) {
            throw new UnknownEntityException("Entity", id);
        } else {
            E entity = optionalD.get();
            repo.delete(entity);
        }
    }

    protected abstract D toDto(E entity);

    protected abstract E toEntity(D dto);

    protected boolean isValid(D dto) {
        return true;
    }

}
