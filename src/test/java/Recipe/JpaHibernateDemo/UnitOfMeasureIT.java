package Recipe.JpaHibernateDemo;



import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
import Recipe.JpaHibernateDemo.Repository.UnitOfMeasureRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class UnitOfMeasureIT {//Integrations test

	@Autowired
	UnitOfMeasureRepository uom_repo;
	@Test
	public void findByDescriptionTeaspoon() throws Exception {
		
		Optional<UnitOfMeasure> uom_opt = uom_repo.findByDescription("Teaspoon");// Test if Teaspoon is present in the database
		
		assertEquals("Teaspoon",uom_opt.get().getDescription());
	}
	
	
	@Test
	public void findByDescriptionPinch() throws Exception {
		
		Optional<UnitOfMeasure> uom_opt = uom_repo.findByDescription("Pinch");// Test if Pinch is present in the database
		
		assertEquals("Pinch",uom_opt.get().getDescription());
	}
	
	@Test
	public void findByDescriptionCup() throws Exception {
		
		Optional<UnitOfMeasure> uom_opt = uom_repo.findByDescription("Cup");// Test if Cup is present in the database
		
		assertEquals("Cup",uom_opt.get().getDescription());
	}

}
