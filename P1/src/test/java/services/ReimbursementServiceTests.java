package services;

import com.revature.daos.EmployeeDao;
import com.revature.daos.ReimbursementDao;
import com.revature.entities.Employee;
import com.revature.entities.Reimbursement;
import com.revature.service.ReimbursementService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ReimbursementServiceTests {

    @InjectMocks
    private static ReimbursementService reimbursementService;

    @Mock
    private static ReimbursementDao mockReimbursementDao;

    @Mock
    private static EmployeeDao mockEmployeeDao;

    @Mock
    private List<Reimbursement> mockReList;

    @Mock
    private Reimbursement mockReimbursement;

    @Mock
    private Employee mockEmployee;

    private Reimbursement mockReimbursement2;



    @BeforeAll
    public static void setup(){
        mockEmployeeDao = new EmployeeDao();
        mockReimbursementDao = new ReimbursementDao();
        reimbursementService = new ReimbursementService(mockReimbursementDao,mockEmployeeDao);
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

        mockReimbursement = new Reimbursement(
                5,
                "2025-12-22",
                "0900",
                "TX",
                "description",
                250,
                "Other",
                "justification",
                "PENDING",
                7,
                "PASSED"
        );
        mockReList = new ArrayList<>(Arrays.asList(mockReimbursement));

        mockReimbursement2 = new Reimbursement(
                5,
                "2025-12-22",
                "0900",
                "TX",
                "description",
                250,
                "Other",
                "justification",
                "PENDING",
                7,
                "PASSED"
        );
    }

    @Test
    public void createNewReimbursementTest() {
        when(mockReimbursementDao.create(mockReimbursement)).thenReturn(mockReimbursement);

        Reimbursement re = reimbursementService.createRe(mockReimbursement);

        Assertions.assertNotNull(re);

    }

    @Test
    public void getReimbursementByIdTest() {
        when(reimbursementService.getById(mockReimbursement2.getRe_id())).thenReturn(mockReimbursement2);

        Reimbursement re2 = reimbursementService.getById(mockReimbursement2.getRe_id());

        Assertions.assertNotNull(re2);
    }

    @Test
    public void getAllReibmursementsTest() {
        when(mockReimbursementDao.getAll()).thenReturn(mockReList);
        List<Reimbursement> reL = reimbursementService.getAllRe(mockReimbursement.getOrder_id());
        Assertions.assertNotNull(reL);
    }

    @Test
    public void updateReimbursementTest(String status, int reid){



    }


}
