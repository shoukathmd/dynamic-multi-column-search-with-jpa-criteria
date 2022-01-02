package com.spring.multifield.search.predicate.services;

import com.spring.multifield.search.predicate.dto.SearchRequest;

import java.util.List;

public interface StudentService <StudentDAO, Long>
{
    List<StudentDAO> search(String keyword, SearchRequest searchRequest);
}


