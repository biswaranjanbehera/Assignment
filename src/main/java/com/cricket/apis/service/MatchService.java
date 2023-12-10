package com.cricket.apis.service;

import com.cricket.apis.entites.Match;

import java.util.List;
import java.util.Map;

public interface MatchService {
    //get all matches
    List<Match> getAllMatches();

    //get all live matches
    List<Match> getLiveMatches();

    //get point tables of CWC
    List<List<String>> getPointTable();
}
