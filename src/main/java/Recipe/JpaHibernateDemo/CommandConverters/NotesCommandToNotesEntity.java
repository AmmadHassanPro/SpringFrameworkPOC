package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Entities.Notes;
@Component
public class NotesCommandToNotesEntity implements Converter<NotesCommand,Notes>{
	@Autowired
	private Notes notesEntity;
	
	@Override
	public Notes convert(NotesCommand notesCommand) {
		if(notesCommand == null) {
		return null;
		}
		
		notesEntity.setId(notesCommand.getId());
		notesEntity.setRecipeNotes(notesCommand.getRecipeNotes());
		return notesEntity;
		
	}

}
