package week03.student.service;

import week03.student.converter.StudentConverter;
import week03.student.dao.StudentDao;
import week03.student.dto.StudentDto;
import week03.student.model.StudentModel;

import java.util.Optional;

public class StudentService
{
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    public boolean createStudent(StudentDto studentDto)
    {
        validateCreatePayload(studentDto);

        StudentModel studentModel = StudentConverter.convertDtoToModel(studentDto);

        return studentDao.createStudent(studentModel);
    }

    public boolean updateStudent(StudentDto studentDto)
    {
        validateUpdatePayload(studentDto);

        Optional<StudentModel> studentFromDb = studentDao.getStudentById(studentDto.getId());
        if (!studentFromDb.isPresent()) {
            throw new UnsupportedOperationException();
        }

        StudentModel studentModel = StudentConverter.convertDtoToModel(studentDto);
        return studentDao.updateStudent(studentModel);
    }

    private void validateUpdatePayload(StudentDto studentDto)
    {
        if (studentDto.getId() == null) {
            throw new IllegalArgumentException();
        }
        if (studentDto.getName() == null || studentDto.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (studentDto.getAge() == null || studentDto.getAge() < 14) {
            throw new IllegalArgumentException();
        }
        if (studentDto.getGpa() == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCreatePayload(StudentDto studentDto)
    {
        if (studentDto.getId() != null) {
            throw new IllegalArgumentException();
        }
        if (studentDto.getName() == null || studentDto.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (studentDto.getAge() == null || studentDto.getAge() < 14) {
            throw new IllegalArgumentException();
        }
    }
}
