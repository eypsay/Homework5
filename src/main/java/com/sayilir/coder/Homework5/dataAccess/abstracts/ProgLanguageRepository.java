package com.sayilir.coder.Homework5.dataAccess.abstracts;

import com.sayilir.coder.Homework5.entities.concretes.ProgLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgLanguageRepository extends JpaRepository<ProgLanguage, Integer> {
}
