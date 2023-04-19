package Tree;
import java.util.ArrayList;
// чаще всего вверх по дереву не ходят => ссылка для родителя не требуется
// поиск  типами: обход в глубину и в ширину
// для простоты рассматриваем дерево, в к-м нет повторяющихся эл-тов и интовое
import java.util.List;

public class Tree {
    Node root; // начало дерева


    // ОБХОД В ГЛУБИНУ
    // разбиваем поиск на 2 функции: поиск ноды (find) и публичная ф-я (exist), к-я отражает, получилось ли найти ноду 
    public boolean exist (int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }


    // поиск интересующей ноды - рекурсивно => в аргументах ссылка на ноду и искомое значение
    // рекурсия не затратная и не треб.доп.памяти => чаще исп-ся обход в глубину
    private Node find(Node node, int value) {
        if(node.value == value) {  // проеряем текущую ноду
            return node;
        } else {  // если не находим значение, то перебираем её детей
            for (Node child : node.children) {
                Node result = find(child, value);  // рукурсивно запускаем поиск среди детей
                if (result != null) {
                    return result;
                }
            }
        }
        return null; // если эл-та нет
    }


    // ОБХОД В ШИРИНУ - без рекурсии. Если дерево ооочень большое, то лучше искать так
    // н-р отобразить все эл-ты одной иерархии или для ф-ии отрисовки
    // затратно по памяти, т.к. хранит детей
    private Node find1 (int value) {
        List<Node> Line = new ArrayList<>();
        Line.add(root);
        while (Line.size() > 0) {  // пока существуют какие-то дети
            List<Node> nextLine = new ArrayList<>();
            for (Node node : Line) { // перебираем линию
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);  // добавляем в список всех детей, если не найдем value  //пустой список останется, если все эл-ты не содержат детей и тогда выйдем из условия
            }
            Line = nextLine; // обновляем линию и перезапускаем цикл, //если не разу выше не вызвали return - не нашли эл-т
        }
        return null;
    }
    

    public class Node {
        int value; // для простоты используем int. Хотя можем использ.любой тип данных
        List<Node> children;  // список детей
    }

}
