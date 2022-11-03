package com.sayilir.coder.Homework5.entities.concretes;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proglanguages")
@Getter
@Setter
@NoArgsConstructor
public class ProgLanguage {

    public ProgLanguage(String name) {
        this.name = name;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "progLanguage")
   private List<ProgLangTechnology> progLangTechnologies;


      /* MANY-TO-MANY STRUCTURE
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "LANG_TECH_TABLE",
            joinColumns = {
                    @JoinColumn(name = "lang_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "tech_id", referencedColumnName = "id")
            }
    )
    private List<ProgLangTechnology> progLangTechnologies;
    */
}
