public class EmployeeNode {
    private Employee employee;
    private EmployeeNode next;

    @Override
    public String toString() {
        return "{" +
            " employee='" + getEmployee() + "'" +
            ", next='" + getNext() + "'" +
            "}";
    }


    // constructing an instance we only take the value. As we don't know what the next node will be
    // default for object fields is null, which is why we don't need to explicitly set that.
    public EmployeeNode(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNode getNext() {
        return this.next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

}

