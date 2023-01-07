package com.spring.henallux.firstSpringProject.dataAccess.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class LanguageEntity {

    @Id
    @Column(name="language_id")
    private Integer languageID;

    @Column(name="locale")
    private String locale;


    public LanguageEntity() {
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
