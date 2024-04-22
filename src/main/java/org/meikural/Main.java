package org.meikural;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        port(8080); // Set the port number
        post("/add", (request, response) -> {
            String jsonBody = request.body();
            JsonObject jsonObject = JsonParser.parseString(jsonBody).getAsJsonObject();
            int a = jsonObject.get("a").getAsInt();
            int b = jsonObject.get("b").getAsInt();
            int result = add(a, b);
            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("result", result);
            response.type("application/json");
            return jsonResponse.toString();
        });
    }

    public static int add(int a, int b) {
        return a + b;
    }
}