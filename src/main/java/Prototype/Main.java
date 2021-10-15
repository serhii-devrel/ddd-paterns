package Prototype;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 21, new Address("Any street", 21));
        Person anotherPerson = new Person(person);

        anotherPerson.name = "Clark";
        anotherPerson.address.home = 12;

        // Person
        System.out.println(person.name);
        System.out.println(person.address.home);

        // Cloned person
        System.out.println(anotherPerson.name);
        System.out.println(anotherPerson.address.home);
    }
}
// Keep in mind, the built-in interface Cloneable cannot allow you to copy the object deeply

class Address {
    String street;
    int home;

    public Address(String street, int home) {
        this.street = street;
        this.home = home;
    }

    public Address(Address address) {
        this.street = address.street;
        this.home = address.home;
    }
}

class Person {
    String name;
    Address address;
    int age;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(Person person) {
        this.name = person.name;
        this.age = person.age;
        this.address = new Address(person.address);
    }
}