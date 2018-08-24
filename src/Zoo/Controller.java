package Zoo;

import Zoo.Weather.WeatherApi;
import Zoo.Weather.WeatherGson;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;

public class Controller {

    public Button animalSubmitButton;
    public Button customSubmitButton;
    public Button keeperSubmitButton;
    public Button customPenSubmitButton;
    public Button saveButton;
    public Button refreshButton;

    public Label landAnimalCounter;
    public Label waterAnimalCounter;
    public Label airAnimalCounter;
    public Label pettingAnimalCounter;
    public Label mixedAnimalCounter;
    public Label customAnimalCounter;
    public Label animalLimitErrorLabel;
    public Label weatherLabel;

    public TextField customAnimalTypeTextField;

    public Spinner customAnimalsVolumeSpinner;
    public Spinner customPenVolumeSpinner;
    public Spinner customPenTempSpinner;

    public ComboBox animalTypeDropDown;
    public ComboBox customAnimalPenTypeDropDown;
    public ComboBox keeperPenTypeDropDown;
    public ComboBox customPenTypeDropDown;

    public CheckBox alanCheckbox;
    public CheckBox alexCheckbox;
    public CheckBox farhadCheckbox;
    public CheckBox hardipCheckbox;

    String customPenTypeInsideDropDown = "custom";
    String penType;
    String customPenType;
    String errorMessageLand = "Too many of the same animal: Land";
    String errorMessageWater = "Too many of the same animal: Water";
    String errorMessageAir = "Too many of the same animal: Air";
    String errorMessageMixed = "Too many of the same animal: Mixed";
    String errorMessagePetting = "Too many of the same animal: Petting";
    String errorMessageCustom = "Too many of the same animal: Custom";


    double numberOfAnimalsCanFit = 10;

    int customPenVolume;
    int customPenTemp;

    Pen land = new Pen("land", 18, 25);
    Pen water = new Pen("water", 10, 25);
    Pen air = new Pen("air", 10, 25);
    Pen mixed = new Pen("mixed", 13, 25);
    Pen petting = new Pen("petting", 15, 24);
    Pen customPen = new Pen(customPenType, customPenTemp, customPenVolume);


    Keeper alan = new Keeper("alan", land, petting);
    Keeper alex = new Keeper("alex", water, mixed);
    Keeper farhad = new Keeper("farhad", air, water);
    Keeper hardip = new Keeper("hardip", land, air);


    HashMap landPens = new HashMap();
    HashMap waterPens = new HashMap();
    HashMap airPens = new HashMap();
    HashMap mixedPens = new HashMap();
    HashMap pettingPens = new HashMap();
    HashMap customPens = new HashMap();
    HashMap keepers = new HashMap();
    // WE WERE STORE OUR FINAL ANIMAL + PEN + KEEPER TOGETHER
    Map<Keeper, HashMap<Pen, Animal>> keepersAndAnimals = new HashMap<>();

    ArrayList<Animal> landAnimals = new ArrayList<>();
    ArrayList<Animal> waterAnimals = new ArrayList<>();
    ArrayList<Animal> airAnimals = new ArrayList<>();
    ArrayList<Animal> pettingAnimals = new ArrayList<>();
    ArrayList<Animal> mixedAnimals = new ArrayList<>();
    ArrayList<Animal> customAnimals = new ArrayList<>();

    WeatherGson weather;

    {
        try {
            weather = WeatherApi.getWeather();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize() {
        try {
            String todaysWeather = "Today's weather is: ";
            weatherLabel.setFont(Font.font(30));
            weatherLabel.setText(ZonedDateTime.now().getHour() + ":"
                    + ZonedDateTime.now().getMinute() + "-"
                    + todaysWeather + weather.getLatestWeather() + "°C");

        } catch (Exception e) {
            e.printStackTrace();
        }

        animalTypeDropDown.getItems().addAll(
                "Cat",
                "Dog",
                "Dolphin",
                "Goat",
                "Hippo",
                "Owl",
                "Penguin",
                "Sloth"
        );

        customAnimalPenTypeDropDown.getItems().addAll(
                "land",
                "aquarium",
                "aviary",
                "mixed",
                "petting",
                customPenTypeInsideDropDown
        );

        keeperPenTypeDropDown.getItems().addAll(
                "land",
                "aquarium",
                "aviary",
                "mixed",
                "petting",
                customPenTypeInsideDropDown
        );

        customPenTypeDropDown.getItems().addAll(
                "Arctic",
                "Sand Dune",
                "Tropical",
                "Forest",
                "Marshlands",
                "Jungle"
        );
    }

    ///////////////////////
    //// Pen STUFF ////

    public void handleCustomPenSubmitButton() {

        customPenType = customPenTypeDropDown.getValue().toString();
        customPenTemp = (int) customPenTempSpinner.getValue();
        customPenVolume = (int) customPenVolumeSpinner.getValue();

        customPen.setType(customPenType);
        customPen.setTemperature(customPenTemp);
        customPen.setVolume(customPenVolume);

        numberOfAnimalsCanFit = customPenVolume;

        customPenTypeInsideDropDown = customPenType;
        System.out.println(customPen);
    }

    ///////////////////////
    //// Keeper STUFF ////

    public void handleKeeperSubmitButton() {

        penType = (String) keeperPenTypeDropDown.getValue();

        if (penType.equals("land") && alanCheckbox.isSelected()) {
            keepersAndAnimals.put(alan, landPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("land") && hardipCheckbox.isSelected()) {
            keepersAndAnimals.put(hardip, landPens);
            System.out.println(keepersAndAnimals);
        }

        if (penType.equals("aquarium") && alexCheckbox.isSelected()) {
            keepersAndAnimals.put(alex, waterPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("aquarium") && farhadCheckbox.isSelected()) {
            keepersAndAnimals.put(farhad, waterPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("aviary") && farhadCheckbox.isSelected()) {
            keepersAndAnimals.put(farhad, airPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("aviary") && hardipCheckbox.isSelected()) {
            keepersAndAnimals.put(hardip, airPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("mixed") && alexCheckbox.isSelected()) {
            keepersAndAnimals.put(alex, mixedPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("petting") && alanCheckbox.isSelected()) {
            keepersAndAnimals.put(alan, pettingPens);
            System.out.println(keepersAndAnimals);
        }
        if (penType.equals("custom")) {
            keepersAndAnimals.put(alan, customPens);
            System.out.println(keepersAndAnimals);
        }
    }

    ////////////////////
    //// ANIMAL TAB ////

    public void handleErrorMessageText() {
        animalLimitErrorLabel.setText("");
    }

    public void handleAnimalSubmitButton() {
        String animalType;

        // arraylist start at 0 so we plus 1 to size.
        int landAnimalSize = landAnimals.size();
        int waterAnimalSize = waterAnimals.size();
        int airAnimalSize = airAnimals.size();
        int pettingAnimalSize = pettingAnimals.size();
        int mixedAnimalSize = mixedAnimals.size();

        animalType = animalTypeDropDown.getValue().toString();

        if (animalType.equals("Cat")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                Cat cat = new Cat("cat", 4, petting);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                pettingAnimals.add(cat);
                pettingPens.put(petting, pettingAnimals);
                System.out.println(Arrays.asList(pettingPens));
            } else if (petting.getVolume() < numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }
        }

        if (animalType.equals("Dog")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                Dog dog = new Dog("dog", 3.5, petting);
                pettingAnimals.add(dog);
                pettingPens.put(petting, pettingAnimals);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                System.out.println(Arrays.asList(pettingPens));
            } else if (pettingAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }
        }
        if (animalType.equals("Dolphin")) {
            if (waterAnimals.size() <= numberOfAnimalsCanFit) {
                Dolphin dolphin = new Dolphin("dolphin", 40, water);
                waterAnimals.add(dolphin);
                waterPens.put(water, waterAnimals);
                waterAnimalCounter.setText("water: " + waterAnimalSize);
                System.out.println(Arrays.asList(waterPens));
            } else if (waterAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageWater);
            }

        }
        if (animalType.equals("Goat")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                Goat goat = new Goat("goat", 3, petting);
                this.pettingAnimals.add(goat);
                pettingPens.put(petting, pettingAnimals);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                System.out.println(Arrays.asList(pettingPens));
            } else if (pettingAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }

        }
        if (animalType.equals("Hippo")) {
            if (mixedAnimals.size() <= numberOfAnimalsCanFit) {
                Hippo hippo = new Hippo("hippo", 20, mixed);
                mixedAnimals.add(hippo);
                mixedPens.put(mixed, mixedAnimals);
                mixedAnimalCounter.setText("mixed: " + mixedAnimalSize);
                System.out.println(Arrays.asList(mixedPens));
            } else if (mixedAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageMixed);
            }

        }
        if (animalType.equals("Owl")) {
            if (airAnimals.size() <= numberOfAnimalsCanFit) {
                Owl owl = new Owl("owl", 20, air);
                airAnimals.add(owl);
                airPens.put(air, airAnimals);
                airAnimalCounter.setText("air: " + airAnimalSize);
                System.out.println(Arrays.asList(airPens));
            } else if (airAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageAir);
            }
        }
        if (animalType.equals("Penguin")) {
            if (mixedAnimals.size() <= numberOfAnimalsCanFit) {
                Penguin penguin = new Penguin("penguin", 20, mixed);
                mixedAnimals.add(penguin);
                mixedPens.put(mixed, mixedAnimals);
                mixedAnimalCounter.setText("mixed: " + mixedAnimalSize);
                System.out.println(Arrays.asList(mixedPens));
            } else if (mixedAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageMixed);
            }

        }
        if (animalType.equals("Sloth")) {
            if (landAnimals.size() <= numberOfAnimalsCanFit) {
                Sloth sloth = new Sloth("sloth", 3, land);
                landAnimals.add(sloth);
                landPens.put(land, landAnimals);
                landAnimalCounter.setText("land: " + landAnimalSize);
                System.out.println(Arrays.asList(landPens));
            } else if (landAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageLand);
            }

        }
    }

    public void handleCustomSubmitButton() {
        String animalType;
        int volume;
        Pen penType;
        String selectedPenType;

        // arraylist start at 0 so we plus 1 to size.
        int landAnimalSize = landAnimals.size();
        int waterAnimalSize = waterAnimals.size();
        int airAnimalSize = airAnimals.size();
        int pettingAnimalSize = pettingAnimals.size();
        int customAnimalSize = customAnimals.size();
        int mixedAnimalSize = mixedAnimals.size();

        landAnimalCounter.setText("land: " + landAnimals.size());
        waterAnimalCounter.setText("water: " + waterAnimals.size());
        airAnimalCounter.setText("air: " + airAnimals.size());
        pettingAnimalCounter.setText("petting: " + pettingAnimals.size());
        mixedAnimalCounter.setText("mixed: " + mixedAnimals.size());

        animalType = customAnimalTypeTextField.getText();
        volume = (int) customAnimalsVolumeSpinner.getValue();
        selectedPenType = customAnimalPenTypeDropDown.getValue().toString();

        if (selectedPenType.equals("land")) {
            if (landAnimals.size() <= numberOfAnimalsCanFit) {
                penType = land;
                CustomAnimal customAnimal = new CustomAnimal(animalType, volume, penType);
                landAnimals.add(customAnimal);
                landPens.put(land, landAnimals);
                landAnimalCounter.setText("land: " + landAnimalSize);
                System.out.println(Arrays.asList(landPens));
            } else {
                animalLimitErrorLabel.setText(errorMessageLand);
            }
        }
        if (selectedPenType.equals("aquarium")) {
            if (waterAnimals.size() <= numberOfAnimalsCanFit) {
                penType = water;
                CustomAnimal customAnimal = new CustomAnimal(animalType, volume, penType);
                waterAnimals.add(customAnimal);
                waterPens.put(water, waterAnimals);
                waterAnimalCounter.setText("water: " + waterAnimalSize);
                System.out.println(Arrays.asList(waterPens));
            } else {
                animalLimitErrorLabel.setText(errorMessageWater);
            }
        }
        if (selectedPenType.equals("aviary")) {
            if (airAnimals.size() <= numberOfAnimalsCanFit) {
                penType = air;
                CustomAnimal customAnimal = new CustomAnimal(animalType, volume, penType);
                airAnimals.add(customAnimal);
                airPens.put(air, airAnimals);
                airAnimalCounter.setText("air: " + airAnimalSize);
                System.out.println(Arrays.asList(airPens));
            } else {
                animalLimitErrorLabel.setText(errorMessageAir);
            }
        }
        if (mixedAnimals.size() <= numberOfAnimalsCanFit) {
            if (selectedPenType.equals("mixed")) {
                penType = mixed;
                CustomAnimal customAnimal = new CustomAnimal(animalType, volume, penType);
                mixedAnimals.add(customAnimal);
                mixedPens.put(mixed, mixedAnimals);
                mixedAnimalCounter.setText("mixed: " + mixedAnimalSize);
                System.out.println(Arrays.asList(mixedPens));
            }
        } else {
            animalLimitErrorLabel.setText(errorMessageMixed);
        }

        if (selectedPenType.equals("petting")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                penType = petting;
                CustomAnimal customAnimal = new CustomAnimal(animalType, volume, penType);
                pettingAnimals.add(customAnimal);
                pettingPens.put(petting, pettingAnimals);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                System.out.println(Arrays.asList(pettingPens));
            } else {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }
        }

        if (selectedPenType.equals("custom")) {
            if (customAnimals.size() <= numberOfAnimalsCanFit) {
                penType = customPen;
                CustomAnimal customAnimal = new CustomAnimal(animalType, volume, penType);
                customAnimals.add(customAnimal);
                customPens.put(customPen, customAnimals);
                customAnimalCounter.setText("Custom: " + customAnimalSize);
                System.out.println(Arrays.asList(customPens));
            } else {
                animalLimitErrorLabel.setText(errorMessageCustom);
            }
        }
    }

    public String landAnimalNames() {
        String landNames = "";
        for (int i = 0; i < landAnimals.size(); i++) {
            landNames = landAnimals.get(i).getType();
        }
        return landNames;
    }

    public String waterAnimalNames() {
        String waterNames = "";
        for (int i = 0; i < waterAnimals.size(); i++) {
            waterNames = waterAnimals.get(i).getType();
        }
        return waterNames;
    }

    public String airAnimalNames() {
        String airNames = "";
        for (int i = 0; i < airAnimals.size(); i++) {
            airNames = airAnimals.get(i).getType();
        }
        return airNames;
    }

    public String mixedAnimalNames() {
        String mixedNames = "";
        for (int i = 0; i < mixedAnimals.size(); i++) {
            mixedNames = mixedAnimals.get(i).getType();
        }
        return mixedNames;
    }

    public String pettingAnimalNames() {
        String pettingNames = "";
        for (int i = 0; i < pettingAnimals.size(); i++) {
            pettingNames = pettingAnimals.get(i).getType();
        }
        return pettingNames;
    }

    public String customAnimalNames() {
        String customNames = "";
        for (int i = 0; i < customAnimals.size(); i++) {
            customNames = customAnimals.get(i).getType();
        }
        return customNames;
    }

    public void save() throws FileNotFoundException {
        File fileTwo = new File("output.txt");
        FileOutputStream fos = new FileOutputStream(fileTwo);
        PrintWriter pw = new PrintWriter(fos);

        for (Map.Entry<Keeper, HashMap<Pen, Animal>> map : keepersAndAnimals.entrySet()) {
            pw.println(
                    map.getKey().name + " is the keeper of: " + "\n" +
                            " petting: " + pettingAnimals + "\n"
                            + "custom: " + customAnimalNames() + "\n"
                            + "mixed: " + mixedAnimalNames() + "\n"
                            + "water: " + waterAnimalNames() + "\n"
                            + "land: " + landAnimalNames() + "\n"
                            + "air: " + airAnimalNames() + "\n"
            );
        }

        System.out.println("-------- file saved > check project folder ---------");
        pw.flush();
        pw.close();

    }
}
