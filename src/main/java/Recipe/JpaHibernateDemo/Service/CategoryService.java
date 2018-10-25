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
private CategoryRepository catRepo;
@Autowired
private List<Category> catList;

public List<Category> findAll(){
	
	
	catList = (List<Category>) catRepo.findAll();
	return catList;
	
	
}

public Category findByDescription(String description){
	if(description==null || description=="") {
		
		return null;
	}
	Optional<Category> catOptional = catRepo.findByDescription(description);
	if(catOptional.isPresent()) {
	return catOptional.get();
	
	}
	
	return null;
	
	
}
public void save(Category cat) {
	if(cat == null) {
		
		return;
	}
	
	catRepo.save(cat);
	
}


	

}
