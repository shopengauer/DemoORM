package com.vspavlov.demoorm.repository;

import com.vspavlov.demoorm.domain.TechObjectType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Vasiliy on 28.04.2015.
 */
@Repository
public class JpaTechObjectTypeRepository implements TechObjectTypeRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public List<TechObjectType> findAll() {
        TypedQuery<TechObjectType> query = em.createNamedQuery("TechObjectType.findAll",TechObjectType.class);
        return query.getResultList();

    }
}
