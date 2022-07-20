public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public int getSize(){
        return this.size;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD => ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println();
    }

    public EmployeeNode removeFromFront(){
        if (this.isEmpty()){
            return null;
        }
        EmployeeNode removedNode = this.head;
        head = head.getNext();
        size-- ;
        removedNode.setNext(null); // this is overkill. As even though the next in this removed node contains then next element,
        // we can't reach it. However, I'm doing this as are returning the object to the user.
        return removedNode;
    }

    public boolean isEmpty(){
        return head == null;
    }
}
