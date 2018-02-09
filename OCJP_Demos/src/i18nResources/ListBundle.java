package i18nResources;

import java.util.ListResourceBundle;



public class ListBundle extends ListResourceBundle {
	static final Object[][] contents = {
			{"hello","hello"},{"bye","bye"},{"enter","enter"},{"helloWorld","ListBundle Class: Hello World!"}
	};

	@Override
	public Object[][] getContents() {		
		return contents;
	}

}
