package com.sayilir.coder.Homework5.wepApi.controllers;

import com.sayilir.coder.Homework5.business.concretes.ProgLangTechnologyManager;
import com.sayilir.coder.Homework5.business.requests.CreateProgLangTech;
import com.sayilir.coder.Homework5.business.responses.ProgLangTechResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/proglangtechs")
public class ProgLangTechnologyController {

    private final ProgLangTechnologyManager progLangTechnologyManager;

    public ProgLangTechnologyController(ProgLangTechnologyManager progLangTechnologyManager) {
        this.progLangTechnologyManager = progLangTechnologyManager;
    }

    @GetMapping("/")
    public List<ProgLangTechResponse> getAll() {
        return progLangTechnologyManager.getAll();
    }

    @GetMapping("/id")
    public ProgLangTechResponse getById(int id) {
        return progLangTechnologyManager.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgLangTech createProgLangTech) throws Exception {
        progLangTechnologyManager.add(createProgLangTech);
    }

    @PutMapping("/update")
    public void update(int id, CreateProgLangTech createProgLangTech) throws Exception {
        progLangTechnologyManager.update(id, createProgLangTech);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        progLangTechnologyManager.delete(id);
    }
}
