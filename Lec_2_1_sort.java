// package tasks;
 // ПРОСТЫЕ АЛГОРИТМЫ СОРТИРОВКИ

 // + см. в папке SORT   !!!
 
public class Lec_2_1_sort {

    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};

        // пузырьковая сортировка
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        // сортировка выбором
        directSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        // сортировка вставками
        insertSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    
    // ПРОСТЫЕ АЛГОРИТМЫ СОРТИРОВКИ

    // пузыроковая сортировка O(n^2) квадратичная: 
    // проход по массиву в цикле do-while -> O(n) * перемещение эл-тов в цикле for -> O(n) = O(n^2)
    public static void bubbleSort(int[] array) {
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    finish = false;   //  цикл заканчивать нельзя, т.к.была оерация обмена
                }
            }
        } while (!finish);
    }

    // сортировка выбором O(n^2) квадратичная - цикл в цикле. Но кол-во обменов меньше, 
    //чем в пузырьковой сортировке, т.к.меняем только самый минимальный эл-т
    // находим наименьший эл-т в массиве и меняем с 1-м, потом со 2-м и т.д.
    public static void directSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array [minPosition]) {
                    minPosition = j;
                }
            }
            if (i != minPosition) {
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp;
            }
        }
    }
 
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
    // АЛГОРИТМЫ ПОИСКА
}
