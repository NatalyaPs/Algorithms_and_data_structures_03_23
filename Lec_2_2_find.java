
// АЛГОРИТМЫ ПОИСКА
public class Lec_2_2_find {

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9}; // сразу отсортированный

        // простой перебор O(n)
        System.out.println(find(array, 5));

        // бинарный перебор O(log n)
        // System.out.println(binarySearch(array, 5, 0, array.length - 1));   // вызов без перегрузки
        System.out.println(binarySearch(array, 9));  // вызов с перегрузкой
    }
    

    // простой перебор - O(n)
    public static int find (int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // бинарный перебор - только для ОТСОРТИРОВАННОГО МАССИВА - O(log n)
    // разделяй и властвуй  - лучше через рекурсию
    
    public static int binarySearch(int[] array, int value) {   // перегрузка для бинарного поиска
        return binarySearch(array, value, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int value, int min, int max) {  // бинарный поиск - больше аргументов для функции. Выше перегрузка
        int midpoint;
        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;   // середина массива
        }

        if (array[midpoint] < value) {
            return binarySearch (array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binarySearch(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }

}
