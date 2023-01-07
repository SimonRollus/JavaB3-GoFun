package com.spring.henallux.firstSpringProject.dataAccess.repository;


import com.spring.henallux.firstSpringProject.dataAccess.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Integer> {
    @Query("SELECT game FROM GameEntity game WHERE game.category.categoryID = ?1")
    ArrayList<GameEntity> findByCategoryCategoryID(Integer categoryID);
}
