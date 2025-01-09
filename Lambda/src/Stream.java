import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        /**
         * Stream is an interface, when called by a collection it returns a generic Stream object of Collection type,
         * here Stream<String> is returned.
         * The Stream interface has 2 kinds of methods: "Intermediate" (such as peek, map, filter) and "Terminal"
         * (such as collect,reduce,min,max)
         */
        List<String> names = List.of("Ashish","Abhinav","Anjali","Ankit","Deepak");
        List<String> lowerCaseNames = names.stream().map(name -> name.toLowerCase()).collect(Collectors.toList());
        System.out.println(lowerCaseNames);

        // Intermediate methods are "lazy", they are used until the terminal operation is invoked

        //does nothing : peek is not called
        names.stream().peek(name -> System.out.println(name));

        //prints  : peek is called
        names.stream().peek(name -> System.out.println(name)).collect(Collectors.toList());
    }
}
