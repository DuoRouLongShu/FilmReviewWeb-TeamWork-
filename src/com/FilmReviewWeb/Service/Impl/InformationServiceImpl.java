package com.FilmReviewWeb.Service.Impl;

import com.FilmReviewWeb.Dao.InformationDao;
import com.FilmReviewWeb.Model.Information;
import com.FilmReviewWeb.Service.InformationService;

import java.sql.SQLException;

public class InformationServiceImpl implements InformationService {
    private InformationDao informationDao = new InformationDao();
    @Override
    public Information findInformation(String userName) {
        try {
            return informationDao.findByUsername(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveInformation(Information information) {
        try {
            return informationDao.saveInformation(information);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
