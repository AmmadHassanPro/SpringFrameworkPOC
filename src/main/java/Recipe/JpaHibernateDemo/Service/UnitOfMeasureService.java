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
private UnitOfMeasureRepository uomRepo;

public UnitOfMeasure findByDescription(String description){

	Optional<UnitOfMeasure> uomList = uomRepo.findByDescription(description);
	if(uomList.isPresent()) {
	return uomList.get();
	}
	
	return null;
	
}

public void save(UnitOfMeasure uom) {
	
	uomRepo.save(uom);
	
}

public List<UnitOfMeasure> findAll() {
	
	List<UnitOfMeasure> uomList = new ArrayList<>();
	Iterable<UnitOfMeasure> i =  uomRepo.findAll();
	Iterator m = i.iterator();
	while(m.hasNext()) {
		uomList.add((UnitOfMeasure) m.next());
	}
	return uomList;
}


	

}
