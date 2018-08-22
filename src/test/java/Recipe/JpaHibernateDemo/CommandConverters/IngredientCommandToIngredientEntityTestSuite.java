package Recipe.JpaHibernateDemo.CommandConverters;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
@SpringBootTest
@RunWith(SpringRunner.class)
public class IngredientCommandToIngredientEntityTestSuite {
	
	private IngredientCommand ingCommand;
	private List<IngredientCommand> ingCommandSet;
	@Autowired
	private IngredientCommandToIngredientEntity ictie;
	@Autowired 
	private Ingredient ingredientEntity;
	private List<Ingredient> ingEntitySet;
	
	
	@Before
	public void setUp() {
		
		this.ingCommandSet = new ArrayList<IngredientCommand>();
		this.ingCommand = new IngredientCommand();
		this.ingEntitySet = new ArrayList<Ingredient>();
		
		
	}
	
	
	@Test
	public void testConvertList() {
		IngredientCommand temp1 = new IngredientCommand();
		temp1.setId(1L);
		temp1.setDescription("Test Description 2");
		IngredientCommand temp2 = new IngredientCommand();
		temp2.setId(2L);
		temp2.setDescription("Test Description 3");
		ingCommandSet.add(temp1);
		ingCommandSet.add(temp2);	
		ingEntitySet = ictie.convertToIngredientSet(ingCommandSet);
		
		List<Ingredient> ingEnityList = new ArrayList<Ingredient>(ingEntitySet);
		ingEnityList = this.SortIngredientList(ingEnityList);
		
		List<IngredientCommand> ingCommList = new ArrayList<IngredientCommand>(ingCommandSet);
		ingCommList = this.SortIngredientCommandList(ingCommList);
		
		for(int i=0; i<ingEnityList.size();i++) {
			assertEquals(ingEnityList.get(i).getId(),ingCommList.get(i).getId());
			assertEquals(ingEnityList.get(i).getDescription(),ingCommList.get(i).getDescription());
			
			
		}
	
	}
	
	
	public List<Ingredient> SortIngredientList(List<Ingredient> list2bSorted){
		Ingredient temp1 = new Ingredient();
		Ingredient temp2 = new Ingredient();		
		for(int i=0;i<list2bSorted.size()-1;i++) {
			for(int m=list2bSorted.size()-1;m<list2bSorted.size()-i;m--) {
				if(list2bSorted.get(i).getId() < list2bSorted.get(i+1).getId()) {
					temp1 = list2bSorted.get(i);
					temp2 = list2bSorted.get(i+1);
					list2bSorted.remove(i);
					list2bSorted.add(i, temp2);
					list2bSorted.remove(i+1);
					list2bSorted.add(i+1, temp1);
				}
			}	
		}		
		return list2bSorted;
	}
	
	
	public List<IngredientCommand> SortIngredientCommandList (List<IngredientCommand> list2bSorted){
		IngredientCommand temp1 = new IngredientCommand();
		IngredientCommand temp2 = new IngredientCommand();		
		for(int i=0;i<list2bSorted.size()-1;i++) {
			for(int m=list2bSorted.size()-1;m<list2bSorted.size()-i;m--) {
				if(list2bSorted.get(i).getId() < list2bSorted.get(i+1).getId()) {
					temp1 = list2bSorted.get(i);
					temp2 = list2bSorted.get(i+1);
					list2bSorted.remove(i);
					list2bSorted.add(i, temp2);
					list2bSorted.remove(i+1);
					list2bSorted.add(i+1, temp1);
				}
			}	
		}		
		return list2bSorted;
		
		
	}
	

	@Test
	public void testConvert() {
		ingCommand.setId(1L);
		ingCommand.setDescription("Test Description");
		ingredientEntity = ictie.convert(ingCommand);
		assertEquals(ingCommand.getId(),ingredientEntity.getId());
		assertEquals(ingCommand.getDescription(),ingredientEntity.getDescription());
	}
	
	
	@Test 
	public void nullCheck() {
		
		ingCommand = null;
		ingredientEntity = ictie.convert(ingCommand);
		Assert.assertNull(ingredientEntity);
		
		ingCommandSet = null;
		ingEntitySet = ictie.convertToIngredientSet(ingCommandSet);
		Assert.assertNull(ingEntitySet);
		
		
	}
	
	
	

}
