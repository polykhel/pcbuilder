package com.polykhel.pcb.repository;

import com.polykhel.pcb.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity>
        extends JpaRepository<T, Long>, PagingAndSortingRepository<T, Long>, QuerydslPredicateExecutor<T> {
}
