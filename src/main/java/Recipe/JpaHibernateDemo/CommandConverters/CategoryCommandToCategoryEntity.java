package Recipe.JpaHibernateDemo.CommandConverters;

import java.util.HashSet;
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
	private Set<Category> categoryEntitySet;
	@Override
	public Category convert(CategoryCommand categoryCommand) {
		if(categoryCommand==null)
		{return null;}
		categoryEntity = new Category();
		this.categoryEntity.setDescription(categoryCommand.getDescription());
		this.categoryEntity.setId(categoryCommand.getId());
		return this.categoryEntity;
	}
	//Method for converting List of CategoryCommands to List of Category Entities
	public Set<Category> convertToCategorySet(Set<CategoryCommand> categoryCommandList) {
		categoryEntitySet = new HashSet<Category>();
		if(categoryCommandList==null)
		{return null;}
		for(CategoryCommand cc: categoryCommandList) {
		this.categoryEntitySet.add(this.convert(cc));
		}
		
		return this.categoryEntitySet;
	}
	
	
	
	
}
