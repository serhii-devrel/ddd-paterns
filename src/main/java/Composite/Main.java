package Composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Specification root_spec = new Specification("root");
        Specification first_lvl_spec = new Specification("first lvl specification");
        Specification inner_first_lvl_spec = new Specification("inner first lvl specification");
        Specification second_lvl_spec = new Specification("second lvl specification");

        first_lvl_spec.addSubSpecification(inner_first_lvl_spec);
        root_spec.addSubSpecification(first_lvl_spec, second_lvl_spec);
        root_spec.print();
    }
}

class Specification {
    public String name;
    public List<Specification> list = new ArrayList<>();

    public Specification(String name) {
        this.name = name;
    }

    public void addSubSpecification(Specification ...specifications) {
        this.list.addAll(List.of(specifications));
    }

    public void print() {
        System.out.println(this.name);
        this.list.forEach(Specification::print);
    }
}