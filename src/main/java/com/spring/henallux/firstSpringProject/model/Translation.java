package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.*;

public class Translation {
    @NotNull
    @Min(value = 1)
    private Integer translationID;
    @NotNull
    @Size(min = 5, max = 50)
    private String label;
    @NotNull
    private Language language;
    @NotNull
    private Category category;

    public Translation(Integer translationID, String label, Language language, Category category) {
        this.translationID = translationID;
        this.label = label;
        this.language = language;
        this.category = category;
    }

    public Translation() {
    }

    public Integer getTranslationID() {
        return translationID;
    }

    public String getLabel() {
        return label;
    }

    public Language getLanguage() {
        return language;
    }

    public Category getCategory() {
        return category;
    }

    public void setTranslationID(Integer translationID) {
        this.translationID = translationID;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
