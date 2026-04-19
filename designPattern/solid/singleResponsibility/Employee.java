package designPattern.solid.singleResponsibility;

public class Employee {
    public void saveEmployeeDetails(Employee employee) {
        // Logic to save employee data to the database
    }

    public void generatePayrollReport(Employee employee) {
        // Logic to generate a payroll report
    }
}
//the
//
// Employee class has two reasons to change: if database logic changes, or if payroll report logic changes.


//*********Each class now has a single responsibility
/*

public class EmployeeRepository {
    public void save(Employee employee) {
        // Logic to save employee data to the database
    }
}
public class PayrollService {
    public void generateReport(Employee employee) {
        // Logic to generate a payroll report
    }
}*/
