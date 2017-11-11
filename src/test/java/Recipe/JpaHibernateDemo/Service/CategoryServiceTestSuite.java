package Recipe.JpaHibernateDemo.Service;



import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Repository.CategoryRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional // To roll back what we save in this suite
public class CategoryServiceTestSuite {
	@Autowired
	private CategoryService catService;
	@Autowired
	private CategoryRepository cat_repo;
	@Autowired
	private List<Category> cat_list1;
	@Autowired
	private List<Category> cat_list2;
	@Autowired 
	private Category catEntity;
	
	@Test
	public void testFindAll() {
		cat_list1 = (List<Category>) cat_repo.findAll();
		cat_list2 = catService.findAll();
		assertEquals(cat_list1,cat_list2);
		
	}
	
	
	@Test
	public void testFindByDescription() {
		
		Optional<Category> cat_optional = cat_repo.findByDescription("Italian");
		catEntity = catService.findByDescription("Italian");
		
		assertEquals(cat_optional.get().getDescription(),catEntity.getDescription());
		
	}
	
	@Test
	public void testSave() {
		catEntity = new Category();
		catEntity.setDescription("Test Desc");
		catService.save(catEntity);
		
		Category tempCatEntity = cat_repo.findByDescription("Test Desc").get();
		
		assertEquals(catEntity.getDescription(),tempCatEntity.getDescription() );
		
	}
	
	
	@Test
	
	public void nullChecks() {
		Category cat = catService.findByDescription(null);
		Assert.assertNull(cat);
		
		
		
	}
	

}
