package com.friday.codechallenge;

import java.util.ArrayList;

import org.json.JSONObject;
/**
 * Class for defining the logic for split of an address string.
 * 
 * @author Sonia
 *
 */	
public class AddressSplitter<jsonObject> {

	/**
	 * Method: To define the logic for split of an address string.
	 * 
	 */
	public JSONObject split(String str) {
		JSONObject jsonObject = new JSONObject();
		for (int strchar = 0; strchar < str.length() - 1; strchar++) {
			if (str.charAt(strchar) == ',') {
				if (str.charAt(strchar- 1) >= '0' && str.charAt(strchar - 1) <= '9') {
					jsonObject.put("housenumber", str.substring(0, strchar));
					jsonObject.put("street", str.substring(strchar + 2));

					return jsonObject;
				} else if (str.charAt(strchar - 1) >= 'a' && str.charAt(strchar - 1) <= 'z') {
					jsonObject.put("housenumber", str.substring(strchar + 2));
					jsonObject.put("street", str.substring(0, strchar));

					return jsonObject;
				} else
					continue;
			} else if (str.charAt(strchar) == ' ') {
				if (str.charAt(strchar - 1) >= '0' && str.charAt(strchar - 1) <= '9') {
					jsonObject.put("housenumber", str.substring(0, strchar));
					jsonObject.put("street", str.substring(strchar + 1));

					return jsonObject;

				} else if (str.charAt(strchar + 1) >= '0' && str.charAt(strchar + 1) <= '9') {
					String s1 = str.substring(strchar + 1);
					String s2 = str.substring(0, strchar);
					int count2 = s1.length();
					if (count2 <= 4) {
						jsonObject.put("housenumber", s1);
						jsonObject.put("street", s2);

						return jsonObject;
					} else {
						for (int strpart = 0; strpart < s1.length(); strpart++) {
							if (s1.charAt(strpart + 3) == 'N' && s1.charAt(strpart + 4) == 'o') {
								String s3 = s1.substring(0, strpart + 2);
								String s4 = s2 + " " + s3;
								jsonObject.put("housenumber", s1.substring(strpart + 3));
								jsonObject.put("street", s4);

								return jsonObject;

							}

						}
					}

				} else
					continue;
			} else
				continue;

		}
		return null;


	}

}
