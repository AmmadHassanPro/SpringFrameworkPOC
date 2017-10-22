package Recipe.JpaHibernateDemo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Recipe.JpaHibernateDemo.Entities.Category;

public interface CategoryRepository extends CrudRepository<Category,Long>{

	Optional<Category> findByDescription(String description);
	
}
