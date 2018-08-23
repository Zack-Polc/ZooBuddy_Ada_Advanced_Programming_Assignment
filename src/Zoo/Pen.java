/*
    ● Hardip : Responsible for Dry Pens and Aviaries
    ● Alex : Responsible for Aquariums and Part water, part dry pens
    ● Farhad : Responsible for Aviaries and Aquariums
    ● Alan : Responsible for Dry Pens and Petting Pens
 */

package Zoo;

public class Pen {
    double volume;
    double temperature;
    String type;

    public Pen(String type, double temperature, double volume)
    {
        this.type = type;
        this.temperature = temperature;
        this.volume = volume;
    }


    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
