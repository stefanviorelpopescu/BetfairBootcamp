package week03.student.controller;

import week03.student.dto.StudentDto;
import week03.student.service.StudentService;

public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    public boolean createStudent(StudentDto requestBody) {
        return studentService.createStudent(requestBody);
    }

    public boolean updateStudent(StudentDto requestBody) {
        return studentService.updateStudent(requestBody);
    }
}
