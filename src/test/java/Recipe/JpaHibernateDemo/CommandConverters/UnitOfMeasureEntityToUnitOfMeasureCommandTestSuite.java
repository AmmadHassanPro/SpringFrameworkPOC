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
public class UnitOfMeasureEntityToUnitOfMeasureCommandTestSuite {
	@Autowired
	private UnitOfMeasureEntityToUnitOfMeasureCommand uometuomc;
	@Autowired
	private UnitOfMeasure uomEntity; 
	private UnitOfMeasureCommand uomCommand;
	@Before
	public void setUp() {
		uomEntity.setId(1L);
		uomEntity.setDescription("Test Description");
	}
	
	@Test
	public void testConvert() {
		uomCommand = uometuomc.convert(uomEntity);
		
		assertEquals(uomCommand.getId(),uomEntity.getId());
		assertEquals(uomCommand.getDescription(),uomEntity.getDescription());
		
	}
	
	@Test
	public void nullCheck() {
		uomEntity = null;
		uomCommand = uometuomc.convert(uomEntity);
		Assert.assertNull(uomCommand);
		
		
	}
	

}
