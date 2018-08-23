package Zoo;

public abstract class Animal {
    String type;
    double volume;
    Pen penType;

    Animal(String type, double volume, Pen penType) {
        this.type = type;
        this.volume = volume;
        this.penType = penType;
    }

    public String getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public Pen getPenType() {
        return penType;
    }
}

