package Recipe.JpaHibernateDemo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long>{

// We can create the methods like 'find' By 'attribute, or field name' and in the parameter, the argument must match the field name in the table exactly

	Optional<UnitOfMeasure> findByDescription(String description);
}
