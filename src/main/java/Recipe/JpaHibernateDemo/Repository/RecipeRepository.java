package Recipe.JpaHibernateDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Recipe.JpaHibernateDemo.Entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{
	@Query(value="SELECT * FROM RECIPE WHERE ID= (SELECT RECIPE_ID FROM RECIPE_CATEGORY WHERE CATEGORY_ID= (SELECT ID FROM CATEGORY  WHERE DESCRIPTION = :category)) " , nativeQuery=true)
	List<Recipe> findbyCategory(@Param("category") String Category);

}
