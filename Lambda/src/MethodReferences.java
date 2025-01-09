import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class MethodReferences {

    public static void main(String[] args) {
        // 4 ways to use Method references

        //1. For static methods
        List<String> names = List.of("Ashish","Ankit");
        names.stream().peek(MyClass::myMethod).collect(Collectors.toList());

        //2. For object based methods (non static)

        //2.1 define an implementation: using lambda
        MyInterface<String> myInterface = (s) -> System.out.println(s.toUpperCase());
        names.stream().peek(myInterface::myMethod).collect(Collectors.toList());

        //2.2 define an implementation: using anonymous class (inefficient)
        MyInterface<String> myInterface1 = new MyInterface<String>() {
            @Override
            public void myMethod(String s) {
                System.out.println(s.toLowerCase());
            }
        };
        names.stream().peek(myInterface1::myMethod).collect(Collectors.toList());

        // 3. Use method references on each object
        Person p1 = new Person("Ashish",11);
        Person p2 = new Person("Aryan",12);
        List<Person> people = List.of(p1,p2);

        List<String> peopleNames = people.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(peopleNames);

        // 4. Call constructor using new
        List<String> userNames = List.of("Vikas","Shubham");
        List<Person> people1 = userNames.stream().map(Person::new).collect(Collectors.toList());

        System.out.println(people1);
    }

    private class MyClass {
        static void myMethod(String name) {
            System.out.println(name);
        }
    }

    @java.lang.FunctionalInterface
    private interface MyInterface<T> {
        void myMethod(T t);
    }

    private static class Person{
        private String name;
        private Integer age;

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }
        public void setAge(Integer age){
            this.age = age;
        }

        Person(String name, Integer age){
            this.name = name;
            this.age = age;
        }

        Person(String name){
            this.name = name;
        }
    }
}
