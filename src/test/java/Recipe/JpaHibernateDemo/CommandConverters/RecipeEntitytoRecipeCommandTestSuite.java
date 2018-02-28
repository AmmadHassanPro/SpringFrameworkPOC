package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Commands.RecipeCommand;
import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Entities.Difficulty;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
import Recipe.JpaHibernateDemo.Entities.Notes;
import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecipeEntitytoRecipeCommandTestSuite {

	
	@Autowired
	Recipe recipeEntity;

	RecipeCommand recipeCommand;
	@Autowired
	Notes notesEntity;
	
	NotesCommand notesCommand;
	byte[] bte= {1,2,3};
	Difficulty diff;
	@Autowired
	Set<Category> categories;
	@Autowired
	Category catEntity;
	@Autowired
	Ingredient ingEntity;
	@Autowired
	Set<Ingredient> ingredients;
	@Autowired
	RecipeEntityToRecipeCommands converter;
	
	
	public Set<Ingredient> initIngredients (Recipe recs){
		
		ingEntity.setId(1L);
		ingEntity.setAmount(new BigDecimal(15));
		ingEntity.setDescription("Sample Desciption");
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(1L);
		uom.setDescription("sample Desciption");
		ingEntity.setUom(uom);
		ingEntity.setRecipes(recs);
		ingredients.add(ingEntity);
		return ingredients;
	}
	
	
	public Notes initNotes(Recipe rec) {
		notesEntity.setId(2L);
		notesEntity.setRecipeNotes("Example Notes");
		notesEntity.setRecipe(rec);
		return notesEntity;
	}
	
	public Set<Category> initCategories(Recipe rec) {
		
		catEntity.setId(1L);
		catEntity.setDescription("Example Desc");
		Set recSet = new HashSet<Category>();
		recSet.add(rec);
		catEntity.setRecipes(recSet);
		categories.add(catEntity);
		return categories;

	}
	
	
	
	
	@Before
	public void init() {
		recipeEntity.setName("Example Name");
		recipeEntity.setId(1L);
		recipeEntity.setPrepTime(1);
		recipeEntity.setSource("Example Source");
		recipeEntity.setServings(1);
		recipeEntity.setImage(bte);
		recipeEntity.setCookTime(1);
		recipeEntity.setDescription("Sample Description");
		recipeEntity.setDifficulty(diff.EASY);
		recipeEntity.setUrl("Example Url");
		
		//Initializing Notes	
		recipeEntity.setRecipeNotes(this.initNotes(recipeEntity)); // Two Way relationship between Recipe & Notes
		
		//Initializing Categories
		recipeEntity.setCategories(this.initCategories(recipeEntity)); // Two Way many-to-many relationship between Cat and Rec
		
		//Initializing Ingredients
		recipeEntity.setIngredients(this.initIngredients(recipeEntity)); // Two Way one-many relation between Recipe to Ingredient
	
		
		
	}
	
	
	@Test
	public void testCommandConverter() {
		
		recipeCommand = converter.convert(recipeEntity);
		
		assertEquals(recipeEntity.getId() , recipeCommand.getId());
		assertEquals(recipeEntity.getDescription(),recipeCommand.getDescription());
		assertEquals(recipeEntity.getName(),recipeCommand.getName());
		assertEquals(recipeEntity.getUrl(),recipeCommand.getUrl());
		assertEquals(recipeEntity.getSource(),recipeCommand.getSource());
		assertEquals(recipeEntity.getServings(),recipeCommand.getServings());
		assertEquals(recipeEntity.getRecipeNotes().getId(),recipeCommand.getRecipeNotes().getId());
		assertEquals(recipeEntity.getRecipeNotes().getRecipeNotes(),recipeCommand.getRecipeNotes().getRecipeNotes());
		assertEquals(recipeEntity.getPrepTime(),recipeCommand.getPrepTime());
		assertEquals(recipeEntity.getIngredients().hashCode(),recipeCommand.getIngredients().hashCode());;
		
		
	}
	
	
	
	
	
	

}
