package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 5, 8, 1, 9, 38, 2, 88, 3, 6, 8, 5, 12};

        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // быстрая сортировка - O(n * log n)
    public static void quickSort (int[] array, int startPosition, int endPosition) {
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];  // выбираем центральный эл-т
        do { // двигаем левый эл-т, пока не найдем от, к-й < pivot-а
            while (array[leftPosition] < pivot) { // ищем 2 эл-та на обмен: > и < pivot, ч.б. поменять их местами
                leftPosition++;
            } // двигаем правый эл-т, пока не найдем от, к-й > pivot-а
            while (array[rightPosition] > pivot) { // ищем 2 эл-та на обмен: > и < pivot, ч.б. поменять их местами
                rightPosition--;
            } // обмен только пока наши эл-ты не пересеклись. Если пересекутся, то уже не можем их менять. Т.к. слева все <, справа все >
            if (leftPosition <= rightPosition) {  // если эл-ты не пересекаются
                if (leftPosition < rightPosition) { // если это не один и тот же эл-т
                    int temp = array[leftPosition];  // меняем эл-ты
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++; // сдвигаем позиции
                rightPosition--;
            }
        } while (leftPosition <= rightPosition); // выполняем, пока наши указатели не пересекутся

        if (leftPosition < endPosition) {   // запускаем рекурсивные вызовы: правую часть от лев.поз. до конца
            quickSort(array, leftPosition, endPosition);
        }

        if (startPosition < rightPosition) {    // левую часть от начала до прав.поз.
            quickSort(array, startPosition, rightPosition);
        }
    }
}
