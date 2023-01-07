package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    @Query("SELECT translation from TranslationEntity translation WHERE translation.language.locale = ?1")
    ArrayList<TranslationEntity> findByLocale(String locale);

}
