package TeachMeSkills;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Создать коллекцию класса ArrayList, наполнить ее рандомными элементами типа Integer.
С помощью Stream'ов:
- Удалить дубликаты
- Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
- Каждый элемент умножить на 2
- Отсортировать и вывести на экран первых 4 элемента
- Вывести количество элементов в стриме
- Вывести среднее арифметическое всех чисел в стриме
 */


public class Task1 {

    public static void main(String[] args) {

        List<Integer> listOfRandomNumbers = new ArrayList<Integer>();
        listOfRandomNumbers.add(3);
        listOfRandomNumbers.add(92);
        listOfRandomNumbers.add(16);
        listOfRandomNumbers.add(17);
        listOfRandomNumbers.add(54);
        listOfRandomNumbers.add(9);
        listOfRandomNumbers.add(92);
        listOfRandomNumbers.add(87);
        listOfRandomNumbers.add(12);
        listOfRandomNumbers.add(9);
        listOfRandomNumbers.add(5);
        listOfRandomNumbers.add(12);
        listOfRandomNumbers.add(14);
        listOfRandomNumbers.add(60370);
        listOfRandomNumbers.add(8);
        listOfRandomNumbers.add(10);
        listOfRandomNumbers.add(3);

        System.out.println("Here is the initial list of random numbers: " + listOfRandomNumbers);


        Stream<Integer> toFilterRandomNumbers =listOfRandomNumbers.stream();
        List<List> filteredNumbers = new ArrayList<>();
        filteredNumbers.add(toFilterRandomNumbers
                .distinct()
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 7)
                .filter(x -> x <= 17)
                .collect(Collectors.toList()));

        System.out.println("Here is the result of stream filtering: " + filteredNumbers.toString());


        Stream<Integer> toSortFilteredNumbers = listOfRandomNumbers.stream();
        List<List> sortedAndIncreasedNumbers = new ArrayList<>();
        sortedAndIncreasedNumbers.add(toSortFilteredNumbers
                .distinct()
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 7)
                .filter(x -> x <= 17)
                .sorted()
                .map(x -> x * 2)
                .limit(4)
                .collect(Collectors.toList()));

        System.out.println("Here is the result of sorting and increasing filtered numbers: " + sortedAndIncreasedNumbers);


        Stream<Integer> toCountFilteredNumbers = listOfRandomNumbers.stream();
        int count = (int) toCountFilteredNumbers
                .distinct()
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 7)
                .filter(x -> x <= 17)
                .sorted()
                .map(x -> x * 2)
                .limit(4)
                .count();

        System.out.println("The amount of filtered numbers is: " + count);


        Stream<Integer> toGetSumOfFilteredNumbers = listOfRandomNumbers.stream();
        long sum = toGetSumOfFilteredNumbers
                .distinct()
                .filter(x -> x % 2 == 0)
                .filter(x -> x > 7)
                .filter(x -> x <= 17)
                .sorted()
                .map(x -> x * 2)
                .limit(4)
                .reduce(0, (x, y) -> x + y);

        System.out.println("The sum of filtered numbers is: " + sum);

    }
}
