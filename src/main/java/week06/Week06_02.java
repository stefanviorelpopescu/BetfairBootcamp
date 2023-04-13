package week06;

import week02.student.StudentConverter;
import week02.student.StudentDto;
import week02.student.StudentModel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Week06_02
{
    public static void main(String[] args)
    {
        List<StudentModel> students = new ArrayList<>();

        for (int i = 0; i<10; i++) {
            students.add(new StudentModel(i, "Ion", "Ion", 25));
        }
        for (int i = 0; i<10; i++) {
            students.add(new StudentModel(i, "Ion", "Ion", 25));
        }

        List<StudentDto> collect = students.stream()
                .sorted(Comparator.comparing(StudentModel::getLastName).thenComparing(StudentModel::getFirstName).reversed().thenComparing(StudentModel::getAge))
                .filter(StudentModel::isStudentInTerminalYear)
                .map(StudentConverter::convertStudentModelToDto)
                .collect(Collectors.toList());

        Set<String> fails = new HashSet<>();
        for (StudentModel student : students)
        {
            fails.addAll(student.getFailedClasses());
        }

        students.stream()
                .distinct()
                .map(StudentModel::getFailedClasses)
                .forEach(fails::addAll);

        students.stream()
                .flatMap(studentModel -> studentModel.getFailedClasses().stream().filter(s -> s.contains("DB")))
                .forEach(fails::add);

        students.stream()
                .filter(studentModel -> studentModel.getId() < 5)
                .forEach(student -> System.out.println(student.getId()));

        System.out.println("______________");

        students.stream()
                .dropWhile(studentModel -> studentModel.getId() < 5)
                .forEach(student -> System.out.println(student.getId()));

        Integer reduce = students.stream()
                .sorted()
                .map(StudentModel::getAge)
                .reduce(0, Integer::sum);


    }

}
