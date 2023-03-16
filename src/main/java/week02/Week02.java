package week02;

import sun.security.util.ArrayUtil;
import week02.student.StudentModel;
import week02.student.StudentModelComparatorByAge;
import week02.student.StudentState;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Week02
{
    public static void main(String[] args)
    {
        List list = new ArrayList();
        list.add("test");
        list.add(54);
        list.add(43L);
        list.add(new Button());

        for (Object object : list)
        {
            if (object instanceof String) {
                System.out.println(object);
            }
            if (object instanceof Long) {
                System.out.println(object);
            }
            if (object instanceof Button) {
                Button button = (Button) object;
                button.addActionListener(e -> {

                });
            }
        }

        List<String> list2 = new ArrayList<>();
        list2.add("test");
        list2.add("test2");

        for (String object : list2)
        {
                System.out.println(object);
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(11);
        numbers.add(22);
        numbers.add(33);

        printList(numbers);

        printList(list);

        String[] names = new String[34];

        List<String> strings = Arrays.asList("as", "df", "sgfd", "fgdg");

        Integer[] nrs = new Integer[100];

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext())
        {
            Integer next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }

        List<Integer> toRemove = new ArrayList<>();
        for (Integer next : numbers)
        {
            if (next % 2 == 0) {
                toRemove.add(next);
            }
        }
        numbers.removeAll(toRemove);

        List<Integer> collect = numbers.stream()
                .filter(integer -> integer % 2 != 0)
                .map(integer -> integer * 2).sorted()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        printList(numbers);

        Set<Integer> intSet = new HashSet<>();
        Set<StudentModel> intSet2 = new TreeSet<>();
        Set<StudentModel> intSet3 = new TreeSet<>(comparingInt(StudentModel::getAge));
        Set<StudentModel> intSet4 = new TreeSet<>(new StudentModelComparatorByAge());

        StudentModel s1 = new StudentModel(1, "Ion", "Ion", 25);
        StudentModel s2 = new StudentModel(1, "Ion", "Ion", 25);
        Set<StudentModel> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);
        System.out.println(studentSet);

        Map<Long, StudentModel> studentsById = new HashMap<>();

    }

    public static void printList(List<?> list) {
        if (list.isEmpty()) {
            System.out.println("Empty list!");
        }
        for (Object o : list)
        {
            System.out.println(o);
        }
    }
}
