package org.usc.demo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Shunli
 */
public class CityAnalysis {
	public static void main(String[] args) throws Exception {
		File file = new File(CityAnalysis.class.getResource("/city.js").toURI());
		String content = FileUtils.readFileToString(file);
		// System.out.println(content);

		int count = 1;
		JSONArray jsonArray = new JSONObject(content).getJSONArray("cityList");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject city = (JSONObject) jsonArray.get(i);
			System.out.println((count++) + "        " + city.getString("code") + "        " + city.getString("name"));

			JSONArray childCitys = city.getJSONArray("childCity");

			for (int j = 0; j < childCitys.length(); j++) {
				JSONObject childCity = (JSONObject) childCitys.get(j);
				System.out.println((count++) + "        " + childCity.getString("code") + "        " + childCity.getString("name"));
			}
		}

		// System.out.println(jsonArray);
		// new JSONObject(content).getJSONObject("code");//getJSONObject("data").getLong("id");
	}
}
