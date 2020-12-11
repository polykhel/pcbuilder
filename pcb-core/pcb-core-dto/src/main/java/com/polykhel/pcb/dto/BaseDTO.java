package com.polykhel.pcb.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDTO {

    /**
     * Unique identifier for the object.
     */
    private Long id;

    /**
     * Date and time when the entity was created.
     */
    private LocalDateTime createdDate;

    /**
     * Date and time when the entity was last updated.
     */
    private LocalDateTime updatedDate;

    /**
     * Username of the user who created the entity.
     */
    private String createdBy;

    /**
     * Username of the last user who updated the entity.
     */
    private String updatedBy;
}
