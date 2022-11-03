package com.sayilir.coder.Homework5.business.concretes;

import com.sayilir.coder.Homework5.business.abstracts.ProgLanguageService;
import com.sayilir.coder.Homework5.business.requests.CreateProgLanguage;
import com.sayilir.coder.Homework5.business.responses.ProgLanguageResponse;
import com.sayilir.coder.Homework5.dataAccess.abstracts.ProgLangTechnologyRepository;
import com.sayilir.coder.Homework5.dataAccess.abstracts.ProgLanguageRepository;
import com.sayilir.coder.Homework5.entities.concretes.ProgLanguage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgLanguageManager implements ProgLanguageService {

    private final ProgLanguageRepository progLanguageRepository;
    private final ProgLangTechnologyRepository progLangTechnologyRepository;

    public ProgLanguageManager(ProgLanguageRepository progLanguageRepository, ProgLangTechnologyRepository progLangTechnologyRepository) {
        this.progLanguageRepository = progLanguageRepository;
        this.progLangTechnologyRepository = progLangTechnologyRepository;
    }


    @Override
    public List<ProgLanguageResponse> getAll() {
        List<ProgLanguage> progLanguages = progLanguageRepository.findAll();
        List<ProgLanguageResponse> progLanguageResponses = progLanguages
                .stream()
                .map((progLanguage) -> new ProgLanguageResponse(progLanguage.getId(),
                        progLanguage.getName(),
                        progLanguage.getProgLangTechnologies()
                                .stream()
                                .map(tech -> tech.getName())
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());
        return progLanguageResponses;
    }

    @Override
    public ProgLanguageResponse getById(int id) {
        ProgLanguage progLanguage = progLanguageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prog Langugage couldn't find by id: " + id));
        ProgLanguageResponse progLanguageResponse = new ProgLanguageResponse();
        progLanguageResponse.setId(progLanguage.getId());
        progLanguageResponse.setName(progLanguage.getName());
        progLanguageResponse.setProgLangTechnologyNames(progLanguage.getProgLangTechnologies()
                .stream()
                .map(tech -> tech.getName())
                .collect(Collectors.toList()));
        return progLanguageResponse;
    }

    @Override
    public void add(CreateProgLanguage createProgLanguage) throws Exception {
        if (nameIsExisting(createProgLanguage)) {
            throw new Exception("Entered Programming Language is exist!!! name:" + createProgLanguage.getName());
        } else {
            ProgLanguage progLanguage = new ProgLanguage();
            progLanguage.setName(createProgLanguage.getName());
            progLanguageRepository.save(progLanguage);
        }
    }

    @Override
    public void update(int id, CreateProgLanguage createProgLanguage) throws Exception {
        ProgLanguage progLanguage = progLanguageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prog Langugage couldn't find by id: " + id));

        if (nameIsExisting(createProgLanguage)) {
            throw new Exception("Entered Programming Language is exist!!! name:" + createProgLanguage.getName());
        }
        progLanguage.setName(createProgLanguage.getName());
        progLanguageRepository.save(progLanguage);
    }

    @Override
    public void delete(int id) {
        progLanguageRepository.deleteById(id);
    }

    private boolean nameIsExisting(CreateProgLanguage createProgLanguage) {
        List<ProgLanguage> progLanguages = progLanguageRepository.findAll();
        boolean isNameExist = progLanguages.stream().anyMatch(x -> x.getName().equals(createProgLanguage.getName()));
        return isNameExist;
    }
}
