import java.util.Collection;
import java.util.Collections;

public class FunctionalInterface {

    /**
     * MyClass implements MyFunctionalInterface, this seems as an overkill (creating a class for overriding a method)
     */
    private static class MyClass implements MyFunctionalInterface{
        @Override
        public void myMethod() {
            System.out.println("MyClass implemented myMethod");
        }

    }

    public static void main(String[] args) {
        /**
         * 1. Functional Interface is an interface with a single abstract method and can have optional static/default methods
         * 2. Functional Interfaces were created so that they can be used in lambda while operating with collections
         * 3. Anonymous classes are the instantiation of a class or an interface inside another class without actually
         *    implementing the interface or extending a class
         *
         */

        //Anonymous class
        MyFunctionalInterface obj1 = new MyFunctionalInterface() {
            @Override
            public void myMethod() {
                System.out.println("This accepts no parameter, exactly like runnable....probably not used in collections and lambda");
            }
        };

        //This is an overkill: no need to create MyClass just to override one method
        MyClass myClassObj = new MyClass();
        myClassObj.myMethod();

        //This is a better approach and uses anonymous class object to override myMethod.
        obj1.myMethod();

        //Anonymous class
        MyFunctionalInterface2<String, String> obj2 = new MyFunctionalInterface2<String, String>() {
            @Override
            public void myMethod(String s, String s2) {
                System.out.println(String.format("This is the concatenated string: %s", s + " " + s2));
            }
        };

        obj2.myMethod("hello", "world");

        //Anonymous class
        Comparator<Integer, Integer> comparator = new Comparator<Integer, Integer>() {
            @Override
            public int compare(Integer integer, Integer integer2) {
                return integer.compareTo(integer2);
            }
        };

        //comparing 2 integers here:
        Integer num = 4;
        Integer num2 = 5;
        if (comparator.compare(num, num2) == 0) {
            System.out.println("num is greater than or equal to num2");
        } else {
            System.out.println("num2 is greater than num");
        }

        //other method for this anonymous class can also be used
        System.out.println(comparator.performOperation(4));
        System.out.println(Comparator.subtract(5, 2));


    }


    @java.lang.FunctionalInterface
    private interface MyFunctionalInterface {
        void myMethod();
    }

    //does not matter if we annotate the class, it is still a functional interface
    private interface MyFunctionalInterface2<T, V> {
        void myMethod(T t, V v);
    }

    private interface Comparator<T, V> {
        int compare(T t, V v);

        //contains default method for subtraction
        static int subtract(int num1, int num2) {
            return num1 - num2;
        }

        //provided a default implementation here, can be overriden in other classes
        default int performOperation(int num) {
            return num * num;
        }
    }

}