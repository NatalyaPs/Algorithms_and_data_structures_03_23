package List;

public class Revert {
    Node head;  
    Node tail;

   
    // разворот для двусвязанного списка
    public void revert() {
        Node currentNode = head;
        while (currentNode != null) { 
            Node next = currentNode.next; 
            Node previous = currentNode.previous;
            currentNode.next = previous;  
            currentNode.previous = next;
            if (previous == null) {  
                tail = currentNode;  
            }
            if (next == null) {  
                head = currentNode; 
            }
            currentNode = next;  
        }
    }


    public class Node {  
        int value; 
        Node next;  
        Node previous; 
    }
}