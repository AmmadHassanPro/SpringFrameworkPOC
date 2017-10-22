package Recipe.JpaHibernateDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import Recipe.JpaHibernateDemo.Entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{

}
