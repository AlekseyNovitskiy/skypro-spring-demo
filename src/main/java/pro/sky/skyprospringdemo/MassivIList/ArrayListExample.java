package pro.sky.skyprospringdemo.MassivIList;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        Integer[] numbersArray = {1,2,3};
        List<Integer> numbersList = new ArrayList<>(List.of(1, 2, 3, 5));
        // Map<String, Integer> numbersMap = new HashMap<>();  // пустой
        Map<String, Integer> numbersMap = new HashMap<>(Map.of("four", 4, "five", 5));  // можно заполнить сразу
        numbersMap.put("two", 2);

        System.out.println(numbersArray[0]);
        System.out.println(numbersList.get(0));
        System.out.println(numbersMap.get("two")+" Получить значение Map");

        numbersArray[1] = 10;
        numbersList.set(1,10); // добаавить в лист
        numbersMap.put("one", 1); // добавить в Мар
        numbersMap.put("three", 3);

        System.out.println(numbersArray.length + " Получаем количество в ArrayList ");
        System.out.println(numbersList.size()+ " Получаем количество в List ");
        System.out.println(numbersMap.size() + " Получаем количество элементов в Map ");


        System.out.println(Arrays.toString(numbersArray)); // распечатать массив
        System.out.println(numbersList);
        System.out.println(numbersMap);

        numbersList.add(56);  // добовляем в лист новое значение
        System.out.println(numbersList);


    }
}
