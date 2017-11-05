package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.IngredientCommand;
import Recipe.JpaHibernateDemo.Entities.Ingredient;
@SpringBootTest
@RunWith(SpringRunner.class)
public class IngredientEntityToIngredientCommandTestSuite {

	private IngredientCommand ingCommand; 
	@Autowired
	private Ingredient ingEntity;
	@Autowired
	private IngredientEntityToIngredientCommand ietiec;
	
	@Test
	public void testConvert() {
		this.ingEntity.setId(1L);
		this.ingEntity.setDescription("Demo Description");
		ingCommand = ietiec.convert(ingEntity);
		
		assertEquals(ingEntity.getId(),ingCommand.getId());
		assertEquals(ingEntity.getDescription(),ingCommand.getDescription());
		
	
	}
	
	@Test
	public void nullCheck() {
		
		this.ingEntity = null;
		ingCommand = ietiec.convert(ingEntity);
		 Assert.assertNull(ingEntity);
		
		
	}
	
	

}
