package week05.builder;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder(setterPrefix = "with", toBuilder = true)
public class Person
{
    @NonNull
    String name;

    int age;
    boolean married;
    boolean employed;

    @NonNull
    String cnp;

    String address;

}
