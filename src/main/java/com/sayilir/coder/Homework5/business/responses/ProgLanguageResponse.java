package com.sayilir.coder.Homework5.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgLanguageResponse {

    private int id;
    private String name;
    private List<String> progLangTechnologyNames;

}
