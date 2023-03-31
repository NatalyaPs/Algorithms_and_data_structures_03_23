package Sort;

public class DirectSort {   // сортировка выбором

    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5};
        directSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    // ПРОСТЫЕ АЛГОРИТМЫ СОРТИРОВКИ

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

}
