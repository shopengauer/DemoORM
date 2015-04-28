package com.vspavlov.demoorm.repository;

import com.vspavlov.demoorm.domain.TechObjectType;

import java.util.List;

/**
 * Created by Vasiliy on 28.04.2015.
 */
public interface TechObjectTypeRepository {


    List<TechObjectType> findAll();

}
