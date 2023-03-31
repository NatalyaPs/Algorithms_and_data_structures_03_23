package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};
        
        // сортировка вставками
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // ПРОСТЫЕ АЛГОРИТМЫ СОРТИРОВКИ

    // сортировка вставками O(n^2) квадратичная
    // начальная позиция сравнивается с 1м и меняется, если меньше, потом со 2м и т.д.
    // потом 2я позиция сравнивается... обменов больше, чем в сортировке выбором, но не попарно. как в пузырьковой
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        } 
    }
}
