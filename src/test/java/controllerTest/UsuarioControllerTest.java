package controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.happy.happymachine.HappymachineApplication;

@SpringBootTest(classes = HappymachineApplication.class)
@AutoConfigureMockMvc
public class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetUsuarioById() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/usuario/111111")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}