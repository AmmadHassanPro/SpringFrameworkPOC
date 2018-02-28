package Recipe.JpaHibernateDemo.CommandConverters;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Commands.RecipeCommand;
import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
import Recipe.JpaHibernateDemo.Entities.Notes;
import Recipe.JpaHibernateDemo.Entities.Recipe;

@Component
public class RecipeEntityToRecipeCommands implements Converter<Recipe,RecipeCommand> {

	private RecipeCommand recipeCommand = new RecipeCommand();
	private Set<CategoryCommand> CatcommandsSet = new HashSet<CategoryCommand>();
	private Set<IngredientCommand> IngcommandsSet = new HashSet<IngredientCommand>();
	
	private Set<Category> catSet;
	private Set<Ingredient> ingSet;
	
	private Iterator iter;
	
	@Autowired
	private CategoryEntityToCategoryCommand catConverter;
	
	@Autowired
	private IngredientEntityToIngredientCommand ingConverter;
	
	@Autowired
	private NotesEntityToNotesCommand noteConverter;
	
	
	private NotesCommand note;
	
	
	@Override
	public RecipeCommand convert(Recipe recipeEntity) {
		if (recipeEntity == null) {
			return null;
		}
		
		// Categories Entity Set to Category Command Set
		catSet = recipeEntity.getCategories();
		iter = catSet.iterator();
		Category cat;
		while(iter.hasNext()) {
			cat = (Category) iter.next();
			CatcommandsSet.add(catConverter.convert(cat));
		}
		
		recipeCommand.setCategories(CatcommandsSet); 
		
		//Ingredient Entity Set to Ingredient Command Set
		ingSet = recipeEntity.getIngredients();
		Ingredient ing;
		while(iter.hasNext()) {
			ing = (Ingredient) iter.next();
			IngcommandsSet.add(ingConverter.convert(ing));
		}
		
		recipeCommand.setIngredients(IngcommandsSet);
		// Notes Entity to Notes Command
		note = noteConverter.convert(recipeEntity.getRecipeNotes());
		
		recipeCommand.setRecipeNotes(note);
		
		recipeCommand.setCookTime(recipeEntity.getCookTime());
		recipeCommand.setDescription(recipeEntity.getDescription());
		recipeCommand.setDirections(recipeEntity.getDescription());
		recipeCommand.setId(recipeEntity.getId());
		recipeCommand.setName(recipeEntity.getName());
		recipeCommand.setPrepTime(recipeEntity.getPrepTime());
		recipeCommand.setServings(recipeEntity.getServings());
		recipeCommand.setSource(recipeEntity.getSource()) ;
		recipeCommand.setUrl(recipeEntity.getUrl());
		return recipeCommand;
	}

}
