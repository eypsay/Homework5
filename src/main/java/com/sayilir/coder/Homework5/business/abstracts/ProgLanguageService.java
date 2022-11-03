package com.sayilir.coder.Homework5.business.abstracts;

import com.sayilir.coder.Homework5.business.requests.CreateProgLanguage;
import com.sayilir.coder.Homework5.business.responses.ProgLanguageResponse;

import java.util.List;

public interface ProgLanguageService {
    List<ProgLanguageResponse> getAll();

    ProgLanguageResponse getById(int id);

    void add(CreateProgLanguage createProgLanguage) throws Exception;

    void update(int id, CreateProgLanguage createProgLanguage) throws Exception;

    void delete(int id);
}
