package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;

@Component
public class IngredientCommandToIngredientEntity implements Converter<IngredientCommand, Ingredient>{
	
	@Autowired
	private Ingredient ingredientObj;
	@Override
	public Ingredient convert(IngredientCommand ingredientCommand) {
		
		if(ingredientCommand == null) {
		
		return null;
		}
		
		ingredientObj.setId(ingredientCommand.getId());
		//ingredientObj.setUom(ingredientCommand.getUom()); Need to implement Later
		ingredientObj.setDescription(ingredientCommand.getDescription());
		
		return ingredientObj;
		
	}

}
