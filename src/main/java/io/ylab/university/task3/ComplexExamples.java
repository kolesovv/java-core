package io.ylab.university.task3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComplexExamples {
  static class Person {

    final int id;
    final String name;

    Person(int id, String name) {

      this.id = id;
      this.name = name;
    }

    public int getId() {

      return id;
    }

    public String getName() {

      return name;
    }

    @Override
    public boolean equals(Object o) {

      if (this == o) {
        return true;
      }
      if (!(o instanceof Person person)) {
        return false;
      }
      return getId() == person.getId() && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {

      return Objects.hash(getId(), getName());
    }
  }


  private static Person[] RAW_DATA = new Person[]{
      new Person(0, "Harry"),
      new Person(0, "Harry"), // дубликат
      new Person(1, "Harry"), // тёзка
      new Person(2, "Harry"),
      new Person(3, "Emily"),
      new Person(4, "Jack"),
      new Person(4, "Jack"),
      new Person(5, "Amelia"),
      new Person(5, "Amelia"),
      new Person(6, "Amelia"),
      new Person(7, "Amelia"),
      new Person(8, "Amelia")
  };

  public static void main(String[] args) {

    System.out.println("Raw data:");

    for (Person person : RAW_DATA) {
      System.out.println(person.id + " - " + person.name);
    }

    System.out.println();
    System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");

    System.out.println("Task 3.1");
    /*
    Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени
    Что должно получиться
        Key:Amelia
        Value:4
        Key: Emily
        Value:1
        Key: Harry
        Value:3
        Key: Jack
        Value:1
    */

    groupAndCountPeopleByName(RAW_DATA);
    System.out.println();

    System.out.println("Task 3.2");
//    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
    int[] arr1 = {3, 4, 2, 7};
    int[] arr2 = {};
    int desired1 = 10;
    int desired2 = 0;

    printTwoNumbersGivingTheSum(arr1, desired1);
    printTwoNumbersGivingTheSum(arr1, desired2);
    printTwoNumbersGivingTheSum(arr2, desired1);

    System.out.println();

    System.out.println("Task 3.3");
//    Реализовать функцию нечеткого поиска:
    System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
    System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
    System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
    System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
    System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
    System.out.println(fuzzySearch("lw", "cartwheel")); // false
    System.out.println("Other cases:");
    System.out.println(fuzzySearch("cwhl", "AAcAAAwAAhAlAA")); // true
    System.out.println(fuzzySearch("cwhl   ", "cartwheel")); // true
    System.out.println(fuzzySearch("   ", "cartwheel")); // false
    System.out.println(fuzzySearch("", "cartwheel")); // false
    System.out.println(fuzzySearch(null, "cartwheel")); // false
    System.out.println(fuzzySearch(null, null)); // false
  }

  private static void groupAndCountPeopleByName(Person[] people) {

    if (people != null && people.length != 0) {
      Arrays.stream(people)
          .distinct()
          .sorted(Comparator.comparing(Person::getId))
          .collect(Collectors.groupingBy(Person::getName, Collectors.counting()))
          .forEach((k, v) -> System.out.printf("Key: %s%nValue: %d%n", k, v));
    }
    else {
      System.out.println("Invalid data");
    }
  }

  public static void printTwoNumbersGivingTheSum(int[] arr, int desired) {

    if (arr == null) {
      System.out.println("Given null");
    }
    else if (arr.length > 1) {
      var set = new HashSet<>();
      String result = "Not found";

      for (int value : arr) {
        if (set.contains(desired - value)) {
          result = String.format("[%d,%d]", desired - value, value);
          break;
        }
        set.add(value);
      }

      System.out.println(result);
    }
    else {
      System.out.println("Array contains less than two numbers");
    }
  }

  public static boolean fuzzySearch(String request, String fuzzyRequest) {

    if (request != null && !request.isBlank() && fuzzyRequest != null && !fuzzyRequest.isBlank()) {
      char[] requestChars = request.trim().toCharArray();
      char[] fuzzyChars = fuzzyRequest.trim().toCharArray();
      int i = 0;
      int counterOfFoundCharacters = 0;

      for (char fuzzyChar : fuzzyChars) {
        if (requestChars[i] == fuzzyChar) {
          i++;
          counterOfFoundCharacters++;
          if (counterOfFoundCharacters == requestChars.length) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
