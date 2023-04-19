// O(log n)

package Tree;

public class RedBlackTree {
   
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


    // все значения уникальные => удалось ли создать новую ноду
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


    // левосторонний поворот. 
    private Node leftSwap (Node node) {
        Node leftChild = node.leftChild; // левый ребенок - выделяем в отдельн.переменную для удобства
        Node beetweenChild = leftChild.rightChild;  // промежуточный ребенок, к-й будет менять своего родителя. Т.к. родитель и ребенок будут меняться местами
        leftChild.rightChild = node; // Левосторонняя нода априори красная => вместо правого ребенка красной ноды мы назначаем наш рутовый эл-т, с к-го мы начали, т.е. текущего родителя
        node.leftChild = beetweenChild; // у родителя левым эл-том становится не красная нода, на к-ю мы ссылались, а промежуточный ребенок. к-й имеет значение между красной нодой и рутовой нодой
        leftChild.color = node.color; // левый ребенок получает цвет своего родителя
        node.color = Color.RED; // корень, к-й был корень, опустился ниже и становится красным
        return leftChild;
    }


    private void colorSwap (Node node) { // если нужно произвести смену цвета указанной ноды. Только когда у ноды 2 красных ребенка ! => можно не писать доп.проверки
        node.rightChild.color = Color.BLACK;  // присваиваем детям черные цвета
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;  // сама нода становится красной
    }


    private class Node {

        private int value; // значение, к-е храним в узле

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