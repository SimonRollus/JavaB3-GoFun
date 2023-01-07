package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.LanguageEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.TranslationEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.TranslationRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Language;
import com.spring.henallux.firstSpringProject.model.Translation;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import javax.swing.tree.TreeNode;

import java.lang.reflect.Array;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class TranslationDAOTest {

    private TranslationDAO translationDAO;

    @Mock
    private TranslationRepository translationRepository;
    @Mock
    private ProviderConverter providerConverter;

    @BeforeEach
    public void setUp() throws Exception {
        this.translationDAO = new TranslationDAO(translationRepository, new ProviderConverter());
    }

    public ArrayList<TranslationEntity> mockedTranslationEntities() {

        ArrayList<TranslationEntity> mockedEntities = new ArrayList<>();

        //Common data

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryID(1);

        //FR

        TranslationEntity translationEntityFr = new TranslationEntity();

        translationEntityFr.setTranslationID(1);
        translationEntityFr.setCategory(categoryEntity);
        translationEntityFr.setLabel("Dessin");

        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setLanguageID(1);

        translationEntityFr.setLanguage(languageEntity);

        mockedEntities.add(translationEntityFr);

        // EN

        TranslationEntity translationEntityEn = new TranslationEntity();
        translationEntityEn.setTranslationID(2);

        translationEntityEn.setCategory(categoryEntity);
        translationEntityEn.setLabel("Drawing");
        languageEntity.setLanguageID(2);

        mockedEntities.add(translationEntityEn);

        return mockedEntities;

    }

    public ArrayList<TranslationEntity> mockedCategoriesTranslationFrench() {

        ArrayList<TranslationEntity> mockedCategories = new ArrayList<>();

        // 1

        TranslationEntity translationCategory1 = new TranslationEntity();

        translationCategory1.setTranslationID(1);

        translationCategory1.setCategory(new CategoryEntity());
        translationCategory1.getCategory().setCategoryID(1);

        translationCategory1.setLabel("Déduction");

        translationCategory1.setLanguage(new LanguageEntity());
        translationCategory1.getLanguage().setLanguageID(1);
        mockedCategories.add(translationCategory1);

        // 2

        TranslationEntity translationCategory2 = new TranslationEntity();

        translationCategory2.setTranslationID(3);

        translationCategory2.setCategory(new CategoryEntity());
        translationCategory2.getCategory().setCategoryID(2);

        translationCategory2.setLabel("Dessin");

        translationCategory2.setLanguage(new LanguageEntity());
        translationCategory2.getLanguage().setLanguageID(1);
        mockedCategories.add(translationCategory2);

        // 3

        TranslationEntity translationCategory3 = new TranslationEntity();

        translationCategory3.setTranslationID(5);

        translationCategory3.setCategory(new CategoryEntity());
        translationCategory3.getCategory().setCategoryID(3);

        translationCategory3.setLabel("Stratégie");

        translationCategory3.setLanguage(new LanguageEntity());
        translationCategory3.getLanguage().setLanguageID(1);
        mockedCategories.add(translationCategory3);

        // 4

        TranslationEntity translationCategory4 = new TranslationEntity();

        translationCategory4.setTranslationID(7);

        translationCategory4.setCategory(new CategoryEntity());
        translationCategory4.getCategory().setCategoryID(4);

        translationCategory4.setLabel("Ambiance");

        translationCategory4.setLanguage(new LanguageEntity());
        translationCategory4.getLanguage().setLanguageID(1);
        mockedCategories.add(translationCategory4);

        // 5

        TranslationEntity translationCategory5 = new TranslationEntity();

        translationCategory5.setTranslationID(9);

        translationCategory5.setCategory(new CategoryEntity());
        translationCategory5.getCategory().setCategoryID(5);

        translationCategory5.setLabel("Bluff");

        translationCategory5.setLanguage(new LanguageEntity());
        translationCategory5.getLanguage().setLanguageID(1);
        mockedCategories.add(translationCategory5);

        return mockedCategories;
    }

    public ArrayList<TranslationEntity> mockedCategoriesTranslationEnglish() {

        ArrayList<TranslationEntity> mockedCategories = new ArrayList<>();

        // 1

        TranslationEntity translationCategory1 = new TranslationEntity();

        translationCategory1.setTranslationID(2);

        translationCategory1.setCategory(new CategoryEntity());
        translationCategory1.getCategory().setCategoryID(1);

        translationCategory1.setLabel("Deduction");

        translationCategory1.setLanguage(new LanguageEntity());
        translationCategory1.getLanguage().setLanguageID(2);
        mockedCategories.add(translationCategory1);

        // 2

        TranslationEntity translationCategory2 = new TranslationEntity();

        translationCategory2.setTranslationID(4);

        translationCategory2.setCategory(new CategoryEntity());
        translationCategory2.getCategory().setCategoryID(2);

        translationCategory2.setLabel("Drawing");

        translationCategory2.setLanguage(new LanguageEntity());
        translationCategory2.getLanguage().setLanguageID(2);
        mockedCategories.add(translationCategory2);

        // 3

        TranslationEntity translationCategory3 = new TranslationEntity();

        translationCategory3.setTranslationID(6);

        translationCategory3.setCategory(new CategoryEntity());
        translationCategory3.getCategory().setCategoryID(3);

        translationCategory3.setLabel("Strategy");

        translationCategory3.setLanguage(new LanguageEntity());
        translationCategory3.getLanguage().setLanguageID(2);
        mockedCategories.add(translationCategory3);

        // 4

        TranslationEntity translationCategory4 = new TranslationEntity();

        translationCategory4.setTranslationID(8);

        translationCategory4.setCategory(new CategoryEntity());
        translationCategory4.getCategory().setCategoryID(4);

        translationCategory4.setLabel("Ambiance");

        translationCategory4.setLanguage(new LanguageEntity());
        translationCategory4.getLanguage().setLanguageID(2);
        mockedCategories.add(translationCategory4);

        // 5

        TranslationEntity translationCategory5 = new TranslationEntity();

        translationCategory5.setTranslationID(10);

        translationCategory5.setCategory(new CategoryEntity());
        translationCategory5.getCategory().setCategoryID(5);

        translationCategory5.setLabel("Bluff");

        translationCategory5.setLanguage(new LanguageEntity());
        translationCategory5.getLanguage().setLanguageID(2);
        mockedCategories.add(translationCategory5);

        return mockedCategories;
    }

    @Test
    public void testCategoriesFrench(){
        String expectedCategory1 = "Déduction";
        String expectedCategory2 = "Dessin";
        String expectedCategory3 = "Stratégie";
        String expectedCategory4 = "Ambiance";
        String expectedCategory5 = "Bluff";

        LanguageEntity categoryFr = new LanguageEntity();
        categoryFr.setLanguageID(1);

        Language languageFrench = new Language();
        languageFrench.setLanguageID(1);

        when(translationRepository.findByLocale(categoryFr.getLocale())).thenReturn(mockedCategoriesTranslationFrench());

        ArrayList<Translation> translations = translationDAO.getCategoryTranslationByLanguage(languageFrench.getLocale());
        Optional<Translation> translation1 = translations.stream().filter(t -> t.getTranslationID() == 1).findFirst();
        Optional<Translation> translation2 = translations.stream().filter(t -> t.getTranslationID() == 3).findFirst();
        Optional<Translation> translation3 = translations.stream().filter(t->t.getTranslationID() == 5).findFirst();
        Optional<Translation> translation4 = translations.stream().filter(t->t.getTranslationID() == 7).findFirst();
        Optional<Translation> translation5 = translations.stream().filter(t->t.getTranslationID() == 9).findFirst();
        assertEquals(5,translations.size());
        assertEquals(expectedCategory1,translation1.isPresent()?translation1.get().getLabel() :"");
        assertEquals(expectedCategory2,translation2.isPresent()? translation2.get().getLabel():"");
        assertEquals(expectedCategory3,translation3.isPresent()?translation3.get().getLabel():"");
        assertEquals(expectedCategory4,translation4.isPresent()?translation4.get().getLabel():"");
        assertEquals(expectedCategory5,translation5.isPresent()?translation5.get().getLabel():"");
    }

    @Test
    public void testCategoriesEnglish(){
        String expectedCategory1 = "Deduction";
        String expectedCategory2 = "Drawing";
        String expectedCategory3 = "Strategy";
        String expectedCategory4 = "Ambiance";
        String expectedCategory5 = "Bluff";

        LanguageEntity categoryEn = new LanguageEntity();
        categoryEn.setLanguageID(1);

        Language languageEnglish = new Language();
        languageEnglish.setLanguageID(1);

        when(translationRepository.findByLocale(categoryEn.getLocale())).thenReturn(mockedCategoriesTranslationEnglish());

        ArrayList<Translation> translations = translationDAO.getCategoryTranslationByLanguage(languageEnglish.getLocale());
        Optional<Translation> translation1 = translations.stream().filter(t -> t.getTranslationID() == 2).findFirst();
        Optional<Translation> translation2 = translations.stream().filter(t -> t.getTranslationID() == 4).findFirst();
        Optional<Translation> translation3 = translations.stream().filter(t->t.getTranslationID() == 6).findFirst();
        Optional<Translation> translation4 = translations.stream().filter(t->t.getTranslationID() == 8).findFirst();
        Optional<Translation> translation5 = translations.stream().filter(t->t.getTranslationID() == 10).findFirst();
        assertEquals(5,translations.size());
        assertEquals(expectedCategory1,translation1.isPresent()?translation1.get().getLabel() :"");
        assertEquals(expectedCategory2,translation2.isPresent()? translation2.get().getLabel():"");
        assertEquals(expectedCategory3,translation3.isPresent()?translation3.get().getLabel():"");
        assertEquals(expectedCategory4,translation4.isPresent()?translation4.get().getLabel():"");
        assertEquals(expectedCategory5,translation5.isPresent()?translation5.get().getLabel():"");
    }
}