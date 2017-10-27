package Recipe.JpaHibernateDemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;
import Recipe.JpaHibernateDemo.Service.RecipeService;
@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql("data.sql")
public class RecipeControllerTestSuite {
	@Mock
	private RecipeService recpie_service;
	@Autowired
	private RecipeService recpie_service_autowired;
	@Autowired
	private RecipeController recipeController;
	@Mock
	private Model model;
	
	List<Recipe> recipe_list;
	ArgumentCaptor<List<Recipe>> arg_capture;
	ArgumentCaptor<Recipe> RecipeArgumentCaptor;

	@Autowired	
	private RecipeRepository recipe_repo;
	
	@Before
	public void setUp() throws Exception{
		// Registering all the objects as mocks which are annotated with @Mock
		MockitoAnnotations.initMocks(this);
		// Initializing
		recipeController = new RecipeController(recpie_service);
		//Given
		//Adding two Recipe Objects, because we initialize two recipe on start in database
		recipe_list = new ArrayList<Recipe>(); 
		
		recipe_list.add(new Recipe());
		recipe_list.add(new Recipe());
		// It will capture the argument passed in realtime for us
		arg_capture  = ArgumentCaptor.forClass(List.class);
		RecipeArgumentCaptor = ArgumentCaptor.forClass(Recipe.class);
	}
	
	//A demonstration of Spring Mock MVC
	@Test
	public void SpringMockMVCTest() throws Exception{
	MockMvc mockMVC = MockMvcBuilders.standaloneSetup(recipeController).build();
	// A test that will enusre that when getRecipe is called "Recipe List" view is returned.
	mockMVC.perform(get("/getRecipe")).andExpect(status().isOk()).andExpect(view().name("RecipeList"));
	
	}
	
	
	@Test
	public void getRecipeList() throws Exception{
	// Substituting findALL return value with this.recipe_list. We can do that when the object is registered as a Mock.
	when(recpie_service.findAll()).thenReturn(this.recipe_list);
	//When
	String recipe_page = recipeController.getRecipeList(model);
	//Then
	// Verifying if the string returned by the controller is the same as the one returned by our mock
	assertEquals(recipe_page,"RecipeList");
	//Verifying if the method is executed only one time
	verify(recpie_service,times(1)).findAll();
	verify(model,times(1)).addAttribute(eq("Recipes"),arg_capture.capture());//Verifying if the method is executed only one time.// Capturing argument passed are two, so it will enusre that only two Recipe objects are initialized on start
	List<Recipe> captured = arg_capture.getValue();
	assertEquals(2,captured.size());
	
	}
	
	
	@Test
	//Test for checking the Recipe Repository
	public void testRecipeRepositoryForFindById() throws Exception{
		
		Optional<Recipe> optRecipe = recipe_repo.findById(1L);
		assertEquals("Perfect Guacamole",optRecipe.get().getName());
	}
	
	
	@Test
	//Test for checking the RecipeService
	public void testRecipeServiceForFindById() throws Exception{
		
		Recipe recipe = recpie_service_autowired.findById("1");
		assertEquals("Perfect Guacamole",recipe.getName());
	}
	

	
	@Test
	public void getRecipebyId() throws Exception{
	//Need a real Recipe Object from the database, that is why I used @Autowired version of the RecipeService
	Recipe recipe = recpie_service_autowired.findById("1");
	
	// Re-intializing the RecipeController object , because we were passing a mock RecipeService in the @Before code block, but this time we needed to pass a real RecipeService object.
	recipeController = new RecipeController(recpie_service_autowired); 
		
	String returnedPageName = recipeController.getRecipeById("1", model);
	
	verify(model,times(1)).addAttribute(eq("Recipe"),RecipeArgumentCaptor.capture());
	
	assertEquals(recipe.getName(),RecipeArgumentCaptor.getValue().getName());

	assertEquals(returnedPageName,"RecipeById");

	}
	


}
