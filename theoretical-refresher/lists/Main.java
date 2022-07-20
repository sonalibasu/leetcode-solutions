/**
 * A deep dive into various list opeations in Java.
 * COVERS - ArrayList, Vector, Singly Linked List, Double linked list
 * 
 * A list is an abstract data type in java, not a concrete DS. Because of this an interface involved.
 * eg. java.util.lists (https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
 * 
 * An abtract data type isnt a concrete data structure, in the way an array is. With array we know data is stored in a contiguous memory block.
 * But lists dont do that. They dictate how we can access these items rather than how the data is organized.
 * 
 * Concrete data structures are usually classes in the JDK. For ADT, they are interfaces.
 * Any DS can be used to implement an ADT. As long as we have a class that implements the interface for the ADT.
 * In case of list, any class that implements the list interface is a list. eg. classes using Array implements the list interface, it can be a list.
 * 
 * Note: We cannot store primitives in ArrayList, it can only store objects. But array can contain both primitives and objects in Java. Since Java 5, primitives are automatically converted in objects which is known as auto-boxing.
 * 
 * Array vs ArrayList = https://www.javatpoint.com/array-vs-arraylist-in-java#:~:text=Array%20is%20a%20fixed%20length,primitives%20and%20objects%20in%20Java.
 * @author  Sonali Basu
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String args[]){

        // ************************* ARRAY LIST **************************

        List<Employee> employeeList = new ArrayList<>();
        // arrayList is backed by an array. So why not just use an array?
        // arrayList gives us a bunch of methods + implements the list interface.
        //default backing array capacity is 10. Good practice to pass the capacity in the constructor to enable efficient performance.
        employeeList.add(new Employee("Sonali", "Basu", 2406));
        employeeList.add(new Employee("Tushar", "Shanker", 2101));
        employeeList.add(new Employee("ABC", "Swap", 9999));

        
        // works well as toString has been overriden. Try commenting the toString override and running.
        // Would return the object, ie. Employee@4361bd48.
        System.out.println("Initial list");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        // System.out.println(employeeList[1]) throws error "The type of the expression must be an array type but it resolved to List<Employee>"
        System.out.println("Get value at index: " + employeeList.get(1));
        System.out.println("Is list empty? " + employeeList.isEmpty());

        // random access/ setting a value has O[1] time complexity.
        employeeList.set(2, new Employee("ABC2", "Swapped", 0));

        System.out.println("Replacing a value in list");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        employeeList.add(new Employee("Added", "ToTheEnd", 1));
        System.out.println("Adding to the end");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        // adding an employee is constant time complexity IF added to the end. But if added at a specific position, it needs to shift the elems.
        // thats why this does not remain as O(1). Worst case would be O(n) if added to the start of an array.

        employeeList.add(3, new Employee("Added", "BeforeTheEnd", 9432));
        System.out.println("Adding to the end");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        // size gives current size, NOT the capacity of backnig array.
        System.out.println("Size = " + employeeList.size());
    
        // making a traditional array out of an arrayList
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        System.out.println("employeeArray ");
        for(Employee employee: employeeArray){
            System.out.println(employee);
        }

        System.out.println("Type employeeArray : " + employeeArray.getClass());
        // Referenec to the notation: https://stackoverflow.com/questions/5085889/l-array-notation-where-does-it-come-from
        System.out.println("Type employeeList : " + employeeList.getClass());
        System.out.println("Type employeeList element : " + employeeList.get(0).getClass());
        System.out.println("Type employeeArray element : " + employeeArray[0].getClass());

        // Important. This returns false as we have not overriden the equals method. Hence, under the hood it checks if the value is exactly the same object.
        System.out.println(employeeList.contains(new Employee("Sonali", "Basu", 2406)));
        
        // Same logic of time complexity for item removal.

        // ************************* VECTOR **************************

        // Vector vs arrayList - Vectors give us thread safety. eg. if I'm using multiple threads and they are writing to the same list, we will face issues. However, this synchronization feature of vectors comes with an overhead. If thread safe implementation is not required, just stick to arrayList.

        List<Employee> employeeVector = new Vector<>();
        // diving into the vector contructor, you can see that this too has backing capacity of 10 and uses a backing array.
        // however the add method will be public synchronized boolean vs public boolean for arraylist.
        employeeVector.add(new Employee("Sonali", "Basu", 2406));
        employeeVector.add(new Employee("Tushar", "Shanker", 2101));
        employeeVector.add(new Employee("ABC", "Swap", 9999));
        
        System.out.println("Type employeeVector : " + employeeVector.getClass());
        System.out.println("Type employeeVector element : " + employeeVector.get(0).getClass());

        // ************************* SINGLY LINKED LIST **************************

        // diff than array + lists backed by arrays. In these, the items are unaware of other items in the list.
        // in LLs we need to store some extra info eg. the value + reference to another item
        // first item is head, last item points to null. having a reference to head means we can traverse the entire list.
        // we have a linkedList class, but coding a implementation for kicks.

        // pro = memory doesn't need to be assigned at the start. Can expand as required.
        // con = if memmory is tight, this might be problematic. As we need to store that extra reference information in each node

        EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();

        System.out.println("Is the LinkedList empty? " + employeeLinkedList.isEmpty());
        System.out.println("Type EmployeeLinkedList : " + employeeLinkedList.getClass());
        employeeLinkedList.addToFront(new Employee("Sonali", "Basu", 2406));

        employeeLinkedList.printList(); // will give us object references unless we override the toString method in EmployeeNode class.

        // insertion at the start of list is constant time. Insertion is always done at the HEAD of LL.
        // 1) Create new object 2) Assign current first item to next field 3) Assign head to new object 
        employeeLinkedList.addToFront(new Employee("Tushar", "Shanker", 2101));
        employeeLinkedList.addToFront(new Employee("ABC", "XYZ", 9999));

        employeeLinkedList.printList(); // last item is at the front of the LL as expected.
        System.out.println("LinkedList size = " + employeeLinkedList.getSize());
        System.out.println("Is the LinkedList empty? " + employeeLinkedList.isEmpty());


        // removal of item from head of LL (also constant time)
        // 1) Assign deleted object to a temp var removedNode 2) assign head to next item of removedNode 3) return removedNode

        EmployeeNode removedNode = employeeLinkedList.removeFromFront();
        System.out.println("Size after removal = " + employeeLinkedList.getSize());
        System.out.println("Removed node = " + removedNode);
        System.out.println("OG linked list: ");
        employeeLinkedList.printList();



    }
};
