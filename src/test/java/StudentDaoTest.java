import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.ak.DAO.StudentDao;
import com.ak.main.Main;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
public class StudentDaoTest {
	
	@Autowired
	private StudentDao studentDao;
	
	@Test
	public void getAllStudents(){
		assertEquals(0, studentDao.getAllStudents().size(), 0);
		

	}
	
	
}
