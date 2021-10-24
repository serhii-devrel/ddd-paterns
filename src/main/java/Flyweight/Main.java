package Flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John Smith");
        Person person2 = new Person("John Huge");
        Person person3 = new Person("David Huge");

        System.out.println(Person.list.size());
    }
}

class Person {
    public static final List<String> list = new ArrayList<>();
    public static List<Integer> names = new ArrayList<>();

    public Person(String fullName) {
        names = Arrays
                .stream(fullName.split(" "))
                .map(Person::getOrAdd)
                .collect(Collectors.toList());
    }

    public static int getOrAdd(String s) {
        int idx = list.indexOf(s);
        if (idx != -1) {
            return idx;
        } else {
            list.add(s);
        }
        return list.size() - 1;
    }
}