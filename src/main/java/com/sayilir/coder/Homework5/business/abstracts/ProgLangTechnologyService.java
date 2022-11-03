package com.sayilir.coder.Homework5.business.abstracts;

import com.sayilir.coder.Homework5.business.requests.CreateProgLangTech;
import com.sayilir.coder.Homework5.business.responses.ProgLangTechResponse;

import java.util.List;

public interface ProgLangTechnologyService {
    List<ProgLangTechResponse> getAll();

    ProgLangTechResponse getById(int id);

    void add(CreateProgLangTech createProgLangTech) throws Exception;

    void update(int id, CreateProgLangTech createProgLangTech) throws Exception;

    void delete(int id);

}
