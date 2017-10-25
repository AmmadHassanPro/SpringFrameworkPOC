package Recipe.JpaHibernateDemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import Recipe.JpaHibernateDemo.BootStrapClass.FirstBootStrapClass;
import Recipe.JpaHibernateDemo.Controller.RecipeController;
import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Service.RecipeService;
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql("data.sql")
public class RecipeControllerTestSuite {// This Junit test case will validate if the Controller is returning the String "RecipeList".
	@Mock
	private RecipeService recpie_service;
	@Autowired
	private RecipeController recipeController;
	@Mock
	private Model model;
	List<Recipe> recipe_list;
	ArgumentCaptor<List<Recipe>> arg_capture;
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);// Registering all the objects as mocks which are annotated with @Mock
		recipeController = new RecipeController(recpie_service);// Initializing
		//Given
		
		recipe_list = new ArrayList<Recipe>(); //Adding two Recipe Objects, because we initialize two recipe on start in database
		
		recipe_list.add(new Recipe());
		recipe_list.add(new Recipe());
		
		arg_capture  = ArgumentCaptor.forClass(List.class);// It will capture the argument passed in realtime for us
	}
	
	//A demonstration of Spring Mock MVC
	@Test
	public void SpringMockMVCTest() throws Exception{
	MockMvc mockMVC = MockMvcBuilders.standaloneSetup(recipeController).build();
	mockMVC.perform(get("/getRecipe")).andExpect(status().isOk()).andExpect(view().name("RecipeList"));// A test that will enusre that when getRecipe is called "Recipe List" view is returned.
	
	}
	
	
	@Test
	public void getRecipeList() throws Exception{
	when(recpie_service.findAll()).thenReturn(this.recipe_list);// Substituting findALL return with this.recipe_list. We can do that when the object is registered as a Mock.
	//When
	String recipe_page = recipeController.getRecipeList(model);
	//Then
	assertEquals(recipe_page,"RecipeList");// Verifying if the string returned by the controller is the same as the one returned by our mock
	verify(recpie_service,times(1)).findAll();//Verifying if the method is executed only one time
	verify(model,times(1)).addAttribute(eq("Recipes"),arg_capture.capture());//Verifying if the method is executed only one time.// Capturing argument passed are two, so it will enusre that only two Recipe objects are initialized on start
	List<Recipe> captured = arg_capture.getValue();
	assertEquals(3,captured.size());
	
	}


}
