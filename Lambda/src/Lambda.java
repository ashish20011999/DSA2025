import java.util.List;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {

        Integer num = 3;
        Integer num2 = 4;

        //Method 1: defining method of functional interface using anonymous class
        Calculator calculator =  new Calculator<Integer, Integer>() {
            @Override
            public Integer calculate(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };
        System.out.println(calculator.calculate(num,num2));

        //Method 2: basic use of lambda is to define the method of a functional interface without using an anonymous class
        Calculator<Integer,Integer> calculator1 = (a, b) -> a+b;
        System.out.println(calculator1.calculate(num,num2));


        /**
         * 'fruit -> System.out.println(fruit)' is a definition of the method accept in {@link Consumer} class
         * whose object is a parameter for forEach method in the {@link Iterable} class which is extended by all the collections
         *
         * Check the code for {@link Iterable#forEach(Consumer)}, each element for the iterator is looped over to perform the
         * {@link Consumer#accept(Object)} method override, In the case below we iterate over the list element to do a print.
         */
        List<String> fruits = List.of("apples","banana","oranges");
        fruits.forEach(fruit -> System.out.println(fruit));

        /**
         * here the definition of the accept method is in a block of code:
         *   {
         *     String upperCaseName = name.toUpperCase();
         *     System.out.println("Name in uppercase: " + upperCaseName);
         *   }
         */
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.forEach(name -> {
            String upperCaseName = name.toUpperCase();
            System.out.println("Name in uppercase: " + upperCaseName);
        });

    }

    @java.lang.FunctionalInterface
    private interface Calculator<T, V> {
        Integer calculate(T t, V v);
    }
}
