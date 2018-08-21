package Zoo;

import Zoo.Pen;

public abstract class Animal {
    String type;
    double landSpace;
    double waterSpace;
    double airSpace;
    Pen penType;

    Animal(String type, double landSpace, double waterSpace, double airSpace, Pen penType) {
        this.type = type;
        this.landSpace = landSpace;
        this.waterSpace = waterSpace;
        this.airSpace = airSpace;
        this.penType = penType;
    }

    public String getType() {
        return type;
    }

    public String getSpace() {
        String landSpacePrint = String.valueOf(landSpace);
        String WaterSpacePrint = String.valueOf(waterSpace);
        String airSpacePrint = String.valueOf(airSpace);
        String allSpacePrint = landSpacePrint + "," + waterSpace + "," + airSpacePrint;
        return allSpacePrint;
    }

    public Pen getPenType() {
        return penType;
    }
}

