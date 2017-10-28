package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
import Recipe.JpaHibernateDemo.Entities.Category;
@Component
public class CategoryCommandToCategoryEntityConvertor implements Converter<CategoryCommand, Category>{
	@Autowired
	private Category categoryEntity;
	@Override
	public Category convert(CategoryCommand categoryCommand) {
		if(categoryCommand==null)
		{return null;}
		this.categoryEntity.setDescription(categoryCommand.getDescription());
		this.categoryEntity.setId(categoryCommand.getId());
		return this.categoryEntity;
	}
	
}
