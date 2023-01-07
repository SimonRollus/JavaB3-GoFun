package com.spring.henallux.firstSpringProject.service;


import com.spring.henallux.firstSpringProject.dataAccess.dao.GameDataAccess;
import com.spring.henallux.firstSpringProject.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService {
    private GameDataAccess gameDAO;


    @Autowired
    public GameService(GameDataAccess gameDAO) {
        this.gameDAO = gameDAO;
    }

    public ArrayList<Game> getAllGames(){
        return gameDAO.getAllGames();
    }

    public Game getGameByID(Integer gameID){
        return gameDAO.getGameByID(gameID);
    }

    public ArrayList<Game> getAllGamesByCategoryID(Integer categoryID){
        return gameDAO.getAllGamesByCategoryID(categoryID);
    }

}
