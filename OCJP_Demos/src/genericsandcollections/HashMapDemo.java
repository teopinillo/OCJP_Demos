package genericsandcollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String,String> props = new HashMap<String, String>();
		props.put("key45", "some value");
		props.put("key12", "some value");
		props.put("key39", "some value");
		
		
		Set<String> s = props.keySet();				
		s = new TreeSet<String>(s);
		

	}

}
