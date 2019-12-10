
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
				if (str.charAt(strchar - 1) >= '0' && str.charAt(strchar - 1) <= '9') {

					jsonObject.put("street", str.substring(strchar + 2));
					jsonObject.put("housenumber", str.substring(0, strchar));

					return jsonObject;
				} else if (str.charAt(strchar - 1) >= 'a' && str.charAt(strchar - 1) <= 'z') {

					jsonObject.put("street", str.substring(0, strchar));
					jsonObject.put("housenumber", str.substring(strchar + 2));

					return jsonObject;
				} else
					continue;
			} else if (str.charAt(strchar) == ' ') {
				if (str.charAt(strchar - 1) >= '0' && str.charAt(strchar - 1) <= '9') {

					jsonObject.put("street", str.substring(strchar + 1));
					jsonObject.put("housenumber", str.substring(0, strchar));

					return jsonObject;

				} else if (str.charAt(strchar + 1) >= '0' && str.charAt(strchar + 1) <= '9') {
					String str1 = str.substring(strchar + 1);
					String str2 = str.substring(0, strchar);
					int strcount = str1.length();
					if (strcount <= 4) {

						jsonObject.put("street", str2);
						jsonObject.put("housenumber", str1);

						return jsonObject;
					} else {
						for (int strpart = 0; strpart < str1.length(); strpart++) {
							if (str1.charAt(strpart + 3) == 'N' && str1.charAt(strpart + 4) == 'o') {
								String str3 = str1.substring(0, strpart + 2);
								String str4 = str2 + " " + str3;

								jsonObject.put("street", str4);
								jsonObject.put("housenumber", str1.substring(strpart + 3));

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
