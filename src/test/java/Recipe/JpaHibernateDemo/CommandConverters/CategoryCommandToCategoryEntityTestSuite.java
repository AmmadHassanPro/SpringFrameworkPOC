package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.CategoryCommand;
import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Service.CategoryService;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryCommandToCategoryEntityTestSuite {
	
	private CategoryCommand catCommand;
	@Autowired
	private Category catEntity;
	@Autowired
	private Set<Category> catEntitySet;
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
		Set<CategoryCommand> catcommSet = new HashSet<CategoryCommand>();	
		CategoryCommand item1 = new CategoryCommand();
		item1.setId(1L);
		item1.setDescription("Test Description 2");
		
		CategoryCommand item2 = new CategoryCommand();
		item2.setId(2L);
		item2.setDescription("Test Description 3");
		catcommSet.add(item1);
		catcommSet.add(item2);
		
		catEntitySet= cctce.convertToCategorySet(catcommSet);
		
		//Casting Set to List
		List<Category> tempCatList = new ArrayList<Category>(catEntitySet);
		//Sorting the List
		tempCatList= SortListCategory(tempCatList);
		//Casting Set to List
		List<CategoryCommand> tempCatCommandList = new ArrayList<CategoryCommand>(catcommSet);
		//Sorting the List
		tempCatCommandList=SortListCategoryCommand(tempCatCommandList);
		//Comparing the Sorted List
		for (int i=0;i<catEntitySet.size();i++)
		{
			assertEquals(tempCatList.get(i).getId(),tempCatCommandList.get(i).getId());
			assertEquals(tempCatList.get(i).getDescription(),tempCatCommandList.get(i).getDescription());
			
			
		}
		
		
	
		
	}
	
	// Function to apply Bubble sort for sorting elements for Set and casting it to List
	public List<Category> SortListCategory(List<Category> catList2bsorted) {
		List<Category> resultList1 = catList2bsorted;
			Category temp1 = new Category() ;
			Category temp2 = new Category() ;
			for(int i=0;i<catList2bsorted.size()-1;i++) {
				
				for(int m=0;m<catList2bsorted.size()-i;m++) {
					if (resultList1.get(i).getId() > resultList1.get(i+1).getId()) {
						temp1= resultList1.get(i);
						temp2= resultList1.get(i+1);
						resultList1.add(i, temp2);
						resultList1.add(i+1, temp1);
					}
					
				}
	
		}		
		return resultList1;
		
	}

// Function to apply Bubble sort for sorting elements for Set and casting it to List	
	public List<CategoryCommand> SortListCategoryCommand(List<CategoryCommand> catList2bsorted) {
		List<CategoryCommand> resultList1 = catList2bsorted;
		CategoryCommand temp1 = new CategoryCommand() ;
		CategoryCommand temp2 = new CategoryCommand() ;
			for(int i=0;i<catList2bsorted.size()-1;i++) {
				
				for(int m=0;m<catList2bsorted.size()-i;m++) {
					if (resultList1.get(i).getId() > resultList1.get(i+1).getId()) {
						temp1= resultList1.get(i);
						temp2= resultList1.get(i+1);
						resultList1.add(i, temp2);
						resultList1.add(i+1, temp1);
					}
					
				}
	
		}		
		return resultList1;
		
	}
	

}
