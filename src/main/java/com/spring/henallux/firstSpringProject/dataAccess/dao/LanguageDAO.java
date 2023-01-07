package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.LanguageRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Language;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LanguageDAO implements LanguageDataAccess {

    private LanguageRepository languageRepository;

    private ProviderConverter providerConverter;

    @Autowired
    public LanguageDAO(LanguageRepository languageRepository, ProviderConverter providerConverter){
        this.languageRepository=languageRepository;
        this.providerConverter=providerConverter;
    }

    public Language getLanguage(Integer id){
        Optional<LanguageEntity> languageEntity = languageRepository.findById(id);
        if(languageEntity.isPresent()){
            return providerConverter.languageEntityToLanguageModel(languageEntity.get());
        }else{
            return null;
        }
    }


}
