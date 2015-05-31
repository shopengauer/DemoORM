package com.vspavlov.demoorm.repository;

import com.vspavlov.demoorm.domain.techobjects.Series;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vasiliy on 28.04.2015.
 */
//@Qualifier(value = "series")
public interface SeriesRepository extends JpaRepository<Series,Integer> {
}
