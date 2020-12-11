package com.polykhel.pcb.auth.config;

import com.polykhel.pcb.model.BaseEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;

@Configuration
public class SpringDataRestConfiguration implements RepositoryRestConfigurer {

    private final EntityManager entityManager;

    public SpringDataRestConfiguration(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.setDefaultMediaType(MediaType.APPLICATION_JSON);
        config.exposeIdsFor(
                entityManager.getMetamodel().getEntities().stream()
                        .map(Type::getJavaType)
                        .filter(BaseEntity.class::isAssignableFrom)
                        .toArray(Class[]::new)
        );
    }
}
