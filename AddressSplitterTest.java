package com.friday.codechallenge;

import java.util.ArrayList;

//import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Class to check the split of address string into the Street and House Number.
 * 
 * @author Sonia
 *
 */	
public class AddressSplitterTest {
	
	/**
	 * Method: To check the split of address for complex address strings.
	 * 
	 */
	@Test
	public void splitTestComplicated() {

		ArrayList<String> addressList = new ArrayList<String>();
		addressList.add("4, rue de la revolution");
		addressList.add("200 Broadway Av");
		addressList.add("Calle Aduana, 29");
		addressList.add("Calle 39 No 1540");
		JSONObject jsonobj = new JSONObject();
		JSONObject jsonobj1 = new JSONObject();
		JSONObject jsonobj2 = new JSONObject();
		JSONObject jsonobj3 = new JSONObject();
		jsonobj.put("street", "rue de la revolution");
		jsonobj.put("housenumber", "4");
		jsonobj1.put("street", "Broadway Av");
		jsonobj1.put("housenumber", "200");
		jsonobj2.put("street", "Calle Aduana");
		jsonobj2.put("housenumber", "29");
		jsonobj3.put("street", "Calle 39");
		jsonobj3.put("housenumber", "No 1540");
		ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
		jsonList.add(jsonobj);
		jsonList.add(jsonobj1);
		jsonList.add(jsonobj2);
		jsonList.add(jsonobj3);
		for (int count = 0; count < addressList.size(); count++) {
			AddressSplitter splitter = new AddressSplitter();
			String strlist = addressList.get(count);
			System.out.println(strlist);
			System.out.println(splitter.split(strlist));
			System.out.println(jsonList.get(count));
			Assert.assertEquals(jsonList.get(count).toString(), splitter.split(strlist).toString());
		}
	}

	/**
	 * Method: To check the split of address for simple address strings.
	 * 
	 */
	@Test
	public void splitTestSimple() {

		ArrayList<String> addressList = new ArrayList<String>();
		addressList.add("Winterallee 3");
		addressList.add("Musterstrasse 45");
		addressList.add("Blaufeldweg 123B");
		addressList.add("Am Bächle 23");
		addressList.add("Auf der Vogelwiese 23 b");
		JSONObject jsonobj = new JSONObject();
		JSONObject jsonobj1 = new JSONObject();
		JSONObject jsonobj2 = new JSONObject();
		JSONObject jsonobj3 = new JSONObject();
		JSONObject jsonobj4 = new JSONObject();
		jsonobj.put("street", "Winterallee");
		jsonobj.put("housenumber", "3");
		jsonobj1.put("street", "Musterstrasse");
		jsonobj1.put("housenumber", "45");
		jsonobj2.put("street", "Blaufeldweg");
		jsonobj2.put("housenumber", "123B");
		jsonobj3.put("street", "Am Bächle");
		jsonobj3.put("housenumber", "23");
		jsonobj4.put("street", "Auf der Vogelwiese");
		jsonobj4.put("housenumber", "23 b");
		ArrayList<JSONObject> jsonList = new ArrayList<JSONObject>();
		jsonList.add(jsonobj);
		jsonList.add(jsonobj1);
		jsonList.add(jsonobj2);
		jsonList.add(jsonobj3);
		jsonList.add(jsonobj4);
		for (int count = 0; count < addressList.size(); count++) {
			AddressSplitter splitter = new AddressSplitter();
			String strlist = addressList.get(count);
			System.out.println(strlist);
			System.out.println(splitter.split(strlist));
			System.out.println(jsonList.get(count));
			Assert.assertEquals(jsonList.get(count).toString(), splitter.split(strlist).toString());
		}

	}
}
