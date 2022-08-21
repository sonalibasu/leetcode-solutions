package doublylinkedlists;

public class EmployeeDoublyLinkedList {
    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public int getSize(){
        return this.size;
    }

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        if (head == null){
            tail = node;
        }
        else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public void addToEnd(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setPrevious(tail);
        if (tail == null){
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
        size++;

    }

   public EmployeeNode removeFromFront()
    {
        if (isEmpty()){
            return null;
        }
        EmployeeNode removed = head;
        if (head.getNext() == null){
            tail = null;
        }
        else{
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removed.setNext(null);
        return removed;
    }

    public boolean isEmpty(){
        return head == null;
    }
    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD <-> ");
        while(current != null){
            System.out.print(current);
            System.out.println(" <-> ");
            current = current.getNext();
        }
    }
}
