package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
import Recipe.JpaHibernateDemo.Entities.Category;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryEntityToCategoryCommandTestSuite {
@Autowired 
private CategoryEntityToCategoryCommand cetcc;
@Autowired
private Category categoryEntity;
private CategoryCommand categoryCommand;


@Before
public void setUp() {
	
	categoryEntity.setId(1L);
	categoryEntity.setDescription("Test Description");
	
}
	@Test
	public void testConvert() {
		categoryCommand = cetcc.convert(categoryEntity);
		
		assertEquals(categoryCommand.getId(),categoryEntity.getId());
		assertEquals(categoryCommand.getDescription(),categoryEntity.getDescription());
		
	}
	
	@Test
	public void nullCheck() {
		categoryEntity = null;
		categoryCommand = cetcc.convert(categoryEntity);
		Assert.assertNull(categoryEntity);
		
	}

}
