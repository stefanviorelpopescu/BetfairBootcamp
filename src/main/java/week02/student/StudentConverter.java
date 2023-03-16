package week02.student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentConverter
{
    public static StudentDto convertStudentModelToDto(StudentModel studentModel) {
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName(studentModel.getFirstName());
        studentDto.setLastName(studentModel.getLastName());
        studentDto.setFullName(studentModel.getFirstName() + " " + studentModel.getLastName());
        studentDto.setAge(studentModel.getAge());
        return studentDto;
    }

    public static List<StudentDto> convertModelListToDtoList(List<StudentModel> studentModels) {
        return studentModels.stream()
                .map(StudentConverter::convertStudentModelToDto)
                .collect(Collectors.toList());
    }
}
