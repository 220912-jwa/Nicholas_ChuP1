package services;

import com.revature.daos.EmployeeDao;

import com.revature.entities.Employee;

import com.revature.service.EmployeeAuth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class EmployeeAuthTests {

    @InjectMocks
    private static EmployeeAuth mockEmployeeAuth;

    @Mock
    private static EmployeeDao mockEmployeeDao;

    @Mock
    private Employee mockEmployee;

    @BeforeAll
    public static void setup(){
        mockEmployeeDao = new EmployeeDao();
        mockEmployeeAuth = new EmployeeAuth(mockEmployeeDao);
    }

    @BeforeEach
    public void mockData() {
        mockEmployee = new Employee(
                7,
                "Luke",
                "Falls",
                "TDL51",
                "passpass1234",
                1000,
                true
        );
    }
    @Test
    public void loginTest() {
       when(mockEmployeeDao.getEmployeeByUsername(mockEmployee.getUsername())).thenReturn(mockEmployee);
       Employee ne = mockEmployeeAuth.login(mockEmployee.getUsername(),mockEmployee.getPass());
       Assertions.assertNotNull(ne);
    }

    @Test
    public void managerCheck(){
//        when(mockEmployeeDao.getEmployeeByUsername(mockEmployee.getUsername())).thenReturn(mockEmployee);
         assertTrue(mockEmployee.isFinance_manager());

    }
}
