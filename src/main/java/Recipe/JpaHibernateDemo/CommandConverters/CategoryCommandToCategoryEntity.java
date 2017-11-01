package Recipe.JpaHibernateDemo.CommandConverters;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
import Recipe.JpaHibernateDemo.Entities.Category;
@Component
public class CategoryCommandToCategoryEntity implements Converter<CategoryCommand, Category>{
	@Autowired
	private Category categoryEntity;
	@Autowired
	private Set<Category> categoryEntityList;
	@Override
	public Category convert(CategoryCommand categoryCommand) {
		if(categoryCommand==null)
		{return null;}
		this.categoryEntity.setDescription(categoryCommand.getDescription());
		this.categoryEntity.setId(categoryCommand.getId());
		return this.categoryEntity;
	}
	//Method for converting List of CategoryCommands to List of Category Entities
	public Set<Category> convertToCategorySet(Set<CategoryCommand> categoryCommandList) {
		if(categoryCommandList==null)
		{return null;}
		for(CategoryCommand cc: categoryCommandList) {
		categoryEntityList.add(this.convert(cc));
		}
		
		return categoryEntityList;
	}
	
	
	
	
}
