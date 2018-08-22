package Recipe.JpaHibernateDemo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
import Recipe.JpaHibernateDemo.Repository.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureService {
	
@Autowired
private UnitOfMeasureRepository uom_repo;
@Autowired
private List<UnitOfMeasure> uom_list;

public UnitOfMeasure findByDescription(String description){

	Optional<UnitOfMeasure> uom_optional = uom_repo.findByDescription(description);
	
	UnitOfMeasure uom = uom_optional.get();
	
	return uom;
	
	
}

public void save(UnitOfMeasure uom) {
	
	
	uom_repo.save(uom);
	
}

public List<UnitOfMeasure> findAll() {
	
	List<UnitOfMeasure> uomList = new ArrayList<UnitOfMeasure>();
	Iterable<UnitOfMeasure> i =  uom_repo.findAll();
	Iterator m = i.iterator();
	while(m.hasNext()) {
		uomList.add((UnitOfMeasure) m.next());
	}
	return uomList;
}


	

}
