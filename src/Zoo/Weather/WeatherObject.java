package Zoo.Weather;

import java.util.List;

public class WeatherObject {
        //private Coord coord;
        private List<Weather> weather;
        private String base;
        public WeatherMain main;
        private int visibility;
        private Wind wind;
        private Clouds clouds;
        private int dt;
        private Sys sys;
        private int id;
        private String name;
        private int cod;

        public void returnWeather(){
            System.out.println(id);
            System.out.println(weather.get(0).main);
        }

        public double getLatestWeather() {
            return main.temp;
    }


    class Weather {
        public int id;
        public String main;
        private String description;
        private String icon;
    }

    class WeatherMain {
        public double temp;
        private double pressure;
        private double humidity;
        private double temp_min;
        private double temp_max;
    }

    class Wind {
        private double speed;
        private double gust;
    }

    class Clouds {
        private int all;
    }

    class Sys {
        private int type;
        private int id;
        private double message;
        private String country;
        private int sunrise;
        private int sunset;
    }
}
