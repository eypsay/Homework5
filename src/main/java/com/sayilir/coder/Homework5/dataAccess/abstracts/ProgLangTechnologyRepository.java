package com.sayilir.coder.Homework5.dataAccess.abstracts;

import com.sayilir.coder.Homework5.entities.concretes.ProgLangTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgLangTechnologyRepository extends JpaRepository<ProgLangTechnology,Integer> {
}
