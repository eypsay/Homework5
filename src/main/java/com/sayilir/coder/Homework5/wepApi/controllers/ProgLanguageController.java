package com.sayilir.coder.Homework5.wepApi.controllers;

import com.sayilir.coder.Homework5.business.concretes.ProgLanguageManager;
import com.sayilir.coder.Homework5.business.requests.CreateProgLanguage;
import com.sayilir.coder.Homework5.business.responses.ProgLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ProgLanguageController {

    private final ProgLanguageManager progLanguageManager;

    public ProgLanguageController(ProgLanguageManager progLanguageManager) {
        this.progLanguageManager = progLanguageManager;
    }

    @GetMapping("proglangs")
    public List<ProgLanguageResponse> getAll() {
        return progLanguageManager.getAll();
    }

    @GetMapping("proglang/{id}")
    public ProgLanguageResponse getById(@PathVariable int id) {
        return progLanguageManager.getById(id);
    }

    @PostMapping("add/")
    public void add(@RequestBody CreateProgLanguage createProgLanguage) throws Exception {
        progLanguageManager.add(createProgLanguage);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody CreateProgLanguage createProgLanguage, @PathVariable int id) throws Exception {
        progLanguageManager.update(id, createProgLanguage);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id) {
        progLanguageManager.delete(id);
    }

}
