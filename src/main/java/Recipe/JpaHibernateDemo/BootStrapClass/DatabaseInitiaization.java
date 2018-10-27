package Recipe.JpaHibernateDemo.BootStrapClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Entities.Category;
import Recipe.JpaHibernateDemo.Service.CategoryService;

//The class will initialize Categories table for the app

@Component
public class DatabaseInitiaization implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CategoryService catService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
	this.initData();
		
	}

		private void initData() {
			
			
			Category cat = new Category();
			cat.setDescription("Seafood");
			catService.save(cat);
			
			cat = new Category();
			cat.setDescription("Desert");
			catService.save(cat);
			
			cat = new Category();
			cat.setDescription("Vegan");
			catService.save(cat);
			
			cat = new Category();
			cat.setDescription("Salad");
			catService.save(cat);
			
			cat = new Category();
			cat.setDescription("Sweet");
			catService.save(cat);
			
			cat = new Category();
			cat.setDescription("Sandwhich");
			catService.save(cat);
			
			cat = new Category();
			cat.setDescription("Low Fat");
			catService.save(cat);
						
		}
		
}
