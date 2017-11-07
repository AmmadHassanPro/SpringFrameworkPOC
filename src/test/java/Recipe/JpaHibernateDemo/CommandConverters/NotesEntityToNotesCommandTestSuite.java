package Recipe.JpaHibernateDemo.CommandConverters;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Entities.Notes;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NotesEntityToNotesCommandTestSuite {

	@Autowired
	private NotesEntityToNotesCommand netnc;
	@Autowired
	private Notes notesEntity;
	private NotesCommand notesCommand;
	
	@Test
	public void test() {
		notesEntity.setId(1L);
		notesEntity.setRecipeNotes("Test Description");
		notesCommand = netnc.convert(notesEntity);
		assertEquals(notesEntity.getId(),notesCommand.getId());
		assertEquals(notesEntity.getRecipeNotes(),notesCommand.getRecipeNotes());
		
	}
	
	@Test
	public void nullCheck() {
		notesEntity = null;
		notesCommand = netnc.convert(notesEntity);
		Assert.assertNull(notesCommand);
		
		
	}
	
	

}
