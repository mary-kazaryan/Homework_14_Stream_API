package TeachMeSkills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
С помощью Stream'ов:
- Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
- Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
- Отсортировать и вернуть первый элемент коллекции или "Empty", если коллекция пуста
*/

public class Task2 {

    public static void main(String[] args) {

        List<String> collectionOfStudentNames = new ArrayList<>(Arrays.asList("Антон", "Евгений", "Мария", "Мария", "Катерина",
                "Ольга", "Анатолий", "Аина", "Егор", "Валерия", "Виталий", "Юлия", "Александр", "Таисия", "Виталий", "Светлана"));


        Stream<String> toCalculateRepeatedNames = collectionOfStudentNames.stream();
        int amountOfRepeatedNames = (int) toCalculateRepeatedNames
                .filter(x -> x.equalsIgnoreCase("Мария"))
                .count();
        System.out.println("Количество студентов с именем Мария: " + amountOfRepeatedNames);


        Stream <String> toFindRequiredNames = collectionOfStudentNames.stream();
        List<List> namesStartingWithA = new ArrayList<>();
        namesStartingWithA.add(toFindRequiredNames
                .sorted()
                .dropWhile(x -> x.startsWith("А") || x.startsWith("а"))
                .collect(Collectors.toList()));
        System.out.println("Список имен, начинающихся с буквы А: " + namesStartingWithA);


        Stream<String> toSortAndGetFirstName = collectionOfStudentNames.stream();
        Optional<String> firstName = Optional.ofNullable(collectionOfStudentNames.toString());
        if (firstName.isPresent()) {
            firstName = toSortAndGetFirstName
                    .sorted()
                    .findFirst();
            System.out.println("Первый элемент отсортированной коллекции: " + firstName);
        } else System.out.println("Empty");

    }

}
