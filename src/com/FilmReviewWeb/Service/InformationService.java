package com.FilmReviewWeb.Service;

import com.FilmReviewWeb.Model.Information;

public interface InformationService {
    public Information findInformation(String userName);
    public boolean saveInformation(Information information);
}
