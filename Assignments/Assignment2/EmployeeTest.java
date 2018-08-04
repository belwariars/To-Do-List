import com.studentpackage.Employee;
import com.studentpackage.EmployeeAgeComparator;
import com.studentpackage.EmployeeJobTitleComparator;
import com.studentpackage.EmployeeSalaryComparator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private static final double DELTA = 1e-15;


    @Test
    public void ageComparator() {

        EmployeeAgeComparator employeeAgeComparator = new EmployeeAgeComparator();
        Employee employee1 = new Employee(" ", "", 5, 10);
        Employee employee2 = new Employee(" ", "", 3, 10);

        assertEquals(2, employeeAgeComparator.compare(employee1, employee2));
    }

    @Test
    public void salaryComparator() {

        EmployeeSalaryComparator employeeSalaryComparator = new EmployeeSalaryComparator();
        Employee employee1 = new Employee(" ", "", 5, 10);
        Employee employee2 = new Employee(" ", "", 3, 10);

        assertEquals(0, employeeSalaryComparator.compare(employee1, employee2));
    }

    @Test
    public void JobTitleComparator() {

        EmployeeJobTitleComparator employeeJobTitleComparator  = new EmployeeJobTitleComparator();
        Employee employee1 = new Employee(" ", "", 5, 10);
        Employee employee2 = new Employee(" ", "", 3, 10);

        assertEquals(0, employeeJobTitleComparator.compare(employee1, employee2));
    }




}
