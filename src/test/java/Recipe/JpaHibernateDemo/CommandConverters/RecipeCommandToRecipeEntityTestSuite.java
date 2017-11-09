package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Commands.RecipeCommand;
import Recipe.JpaHibernateDemo.Commands.UnitOfMeasureCommand;
import Recipe.JpaHibernateDemo.Entities.Difficulty;
import Recipe.JpaHibernateDemo.Entities.Recipe;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecipeCommandToRecipeEntityTestSuite {

	@Autowired
	private RecipeCommandToRecipeEntity rctre;
	@Autowired 
	private Recipe recipeEntity;
	
	private RecipeCommand recipeCommand;
	private Set<IngredientCommand> ingredients;
	private Set<CategoryCommand> categories;
	private NotesCommand notesCommand;
	private Difficulty difficulty;
	private CategoryCommand catCommand;
	private IngredientCommand ingreCommand;
	
	@Before
	public void setUp(){
		recipeCommand = new RecipeCommand();
		ingredients = new HashSet<IngredientCommand>();
		categories = new HashSet<CategoryCommand>();
		catCommand = new CategoryCommand();
		catCommand.setId(1L);
		catCommand.setDescription("Test Description");
		categories.add(catCommand);
		ingreCommand = new IngredientCommand();
		ingreCommand.setId(1L);
		ingreCommand.setDescription("Test Description");
		ingreCommand.setAmount(new BigDecimal(10));
		ingreCommand.setUom(new UnitOfMeasureCommand());
		ingredients.add(ingreCommand);
		notesCommand = new NotesCommand();
		notesCommand.setId(1L);
		notesCommand.setRecipeNotes("Test Notes");
		
	}
	
	@Test
	public void testConvert() {
		recipeCommand.setDescription("Test Description");
		recipeCommand.setDifficulty(difficulty.EASY);
		recipeCommand.setDirections("Test Directions");
		recipeCommand.setId(1L);
		recipeCommand.setName("Test Name");
		recipeCommand.setPrepTime(1);
		recipeCommand.setServings(1);
		recipeCommand.setSource("Test Source");
		recipeCommand.setUrl("Test URL");
		recipeCommand.setIngredients(ingredients);
		recipeCommand.setCategories(categories);
		recipeCommand.setRecipeNotes(notesCommand);
		recipeCommand.setCookTime(20);
		
		recipeEntity = rctre.convert(recipeCommand);
		
		assertEquals(recipeEntity.getId(),recipeEntity.getId());
		assertEquals(recipeEntity.getCategories(),recipeEntity.getCategories());
		assertEquals(recipeEntity.getCookTime(),recipeEntity.getCookTime());
		assertEquals(recipeEntity.getDescription(),recipeEntity.getDescription());
		assertEquals(recipeEntity.getDifficulty(),recipeEntity.getDifficulty());
		assertEquals(recipeEntity.getDirections(),recipeEntity.getDirections());
		assertEquals(recipeEntity.getIngredients(),recipeEntity.getIngredients());
		assertEquals(recipeEntity.getName(),recipeEntity.getName());
		assertEquals(recipeEntity.getPrepTime(),recipeEntity.getPrepTime());
		assertEquals(recipeEntity.getRecipeNotes(),recipeEntity.getRecipeNotes());
		assertEquals(recipeEntity.getServings(),recipeEntity.getServings());
		assertEquals(recipeEntity.getSource(),recipeEntity.getSource());
		assertEquals(recipeEntity.getUrl(),recipeEntity.getUrl());
	}
	
	@Test
	public void nullCheck() {
		recipeCommand = null;
		recipeEntity = rctre.convert(recipeCommand);
		Assert.assertNull(recipeEntity);
		
	}
	
	
	

}
