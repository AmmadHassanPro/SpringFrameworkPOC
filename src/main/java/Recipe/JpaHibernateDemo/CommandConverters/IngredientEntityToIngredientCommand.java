package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
@Component

public class IngredientEntityToIngredientCommand implements Converter<Ingredient,IngredientCommand>{
	@Autowired
	UnitOfMeasureEntityToUnitOfMeasureCommand uomctoe;
	@Override
	public IngredientCommand convert(Ingredient IngredientEntity) {
		if(IngredientEntity==null) {
		return null;
		}
	final IngredientCommand ingredientCommand = new IngredientCommand();
	
	
	ingredientCommand.setAmount(IngredientEntity.getAmount());
	ingredientCommand.setDescription(IngredientEntity.getDescription());
	ingredientCommand.setId(IngredientEntity.getId());
	// Converting the retured objected from ingredientEntity, which will be UnitOfMeasureEntityobject, to UnitOfMeasureCommand object
	ingredientCommand.setUom(uomctoe.convert(IngredientEntity.getUom())); 
	
	return ingredientCommand;
	}
	

}
