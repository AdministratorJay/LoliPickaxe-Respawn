package net.mcreator.lolipickaxe;

import com.google.gson.JsonObject;

public class CaiZi2 {
    public static String rainbow(String input) {
		JsonObject json = new JsonObject();
		json.addProperty("text", input);
		JsonObject style = new JsonObject();
		style.addProperty("color", "#ff0000");
		json.add("style", style);
		String result = json.toString();
		return result;
    }
}