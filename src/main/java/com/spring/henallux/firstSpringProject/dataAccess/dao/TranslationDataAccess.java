package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Translation;

import java.util.ArrayList;

public interface TranslationDataAccess {

    ArrayList<Translation> getAllTranslations();
    ArrayList<Translation> getCategoryTranslationByLanguage(String locale);

}
