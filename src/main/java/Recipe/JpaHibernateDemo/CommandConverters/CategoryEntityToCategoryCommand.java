package Recipe.JpaHibernateDemo.CommandConverters;
import Recipe.JpaHibernateDemo.Entities.Category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
@Component
public class CategoryEntityToCategoryCommand implements Converter<Category, CategoryCommand>{
	

	@Override
	public CategoryCommand convert(Category categoryEntity) {
		if(categoryEntity == null) {
			return null;
			
		}
		final CategoryCommand categoryCommand = new CategoryCommand();//Creating it immutable
		
		categoryCommand.setDescription(categoryEntity.getDescription());
		categoryCommand.setId(categoryEntity.getId());
		return categoryCommand;
	}
	//Method for converting List of CategoryEntities to List of Category Entities Commands
	public List<CategoryCommand> converToCategoryCommandList(List<Category> catEntityList){
		List<CategoryCommand> catCommandList = new ArrayList<CategoryCommand>();
		if(catEntityList == null) {
		return null;
		}
		
		for(Category category:catEntityList) {
			catCommandList.add(this.convert(category));
			
		}
		
		return catCommandList;
		
		
		
	}
	
	
}
