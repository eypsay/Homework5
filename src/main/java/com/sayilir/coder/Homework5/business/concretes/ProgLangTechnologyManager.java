package com.sayilir.coder.Homework5.business.concretes;

import com.sayilir.coder.Homework5.business.abstracts.ProgLangTechnologyService;
import com.sayilir.coder.Homework5.business.requests.CreateProgLangTech;
import com.sayilir.coder.Homework5.business.responses.ProgLangTechResponse;
import com.sayilir.coder.Homework5.dataAccess.abstracts.ProgLangTechnologyRepository;
import com.sayilir.coder.Homework5.dataAccess.abstracts.ProgLanguageRepository;
import com.sayilir.coder.Homework5.entities.concretes.ProgLangTechnology;
import com.sayilir.coder.Homework5.entities.concretes.ProgLanguage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgLangTechnologyManager implements ProgLangTechnologyService {
    private final ProgLangTechnologyRepository progLangTechnologyRepository;
    private final ProgLanguageRepository progLanguageRepository;

    public ProgLangTechnologyManager(ProgLangTechnologyRepository progLangTechnologyRepository, ProgLanguageRepository progLanguageRepository) {
        this.progLangTechnologyRepository = progLangTechnologyRepository;
        this.progLanguageRepository = progLanguageRepository;
    }

    @Override
    public List<ProgLangTechResponse> getAll() {
        List<ProgLangTechnology> langTechnology = progLangTechnologyRepository.findAll();

        List<ProgLangTechResponse> progLangTechResponse = langTechnology.stream()
                .map(langtech -> new ProgLangTechResponse(langtech.getId(), langtech.getName()))
                .collect(Collectors.toList());

        return progLangTechResponse;
    }

    @Override
    public ProgLangTechResponse getById(int id) {
        ProgLangTechnology langTechnology = progLangTechnologyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prog Langugage Technology couldn't find by id: " + id));

        ProgLangTechResponse progLangTechResponse = new ProgLangTechResponse();
        progLangTechResponse.setId(langTechnology.getId());
        progLangTechResponse.setName(langTechnology.getName());

        return progLangTechResponse;

    }

    @Override
    public void add(CreateProgLangTech createProgLangTech) throws Exception {
        ProgLanguage progLanguage = progLanguageRepository.findById(createProgLangTech.getProgLanguageId())
                .orElseThrow(() -> new RuntimeException("Prog Langugage couldn't find by id: " + createProgLangTech.getProgLanguageId()));
        if (nameIsExisting(createProgLangTech)) {
            throw new Exception("Entered Technolgy name is exist!!! :" + createProgLangTech.getName());
        } else {
            ProgLangTechnology progLangTechnology = new ProgLangTechnology();
            progLangTechnology.setName(createProgLangTech.getName());
            progLangTechnology.setProgLanguage(progLanguage);

            progLangTechnologyRepository.save(progLangTechnology);
        }
    }

    @Override
    public void update(int id, CreateProgLangTech createProgLangTech) throws Exception {
        ProgLangTechnology langTechnology = progLangTechnologyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prog Langugage Technology couldn't find by id: " + id));
        if (nameIsExisting(createProgLangTech)) {
            throw new Exception("Entered Technolgy name is exist!!! :" + createProgLangTech.getName());
        } else {
            langTechnology.setName(createProgLangTech.getName());
            progLangTechnologyRepository.save(langTechnology);
        }
    }

    @Override
    public void delete(int id) {
        progLangTechnologyRepository.deleteById(id);
    }

    private boolean nameIsExisting(CreateProgLangTech createProgLangTech) {
        List<ProgLangTechnology> langTechnologies = progLangTechnologyRepository.findAll();
        boolean isNameExist = langTechnologies.stream().anyMatch(x -> x.getName().equals(createProgLangTech.getName()));
        return isNameExist;
    }
}
