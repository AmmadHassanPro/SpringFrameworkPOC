package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Entities.Notes;
@Component
public class NotesEntityToNotesCommand implements Converter<Notes,NotesCommand>{

	@Override
	public NotesCommand convert(Notes notesEntity) {
		if(notesEntity == null) {
			
		return null;
		}
		
		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(notesEntity.getId());
		notesCommand.setRecipeNotes(notesEntity.getRecipeNotes());
		return notesCommand;
	}

}
