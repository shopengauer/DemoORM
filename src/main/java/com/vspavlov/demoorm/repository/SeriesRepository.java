package com.vspavlov.demoorm.repository;

import com.vspavlov.demoorm.domain.Series;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vasiliy on 28.04.2015.
 */
//@Qualifier(value = "series")
public interface SeriesRepository extends JpaRepository<Series,Integer> {
}
