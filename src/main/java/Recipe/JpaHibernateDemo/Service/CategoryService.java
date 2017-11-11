package Recipe.JpaHibernateDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Repository.CategoryRepository;

@Service
public class CategoryService {
	
@Autowired
private CategoryRepository cat_repo;
@Autowired
private List<Category> cat_list;

public List<Category> findAll(){
	
	
	cat_list = (List<Category>) cat_repo.findAll();
	return cat_list;
	
	
}

public Category findByDescription(String description){
	if(description==null || description=="") {
		
		return null;
	}
	Optional<Category> cat_optional = cat_repo.findByDescription(description);
	Category cat = cat_optional.get();
	return cat;
	
	
	
}
public void save(Category cat) {
	if(cat == null) {
		
		return;
	}
	
	cat_repo.save(cat);
	
}


	

}
