package doublylinkedlists;

public class Main {
    public static void main(String[] args) {
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
        list.addToFront(new Employee("Sonali", "Basu", 1234));
        list.addToFront(new Employee("Tushar", "Shanker", 5678));
        list.addToFront(new Employee("John", "Doe", 9810));
        list.addToFront(new Employee("Billy", "Bob", 1112));

        list.printList();
        System.out.println(list.getSize());

        list.addToEnd(new Employee("Jim", "Halpert", 99999));
        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());
    }
}