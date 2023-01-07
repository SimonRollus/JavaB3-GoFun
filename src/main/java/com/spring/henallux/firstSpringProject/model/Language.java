package com.spring.henallux.firstSpringProject.model;
import javax.validation.constraints.*;

public class Language {

    @NotNull
    @Min(value = 1)
    private Integer languageID;

    private String locale;

    public Language() {
    }

    public Integer getLanguageID() {
        return languageID;
    }

    public String getLocale() {
        return locale;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
