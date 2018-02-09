package i18nResources;

import java.util.ListResourceBundle;



public class ListBundle_en_US extends ListResourceBundle {
	static final Object[][] contents = {
			{"hello","hello"},{"bye","bye"},{"enter","enter"},{"helloWorld","ListBundle_en_US Class: Hello World!"}
	};

	@Override
	public Object[][] getContents() {		
		return contents;
	}

}
