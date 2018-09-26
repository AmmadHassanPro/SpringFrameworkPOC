package Recipe.JpaHibernateDemo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import Recipe.JpaHibernateDemo.Entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Long>{
	@Query(value="SELECT * FROM RECIPE WHERE ID IN (SELECT RECIPE_ID FROM RECIPE_CATEGORY WHERE CATEGORY_ID= (SELECT ID FROM CATEGORY  WHERE DESCRIPTION = :category)) " , nativeQuery=true)
	public List<Recipe> findbyCategory(@Param("category") String Category);
	@Query(value="SELECT * FROM RECIPE WHERE LOWER(NAME) LIKE LOWER(CONCAT('%',:searchTerm,'%')) OR LOWER(DESCRIPTION) LIKE LOWER(CONCAT('%',:searchTerm,'%')) " , nativeQuery=true)
	public List<Recipe> findByNameOrDesc( @Param ("searchTerm")String searchTerm);

}
