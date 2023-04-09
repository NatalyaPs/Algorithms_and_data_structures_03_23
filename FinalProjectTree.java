// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

/* Алгоритмы и структуры данных
 * Структуры данных дерево и хэш-таблица
 * -------------------------------------
 * Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. // (левостороннее => красный узел может быть только левым потомком )
 * И реализовать в нем метод добавления новых элементов с балансировкой.

Красно-черное дерево имеет следующие критерии:
• Каждая нода имеет цвет (красный или черный)
• Корень дерева всегда черный
• Новая нода всегда красная
• Красные ноды могут быть только левым ребенком
• У красной ноды все дети черного цвета

Соответственно, чтобы данные условия выполнялись, после добавления элемента в дерево необходимо произвести балансировку, 
благодаря которой все критерии выше станут валидными. 
Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.
*/


public class FinalProjectTree {
    private Node root;

    
    public boolean add (int value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }


    private boolean addNode (Node node, int value) {
        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild); // возвращаясь из рекурсии, проверяем, нужно ли делать ребалансировку
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED; // все ноды при создании получают красный цвет
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }


    // ребалансировка
    private Node rebalance (Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                        (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                        result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color ==Color.RED &&
                        result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }


    // правосторонний поворот
    private Node rightSwap (Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }


    // левосторонний поворот
    private Node leftSwap (Node node) {
        Node leftChild = node.leftChild; 
        Node beetweenChild = leftChild.rightChild;  
        leftChild.rightChild = node; 
        node.leftChild = beetweenChild; 
        leftChild.color = node.color; 
        node.color = Color.RED; 
        return leftChild;
    }


    private void colorSwap (Node node) { 
        node.rightChild.color = Color.BLACK;  
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;  
    }


    private class Node {

        private int value;

        private Color color;

        private Node leftChild;

        private Node rightChild;


        @Override
        public String toString() {
            return "Node{" +
            "value=" + value +
            ", color=" + color +
            '}';
        }
    }

    

    private enum Color {
       RED, BLACK 
    }
}
