package com.polykhel.pcb.auth.model;

import com.polykhel.pcb.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "permission")
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity {

    @Column(name = "name")
    private String name;

}
