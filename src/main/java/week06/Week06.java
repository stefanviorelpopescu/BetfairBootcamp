package week06;

import week02.student.StudentModel;

import java.util.*;
import java.util.stream.Collectors;

public class Week06
{
    public static void main(String[] args)
    {
        List<StudentModel> students = new ArrayList<>();

        for (int i = 0; i<10; i++) {
            students.add(new StudentModel(1, "Ion", "Ion", 25));
        }

        Integer maxAge = students.stream()
                .filter(studentModel -> studentModel.getFirstName().equals("Ion"))
                .map(StudentModel::getAge)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);


        Integer maxAge2 = students.stream()
                .map(StudentModel::getAge)
                .filter(age -> age < 45)
                .max(Comparator.comparingInt(o -> o))
                .orElse(-1);

//        final String labelPrefix = "Name: ";
        String labelPrefix = "Name: ";

        List<Label> labels = students.stream()
                .map(StudentModel::getFirstName)
                .map(labelName -> new Label(labelPrefix + labelName))
                .collect(Collectors.toList());

        students.forEach(studentModel -> System.out.println(studentModel.getLastName()));
        students.forEach(Week06::createCafeteriaAccount);
        students.forEach(System.out::println);

        students.removeIf(studentModel -> studentModel.getFirstName().equals("Traian"));

        students.replaceAll(studentModel -> new StudentModel(studentModel.getId(), studentModel.getFirstName().toUpperCase(),
                studentModel.getLastName().toUpperCase(), studentModel.getAge()));

        Collections.sort(students);

        students.sort(StudentModel::compareTo);

        for (int i = 0; i<100_000_000; i++) {
            students.add(new StudentModel(1, "Ion", "Ion", 25));
        }

        long start = System.currentTimeMillis();

        int sum = students.stream()
                .parallel()
                .map(StudentModel::getAge)
                .filter(age -> age < 35)
                .mapToInt(value -> value)
                .sum();

        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end-start));
        System.out.println("Size: " + students.size());

        Label myLabel = new Label("Test");

        String labelName00 = myLabel.getOptionalName()
                .orElse("");

        String labelName01 = myLabel.getOptionalName()
                .orElseThrow(() -> new RuntimeException("No Label found!"));

        Optional<String> optionalName = myLabel.getOptionalName();

        if (optionalName.isPresent()){
            String labelName = optionalName.get();
        } else {

        }

        optionalName.ifPresentOrElse(labelName -> System.out.println("" + labelName),
                () -> System.out.println("Label not found!"));

        Integer[] nrs = new Integer[] {2, 3, 4};
        Optional<Integer> max = Arrays.stream(nrs).max(Integer::compareTo);

    }

    private static void createCafeteriaAccount(StudentModel studentModel)
    {

    }
}
