package week05.builder;

public class PersonWithActualBuilder
{
    String name;
    int age;
    boolean married;
    boolean employed;
    String cnp;
    String address;

    public PersonWithActualBuilder(String name, String cnp)
    {
        this.name = name;
        this.cnp = cnp;
    }

    public PersonWithActualBuilder(String name, int age, boolean married, boolean employed, String cnp, String address)
    {
        this.name = name;
        this.age = age;
        this.married = married;
        this.employed = employed;
        this.cnp = cnp;
        this.address = address;
    }

    public PersonWithActualBuilder(String name, int age, boolean married, boolean employed, String cnp)
    {
        this(name, age, married, employed, cnp, null);
    }

    public PersonWithActualBuilder(String name, boolean employed, boolean married, String cnp)
    {
        this(name, 0, married, employed, cnp, null);
    }



    public static class PersonBuilder {

        private final PersonWithActualBuilder personWithActualBuilder;

        public PersonBuilder(String name, String cnp)
        {
            this.personWithActualBuilder = new PersonWithActualBuilder(name, cnp);
        }

        public PersonBuilder withAge(int age) {
            this.personWithActualBuilder.age = age;
            return this;
        }

        public PersonBuilder isMarried(boolean married) {
            this.personWithActualBuilder.married = married;
            return this;
        }

        public PersonBuilder isEmployed(boolean employed) {
            this.personWithActualBuilder.employed = employed;
            return this;
        }

        public PersonBuilder withAddress(String address) {
            this.personWithActualBuilder.address = address;
            return this;
        }

        public PersonWithActualBuilder build() {
            return this.personWithActualBuilder;
        }
    }

}
