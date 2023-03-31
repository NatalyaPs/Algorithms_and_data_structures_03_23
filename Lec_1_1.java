// package tasks;

// делители -> сложность алгоритма: O(n) линейная
// простые числа -> сложность алгоритма: O(n^2) квадратичная
// и др.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Lec_1_1 {

    public static void main(String[] args) {
        List<Integer> availableDivider = findAvailableDivider(12);
        for (Integer integer : availableDivider) {
            System.out.printf(" " + integer);
        }

        System.out.println("\n");

        List<Integer> simpleNumber = findSimpleNumber(100);
        for (Integer integer : simpleNumber) {
            System.out.printf(" " + integer);
        }

        System.out.println("\n");

        double sum = findSum(12);
        System.out.printf("шанс = " + sum);

        System.out.println("\n");

        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());
    }


    // найти доступный делитель
    public static List<Integer> findAvailableDivider (int number) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            counter++;
            if (number % i == 0) {
                result.add(i);
            }
        }
        System.out.println("Поиск делителей, количество операций: " + counter);
        return result;
    }

    // Найти простое число
    public static List<Integer> findSimpleNumber (int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if(i % j == 0){
                    simple = false;
                }
            }
            if (simple){         // если simple не поменялся
                result.add(i);
            }
        }
        System.out.println("Поиск натуральных чисел, количество операций: " + counter);
        return result;
    }

    // для ТРЕХ шестигранных кубиков 
    // график экспоненциальной зависимости
    // поиск шанса выпадения определенной суммы на игральных костях
    public static double findSum(int sum) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if(i + j + k == sum){
                        successResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) successResult) / ((double) count);
    }

    // вычисление чисел Фибоначчи
    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        //if (position == 1 || position == 2) {   // в лекции так - позиция в массиве
        // if (position == 0 || position == 1) {   // вроде праильно так
        if (position == 1) {     
            return 0;
        }
        if (position == 2) {     
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}