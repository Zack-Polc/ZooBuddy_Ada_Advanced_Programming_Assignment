/*
    ● Hardip : Responsible for Dry Pens and Aviaries
    ● Alex : Responsible for Aquariums and Part water, part dry pens
    ● Farhad : Responsible for Aviaries and Aquariums
    ● Alan : Responsible for Dry Pens and Petting Pens
 */

package Zoo;

public class Pen {
    double numberOfAnimalsCanFit;
    double volume;
    double temperature;
    String type;

    public Pen(String type,double numberOfAnimalsCanFit, double temperature, double volume)
    {
        this.type = type;
        this.temperature = temperature;
        this.volume = volume;
        this.numberOfAnimalsCanFit = numberOfAnimalsCanFit;
    }


    public double getNumberOfAnimalsCanFit() {
        return numberOfAnimalsCanFit;
    }

    public double getTemperature() {
        return temperature;
    }


    public String getType() {
        return type;
    }
}
