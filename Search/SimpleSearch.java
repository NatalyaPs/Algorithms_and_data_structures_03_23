package Search;

// поиск - простой перебор O(n)

public class SimpleSearch {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9}; // сразу отсортированный

        System.out.println(simpleSearch(array, 5));
    }
    
    public static int simpleSearch (int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
