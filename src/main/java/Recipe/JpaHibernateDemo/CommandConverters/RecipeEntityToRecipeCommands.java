package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.RecipeCommand;
import Recipe.JpaHibernateDemo.Entities.Recipe;

@Component
public class RecipeEntityToRecipeCommands implements Converter<Recipe,RecipeCommand> {

	
	RecipeCommand recipeCommand = new RecipeCommand();
	
	@Override
	public RecipeCommand convert(Recipe recipeEntity) {
		if (recipeEntity == null) {
			return null;
		}
		
		
		
		
		
		return null;
	}

}
