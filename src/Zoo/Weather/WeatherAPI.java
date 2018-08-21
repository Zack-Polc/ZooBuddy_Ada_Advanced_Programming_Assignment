package Zoo.Weather;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI {

    public static WeatherAPI getWeather() throws IOException {
        String input;
        StringBuffer JSONResponse = new StringBuffer();

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=London,uk&units=metric&appid=c145b8ba4e27de696d6759ababd535c8");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while ((input = reader.readLine()) != null) {
            JSONResponse.append(input);
        }
        reader.close();

        // Creating New GSON
        Gson GSON = new Gson();
        String JSON = String.valueOf(JSONResponse);
        WeatherAPI weather = GSON.fromJson(JSON, WeatherAPI.class);
        return weather;
    }
}
