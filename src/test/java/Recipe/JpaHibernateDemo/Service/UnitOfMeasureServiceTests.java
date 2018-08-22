package Recipe.JpaHibernateDemo.Service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UnitOfMeasureServiceTests {


	@Autowired
	private UnitOfMeasureService uomService;
	
	@Test
	public void testfindAll() {
		List<UnitOfMeasure> uom_list = uomService.findAll();
		assertNotNull(uom_list); // as there are items in the database already, so it should not be null
	}

}
