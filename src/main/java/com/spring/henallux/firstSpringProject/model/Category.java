package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.*;

public class Category {
    private Integer categoryI;

    @NotNull
    @Min(value = 1)
    public Category(){
    }

    public Integer getCategoryID() {
        return categoryI;
    }

    public void setCategoryID(Integer categoryI) {
        this.categoryI = categoryI;
    }
}
