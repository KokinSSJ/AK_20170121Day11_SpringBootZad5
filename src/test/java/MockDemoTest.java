import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ak.DAO.StudentDao;
import com.ak.entity.Student;
import com.ak.main.Main;
import com.ak.service.StudentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
//@ContextConfiguration
//@WebAppConfiguration
public class MockDemoTest {
	
	
	// Test 1 - test metody z serwisu bez połaczenia z bazą danych => trzeba uzyc mockowania
	// Test 2 - test za pomocą MockMVC -> test metody z controllera - > sprawdzenie czy metoda getAllStudents ->zwróci status poprawnego wykonania
	
	
	@Autowired
	private WebApplicationContext context;
	
	@Mock //blokuje StudentDao domyślny
	private StudentDao studentDao;
	
	@InjectMocks //dodaje customowy StudentDao
	private StudentServiceImpl studentServiceImpl;
	
	
	//do testowania kontrolera - test2
	private MockMvc mockmvc;
	
	@Before
	public void setUp(){
//		MockitoAnnotations.initMocks(this);//
		List<Student> list = Arrays.asList(new Student("Dom", "Bog", 1L, "JAVA"), new Student("Name", "Surname", 2L, "Course"), 
				new Student("Dom3", "Bog3", 3L, "Course3"));
		
		//deklaruje że gdy nastapi próba pobrania z bazydanych przy uzyciu DAO to zamiast tego zwróć listę
		when(studentDao.getAllStudents()).thenReturn(list); // patrz import statyczny z Mockito
		
		mockmvc = MockMvcBuilders.webAppContextSetup(context).build();
		
	}
	
	//test kontrolera // tutaj nie bierze udział "atrapa" !s
	//jeżeli nie zwroci klasa getAllstudents (/student) wyjatku to oznacza że dobrze działa - tutaj sprawdza bazę danych!
	@Test
	public void controllerTest() throws Exception{
		mockmvc.perform(MockMvcRequestBuilders.get("/student")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	//testujemy metode serwisu ale nie chcemy zeby nastapiło połączeni z baza danych
	@Test
	public void mockGetAllStudentsUsingServiceTest(){
		int count = studentServiceImpl.getAllStudents().size();
		assertEquals(3, count);	
	}
	
	

}
