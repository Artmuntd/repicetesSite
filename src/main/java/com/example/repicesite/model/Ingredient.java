package com.example.repicesite.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private  String title;
    private  int number;
    private  String measure;

    public void setTitle(String title) {
        StringUtils.isBlank(title);
    }
}
