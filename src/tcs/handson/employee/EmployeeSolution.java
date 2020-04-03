
public class EmployeeSolution {
    public static void main(String[] args) {
        int sizeOfArray = 4;
        Employee[] employees = new Employee[sizeOfArray];

        employees[0] = new Employee("E1", 1, "Manager", 20000);
        employees[1] = new Employee("E2", 2, "Trainee", 10000);
        employees[2] = new Employee("E3", 3, "Lead", 30000);
        employees[3] = new Employee("E4", 4, "Lead", 30000);

        for (Employee e : employees) {
            updateEmployeeSalary(e);
            System.out.println(e);
        }

    }

    private static void updateEmployeeSalary(Employee employee) {
        switch (employee.getRole()) {
            case "Manager": {
                employee.setSalary(employee.getSalary() + (employee.getSalary() / 100) * 5);
                break;
            }
            case "Lead": {
                employee.setSalary(employee.getSalary() + (employee.getSalary() / 100) * 10);
                break;
            }
            case "Trainee": {
                employee.setSalary(employee.getSalary() + (employee.getSalary() / 100) * 15);
                break;
            }
            default: {
            }
        }
    }
}
