package ResourceBundleEx;

//Supported Locales
//http://www.oracle.com/technetwork/java/javase/java8locales-2095355.html
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class LocaleDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// --System properties
		if (false) {
			System.out.println("System Properties");
			System.out.println("------------------");
			Properties sysProperties = System.getProperties();
			Set<Object> s = sysProperties.keySet();
			for (Object p : s) {
				String key = (String) p;
				System.out.println("key: " + key + "  " + System.getProperty(key));
			}
		}

		//---All locales availables
		if (false) {
			Locale[] locales = Locale.getAvailableLocales();

			// loop over all the locale installed in the jvm
			for (Locale l : locales) {
				System.out.println(l.getLanguage() + "_" + l.getCountry() + " [ " + l.getDisplayLanguage() + ", "
						+ l.getDisplayCountry() + " ]");
			}
		}

		System.out.println("Getting the current working directory");
		System.out.println(LocaleDemo.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		// Demo PropertiesBundle

		
		System.out.println("\nGetting Locale Default");
		Locale locale = Locale.getDefault();	
		ResourceBundle drb = ResourceBundle.getBundle("i18nResources/dictionary", locale);
		System.out.println(drb.getString("helloWorld"));
		ResourceBundle.clearCache();
		

		System.out.println("\nCreating Locale.JAPANESE");
		Locale japanLocale = new Locale ("jp");
		ResourceBundle jrb = ResourceBundle.getBundle("i18nResources/dictionary", japanLocale);
		System.out.println(jrb.getString("helloWorld"));
		ResourceBundle.clearCache();
		
		System.out.println("\nCreating Locale for SPANISH");
		Locale spanishLocale = new Locale ("es");		
		ResourceBundle sprb = ResourceBundle.getBundle("i18nResources.ListBundle", spanishLocale);
		System.out.println(sprb.getString("helloWorld"));
		ResourceBundle.clearCache();
		
	}
}
