package com.sayilir.coder.Homework5.entities.concretes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "proglanguagetechs")
@Getter
@Setter
@NoArgsConstructor
public class ProgLangTechnology {

    public ProgLangTechnology(String name) {
        this.name = name;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "proglangid")
    private ProgLanguage progLanguage;


    /* MANY-TO-MANY STRUCTURE
    @ManyToMany(mappedBy = "progLangTechnologies",fetch = FetchType.LAZY)
    private List<ProgLanguage> progLanguages;
    */

}
