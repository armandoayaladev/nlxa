package com.nlxa.java.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "level")
public class Level implements Serializable {

    //<editor-fold desc="Attributes">

    @Id
    @Column(name = "level_id")
    @GeneratedValue(generator = "ID")
    @GenericGenerator(
            name = "ID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String levelId;

    @Column(name = "description")
    private String description;

    //</editor-fold>

    //<editor-fold desc="Contructor">

    public Level() {}

    //</editor-fold>

}
