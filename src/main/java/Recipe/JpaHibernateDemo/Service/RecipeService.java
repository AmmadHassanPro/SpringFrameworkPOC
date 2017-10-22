package Recipe.JpaHibernateDemo.Service;

import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;

@Service
public class RecipeService {

@Autowired	
private RecipeRepository recipe_repo;
@Autowired
private List<Recipe> recipeVar;

public List<Recipe> findAll() {
	byte[] img;
	recipeVar = (List<Recipe>) recipe_repo.findAll();
	return recipeVar;
		
}

public void save(Recipe recipe) {
	
	recipe_repo.save(recipe);
	
}



	
}
