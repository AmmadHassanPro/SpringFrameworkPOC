package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

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
public class CategoryCommandToCategoryEntityTestSuite {
	
	private CategoryCommand catCommand;
	@Autowired
	private Category catEntity;
	@Autowired
	private List<Category> catEntitySet;
	@Autowired
	private CategoryCommandToCategoryEntity cctce;
	
	
	
	@Before
	public void setUp() {
		//Creating Test Command Object
		catCommand = new CategoryCommand();
		catCommand.setDescription("Test Description");
		catCommand.setId(1L);
		
		
	}
	
	@Test
	public void TestConvertMethod() {
		catEntity = cctce.convert(catCommand);
		assertEquals(catEntity.getId(),catCommand.getId());
		assertEquals(catEntity.getDescription(),catCommand.getDescription());
		
		
	}
	@Test
	public void TestConvertSetMethod() {
		List<Category> catEntitySet2 = new ArrayList<Category>();
		List<CategoryCommand> catcommSet = new ArrayList<CategoryCommand>();	
		CategoryCommand item1 = new CategoryCommand();
		item1.setId(1L);
		item1.setDescription("Test Description 2");
		
		CategoryCommand item2 = new CategoryCommand();
		item2.setId(2L);
		item2.setDescription("Test Description 3");
		catcommSet.add(item1);
		catcommSet.add(item2);
		
		catEntitySet2= cctce.convertToCategoryList(catcommSet);
	
		for(int i=0;i<2;i++) {
			
			
			assertEquals(catEntitySet2.get(i).getId(),catcommSet.get(i).getId());
			assertEquals(catEntitySet2.get(i).getDescription(),catcommSet.get(i).getDescription());
			
			
			
		}
		
		
		
	
		
	}
	
	
	@Test
	public void nullCheck() {
		Category catEntity = new Category();
		CategoryCommand cc = null;
		catEntity = this.cctce.convert(cc);
		Assert.assertNull(catEntity);

		List<Category> catEntitySet = new ArrayList<Category>();
		List<CategoryCommand> catCommandSet = null;
		catEntitySet = this.cctce.convertToCategoryList(catCommandSet);
		Assert.assertNull(catEntitySet);

	}
	
	



	

}
