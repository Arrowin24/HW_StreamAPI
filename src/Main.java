import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new Random().ints(20, 10, 101).boxed().toList();
        //Task 1
        findMinMax(list.stream(), Integer::compareTo, (i1, i2) -> System.out.println("Min is " + i1 + " Max is " + i2));

        //Task 2
        findEvenNum(list.stream());
    }


    //Task 1
    public static <T> void findMinMax(
            Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer)
    {
        List<? extends T> list = stream.sorted(order).toList();
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }


    //Task 2
    public static void findEvenNum(Stream<Integer> stream) {
        List<Integer> list = stream.filter(i -> i % 2 == 0).toList();
        System.out.println("Total number is "+ list.size());
        list.forEach(i -> System.out.print(i+" "));
    }
}
