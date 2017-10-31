package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.core.convert.converter.Converter;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Commands.UnitOfMeasureCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;

public class UnitOfMeasureEntityToUnitOfMeasureCommand implements Converter<UnitOfMeasure,UnitOfMeasureCommand>{

	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasureEntity) {
		if(unitOfMeasureEntity == null) {
		return null;
	}
		final UnitOfMeasureCommand unitOfMeasureCommandObj = new UnitOfMeasureCommand();
		
		unitOfMeasureCommandObj.setId(unitOfMeasureEntity.getId());
		unitOfMeasureCommandObj.setDescription(unitOfMeasureEntity.getDescription());
		return unitOfMeasureCommandObj;
}

}