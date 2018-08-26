package Recipe.JpaHibernateDemo.BootStrapClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
import Recipe.JpaHibernateDemo.Service.CategoryService;
import Recipe.JpaHibernateDemo.Service.UnitOfMeasureService;

/*The class will initialize Unit of Measure and Categories for Junit test Cases

 */
@Component
public class DatabaseInitiaization implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CategoryService cat_service;
	
	@Autowired
	private UnitOfMeasureService uom_service;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
	this.initData();
		
	}

		private void initData() {
			/*
			Category cat = new Category();
			cat.setDescription("American");
			cat_service.save(cat);
			
			
			cat.setDescription("Italian");
			cat_service.save(cat);
			
			cat.setDescription("Mexican");
			cat_service.save(cat);
			
			cat.setDescription("Fast Food");
			cat_service.save(cat);
			*/
			
			/*
			UnitOfMeasure uom = new UnitOfMeasure();
			uom.setDescription("Teaspoon");
			uom_service.save(uom);
			
			uom.setDescription("Tablespoon");
			uom_service.save(uom);
			
			uom.setDescription("Cup");
			uom_service.save(uom);
			
			uom.setDescription("Pinch");
			uom_service.save(uom);
			
			uom.setDescription("Clove");
			uom_service.save(uom);
			
			uom.setDescription("Small");
			uom_service.save(uom);
			
			uom.setDescription("Medium");
			uom_service.save(uom);
			
			uom.setDescription("Pint");
			uom_service.save(uom);
			
			uom.setDescription("Dash");
			uom_service.save(uom);
			*/
			
		}



	
		
}
