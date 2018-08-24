package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernatDemo.Utilities.ImageConverter;
import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Commands.RecipeCommand;
import Recipe.JpaHibernateDemo.Entities.Notes;
import Recipe.JpaHibernateDemo.Entities.Recipe;

@Component
public class RecipeCommandToRecipeEntity implements Converter<RecipeCommand,Recipe>{
@Autowired
private Recipe recipeEntity;
@Autowired
private CategoryCommandToCategoryEntity cctcec;
@Autowired
private IngredientCommandToIngredientEntity ictiec;
@Autowired
private NotesCommandToNotesEntity nctne;
private ImageConverter imgConv = new ImageConverter();

	@Override
	public Recipe convert(RecipeCommand recipeCommand) {
		if(recipeCommand == null) {
		return null;
		}
		recipeEntity.setId(recipeCommand.getId());
		recipeEntity.setDescription(recipeCommand.getDescription());
		recipeEntity.setCookTime(recipeCommand.getCookTime());
		recipeEntity.setPrepTime(recipeCommand.getPrepTime());
		recipeEntity.setDescription(recipeCommand.getDescription());
		recipeEntity.setDifficulty(recipeCommand.getDifficulty());
		recipeEntity.setDirections(recipeCommand.getDirections());
		recipeEntity.setName(recipeCommand.getName());
		recipeEntity.setServings(recipeCommand.getServings());
		recipeEntity.setSource(recipeCommand.getSource());
		recipeEntity.setUrl(recipeCommand.getUrl());
		//Converting List of CategoryCommands to List of Category Entities and setting it in recipeEntity
		recipeEntity.setCategories(cctcec.convertToCategoryList(recipeCommand.getCategories()));
		//Converting List of Ingredient Commands to List of Ingredient Entities and setting it in recipeEntity
		recipeEntity.setIngredients(ictiec.convertToIngredientSet(recipeCommand.getIngredients()));
		//Converting Notes Command to Notes Entity and setting it in recipeEntity
		recipeEntity.setRecipeNotes(nctne.convert(recipeCommand.getRecipeNotes()));
		recipeEntity.setImage(imgConv.ConvertToByteArray(recipeCommand.getUrl()));
		
		return recipeEntity;
		
		
	}

}
