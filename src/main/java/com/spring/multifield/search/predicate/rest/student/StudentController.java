package com.spring.multifield.search.predicate.rest.student;

import com.spring.multifield.search.predicate.dao.entity.StudentDAO;
import com.spring.multifield.search.predicate.dto.SearchRequest;
import com.spring.multifield.search.predicate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(
            StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.PUT)
    public List<StudentDAO> search(@RequestParam String keyword, @RequestBody(required = false) SearchRequest searchRequest) {
        return studentService.search(keyword, searchRequest);
    }
}


