package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationDAO implements TranslationDataAccess {

    private TranslationRepository translationRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProviderConverter providerConverter) {
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Translation> getAllTranslations(){
        List<TranslationEntity> translationEntities = translationRepository.findAll();
        ArrayList<Translation> translations = new ArrayList<>();
        for (TranslationEntity entity : translationEntities) {
            Translation translation = providerConverter.translationEntityToTranslationModel(entity);
            translations.add(translation);
        }
        return translations;
    }

    public ArrayList<Translation> getCategoryTranslationByLanguage(String locale){
        List<TranslationEntity> translationEntities = translationRepository.findByLocale(locale);
        ArrayList<Translation> translations = new ArrayList<>();
        for (TranslationEntity entity : translationEntities) {
            Translation translation = providerConverter.translationEntityToTranslationModel(entity);
            translations.add(translation);
        }
        return translations;
    }




}
