package doublylinkedlists;

public class EmployeeNode {
    private Employee employee;
    // not setting to null as that's the default for objects
    private EmployeeNode next;
    private EmployeeNode previous;

    public EmployeeNode getPrevious() {
        return previous;
    }

    public void setPrevious(EmployeeNode previous) {
        this.previous = previous;
    }

    public EmployeeNode(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return employee.toString();
    }
}
