package Recipe.JpaHibernateDemo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Recipe.JpaHibernateDemo.Entities.Recipe;
import Recipe.JpaHibernateDemo.Repository.RecipeRepository;

//This class is responsible for acting as a Service Layer , which connects with the database to get the Recipe Records

@Service
public class RecipeService{

@Autowired	
private RecipeRepository recipeRepo;
@Autowired
private List<Recipe> recipeList=new ArrayList<>(); 
public List<Recipe> findAll() {
	
	this.recipeList = (List<Recipe>) recipeRepo.findAll();
	return this.recipeList;
		
}

public void save(Recipe recipe) {
	
	this.recipeRepo.save(recipe);
	
}

public Recipe findById(String string) {
	Long id = Long.valueOf(string);
	Optional<Recipe> optRecipe = recipeRepo.findById(id);
	if(optRecipe.isPresent()) {
	return optRecipe.get();
	}
	return null;
	
}

public List<Recipe> findByCategory(String category){
	
	this.recipeList = recipeRepo.findbyCategory(category);
	return this.recipeList;
}

public List<Recipe> findByNameOrDesc(String searchTerm){
	this.recipeList = recipeRepo.findByNameOrDesc(searchTerm);
	return this.recipeList;
	
}






	
}
