package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.UnitOfMeasureCommand;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
@Component

public class UnitOfMeasureCommandToUnitOfMeasureEntity implements Converter<UnitOfMeasureCommand,UnitOfMeasure>{
	@Autowired
	private UnitOfMeasure uom;
	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
		if(unitOfMeasureCommand == null)
		{return null;}
		
		
		uom.setId(unitOfMeasureCommand.getId());
		uom.setDescription(unitOfMeasureCommand.getDescription());
		
		return uom;
		
		
		
		
	}

}
