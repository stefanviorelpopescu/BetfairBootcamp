package week03.student.converter;

import week03.student.dto.StudentDto;
import week03.student.model.StudentModel;

public class StudentConverter
{
    public static StudentModel convertDtoToModel(StudentDto studentDto) {
        return StudentModel.builder()
                .withId(studentDto.getId())
                .withName(studentDto.getName())
                .withAge(studentDto.getAge())
                .withGpa(studentDto.getGpa())
                .build();
    }

    public static StudentDto convertModelToDto(StudentModel studentModel) {
        return StudentDto.builder()
                .withAge(studentModel.getAge())
                .withGpa(studentModel.getGpa())
                .withName(studentModel.getName())
                .withId(studentModel.getId())
                .build();
    }
}
