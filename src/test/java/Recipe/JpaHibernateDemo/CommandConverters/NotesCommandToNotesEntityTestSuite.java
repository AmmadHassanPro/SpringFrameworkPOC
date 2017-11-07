package Recipe.JpaHibernateDemo.CommandConverters;



import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Entities.Notes;


@SpringBootTest
@RunWith(SpringRunner.class)
public class NotesCommandToNotesEntityTestSuite {

	@Autowired
	private NotesCommandToNotesEntity nctne;
	
	@Autowired
	private Notes notesEntity;
	private NotesCommand notesCommand;
	
	@Before
	public void before() {
		
		
		
	}
	
	
	@Test
	public void testConvert() {
	notesCommand= new NotesCommand();
	notesCommand.setId(1L);
	notesCommand.setRecipeNotes("Test Notes");
	notesEntity = nctne.convert(notesCommand);
	
	assertEquals(notesEntity.getId(),notesCommand.getId());
	assertEquals(notesEntity.getRecipeNotes(),notesCommand.getRecipeNotes());
		
		
	}
	
	
	@Test
	public void nullCheck() {
		notesCommand= null;
		notesEntity = nctne.convert(notesCommand);
		Assert.assertNull(notesEntity);
		
		
	}

}
