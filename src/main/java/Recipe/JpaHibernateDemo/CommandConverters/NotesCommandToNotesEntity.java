package Recipe.JpaHibernateDemo.CommandConverters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import Recipe.JpaHibernateDemo.Commands.NotesCommand;
import Recipe.JpaHibernateDemo.Commands.UnitOfMeasureCommand;
import Recipe.JpaHibernateDemo.Entities.Notes;
import Recipe.JpaHibernateDemo.Entities.UnitOfMeasure;
@Component
public class NotesCommandToNotesEntity implements Converter<Notes,NotesCommand>{

	@Override
	public NotesCommand convert(Notes NotesEnity) {
		if(NotesEnity == null)
		{
		return null;
		}
		
		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(NotesEnity.getId());
		notesCommand.setRecipeNotes(notesCommand.getRecipeNotes());
		return notesCommand; 
	}

}
