package com.spring.multifield.search.predicate.services;

import com.spring.multifield.search.predicate.dao.entity.StudentDAO;
import com.spring.multifield.search.predicate.dto.SearchRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<StudentDAO> search(String keyword, SearchRequest searchRequest) {


        List<String> columns;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentDAO> q = cb.createQuery(StudentDAO.class);
        Root<StudentDAO> studentDAORoot = q.from(StudentDAO.class);

        List<Predicate> predicates = new ArrayList<>();

        columns = searchRequest.getColumns();

        for (int i = 0; i < columns.size(); i++) {
            predicates.add(cb.or(cb.like(studentDAORoot.get(String.valueOf(columns.get(i))).as(String.class), "%" + keyword + "%")));
        }

        q.select(studentDAORoot).where(
                cb.or(predicates.toArray(new Predicate[predicates.size()])));


        List<StudentDAO> resultList = entityManager.createQuery(q).getResultList();

        return resultList;

    }
}
