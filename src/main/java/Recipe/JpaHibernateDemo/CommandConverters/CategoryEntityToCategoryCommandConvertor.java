package Recipe.JpaHibernateDemo.CommandConverters;
import Recipe.JpaHibernateDemo.Entities.Category;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
@Component
public class CategoryEntityToCategoryCommandConvertor implements Converter<Category, CategoryCommand>{

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

}
