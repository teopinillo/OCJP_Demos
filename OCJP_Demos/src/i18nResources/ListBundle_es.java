package i18nResources;

import java.util.ListResourceBundle;



public class ListBundle_es extends ListResourceBundle {
	static final Object[][] contents = {
			{"hello","hola"},{"bye","adios"},{"enter","enter"},{"helloWorld","ListBundle_es Class: Hola Mundo!"}
	};

	@Override
	public Object[][] getContents() {		
		return contents;
	}

}
