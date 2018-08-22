package Recipe.JpaHibernateDemo.CommandConverters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;

@Component
public class IngredientCommandToIngredientEntity implements Converter<IngredientCommand, Ingredient>{
	
	private Ingredient ingredientObj;
	@Autowired
	private UnitOfMeasureCommandToUnitOfMeasureEntity uomctoe;
	private List<Ingredient> ingredientSet;
	@Override
	public Ingredient convert(IngredientCommand ingredientCommand) {
		
		if(ingredientCommand == null) {
		
		return null;
		}
		ingredientObj = new Ingredient();
		ingredientObj.setId(ingredientCommand.getId());
		ingredientObj.setAmount(ingredientCommand.getAmount());
		// Converting the returned objected from ingredientCommand, which will be UnitOfMeasureCommand object, to UnitOfMeasureEntity Object
		ingredientObj.setUom(uomctoe.convert(ingredientCommand.getUom())); 
		ingredientObj.setDescription(ingredientCommand.getDescription());
		
		return ingredientObj;
		
	}
	//Method for converting List of IngredientCommands to List of Ingredient Entities
	public List<Ingredient> convertToIngredientSet(List<IngredientCommand> list) {
		ingredientSet = new ArrayList<Ingredient>();
		if(list==null) {
			return null;
		}
		for(IngredientCommand ingredientCommand: list) {
			ingredientSet.add(this.convert(ingredientCommand));
			
			
		}
		
		return ingredientSet;
	}
	
	

}
