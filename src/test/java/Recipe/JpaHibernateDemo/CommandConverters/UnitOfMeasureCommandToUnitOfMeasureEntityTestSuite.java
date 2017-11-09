package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.UnitOfMeasureCommand;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UnitOfMeasureCommandToUnitOfMeasureEntityTestSuite {
	@Autowired
	private UnitOfMeasureCommandToUnitOfMeasureEntity uomctuome;
	@Autowired
	private UnitOfMeasure uomEntity;
	private UnitOfMeasureCommand uomCommand;
	
	
	
	
	@Before
	public void setUp() {
		uomCommand = new UnitOfMeasureCommand();
		uomCommand.setId(1L);
		uomCommand.setDescription("Test Description");
	}
	
	@Test
	public void testConvert() {
		uomEntity = uomctuome.convert(uomCommand);
		
		assertEquals(uomEntity.getId(),uomCommand.getId());
		assertEquals(uomEntity.getDescription(),uomCommand.getDescription());
		
	}
	
	@Test
	public void nullCheck() {
		
		uomCommand = null;
		uomEntity = uomctuome.convert(uomCommand);
		Assert.assertNull(uomEntity);
		
		
	}
	

}
