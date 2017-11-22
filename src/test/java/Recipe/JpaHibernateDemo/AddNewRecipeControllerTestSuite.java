package Recipe.JpaHibernateDemo;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import Recipe.JpaHibernateDemo.Controller.AddNewRecipeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddNewRecipeControllerTestSuite {
	@Autowired
	private AddNewRecipeController controller;
	
	
	@Test
	public void testAddNew() throws Exception {
		
		MockMvc mocks = MockMvcBuilders.standaloneSetup(controller).build();
		mocks.perform(get("/addNewRecipe")).andExpect(status().isOk()).andExpect(view().name("NewRecipe"));
	}

}
