package Recipe.JpaHibernateDemo.CommandConverters;

import java.util.ArrayList;
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
	private Category categoryEntity;
	private List<Category> categoryEntityList = new ArrayList<Category>();
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
	public List<Category> convertToCategoryList(List<CategoryCommand> list) {
		if(list==null)
		{return null;}
		for(CategoryCommand cc: list) {
		this.categoryEntityList.add(this.convert(cc));
		}
		
		return this.categoryEntityList;
	}
	
	
	
	
}
