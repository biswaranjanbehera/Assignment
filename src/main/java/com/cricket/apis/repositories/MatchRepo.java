package com.cricket.apis.repositories;

import com.cricket.apis.entites.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepo extends JpaRepository<Match,Integer> {
    //match fetch with provided teamHeading
    Optional<Match> findByTeamHeading(String teamHeading);
}
