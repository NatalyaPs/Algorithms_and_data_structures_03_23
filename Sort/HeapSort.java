package Sort;

// сложность O(n * log n)
// пирамидальная сортировка или сортировка кучей
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[] {4, 2, 5, 8, 1, 9, 38, 2, 88, 3, 6, 8, 5, 12};

        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort (int[] array) {
        // построение кучи (перегруппируем массив)
        for (int i = array.length / 2 - 1; i >=0; i--)  // запускаем просеивание от середины до начала
            heapify(array, array.length, i);            // т.о. самый большой эл-т окажется на позиции 0
        
        // один за другим извлекаем эл-ты из кучи
        for (int i = array.length - 1; i >= 0; i--) {  // т.е.начинаем сортировку, т.к. самый большой эл-т уже нашли
            // перемещаем текущий корень в конец     // ставим самый большой эл-т в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // вызываем процедуру heapify на уменьшенной куче
            heapify(array, i, 0);  // просеиваем, не затрагивая последний эл-т и снова находим самый тяжелый эл-т
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) { // heapify - нагромождать, heapSize-Размер кучи, rootIndex-Корневой индекс
        int largest = rootIndex;  // инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1;  // левый = 2 * rootIndex + 1
        int rightChild = 2 * rootIndex + 2;  // правый = 2 * rootIndex + 2

        // если дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // если равый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        // если самый большой элемент не корень
        if (largest != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
