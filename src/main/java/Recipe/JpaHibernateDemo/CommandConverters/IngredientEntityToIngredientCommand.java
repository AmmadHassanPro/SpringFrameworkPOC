package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.core.convert.converter.Converter;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;

public class IngredientEntityToIngredientCommand implements Converter<Ingredient,IngredientCommand>{

	@Override
	public IngredientCommand convert(Ingredient IngredientEntity) {
		if(IngredientEntity==null) {
		return null;
		}
	final IngredientCommand ingredientCommand = new IngredientCommand();
	
	
	ingredientCommand.setAmount(IngredientEntity.getAmount());
	ingredientCommand.setDescription(IngredientEntity.getDescription());
	ingredientCommand.setId(IngredientEntity.getId());
	//ingredientCommand.setUom(IngredientEntity.getUom()); need to implement later
	
	return ingredientCommand;
	}
	

}
