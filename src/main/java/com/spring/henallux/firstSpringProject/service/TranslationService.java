package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.dataAccess.dao.TranslationDataAccess;
import com.spring.henallux.firstSpringProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TranslationService {

    private TranslationDataAccess translationDAO;

    @Autowired
    public TranslationService(TranslationDataAccess translationDAO) {
        this.translationDAO = translationDAO;
    }

    public ArrayList<Translation> getCategoriesTranslation(String locale){
        return translationDAO.getCategoryTranslationByLanguage(locale);
    }
}
