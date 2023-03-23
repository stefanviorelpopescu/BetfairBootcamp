package week03.student.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class StudentModel
{
    private Long id;
    private String name;
    private Integer age;
    private Double gpa;
}
