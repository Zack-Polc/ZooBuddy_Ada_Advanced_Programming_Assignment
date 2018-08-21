package Zoo;

import Zoo.Weather.WeatherAPI;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.*;

public class Controller {

    public Button animalSubmitButton;
    public Button penSubmitButton;
    public Button initialiseButton;

    public Label landAnimalCounter;
    public Label waterAnimalCounter;
    public Label airAnimalCounter;
    public Label pettingAnimalCounter;
    public Label mixedAnimalCounter;
    public Label animalLimitErrorLabel;

    public TextField customAnimalTypeTextField;

    public Spinner customAnimalSizeLandSpinner;
    public Spinner customAnimalSizeWaterSpinner;
    public Spinner customAnimalSizeAirSpinner;
    public Spinner penWidthSpinner;
    public Spinner penLengthSpinner;
    public Spinner penHeightSpinner;


    public ComboBox animalTypeDropDown;
    public ComboBox penTypeDropDown;
    public ComboBox customPenTypeDropDown;

    public CheckBox alanCheckbox;
    public CheckBox alexCheckbox;
    public CheckBox farhadCheckbox;
    public CheckBox hardipCheckbox;

    String penType;
    String errorMessageLand = "Too many of the same animal: Land";
    String errorMessageWater = "Too many of the same animal: Water";
    String errorMessageAir = "Too many of the same animal: Air";
    String errorMessageMixed = "Too many of the same animal: Mixed";
    String errorMessagePetting = "Too many of the same animal: Petting";

    int penArea;
    int width;
    int length;
    int height;
    int volume;

    double numberOfAnimalsCanFit = 10;

    // height of 1 is to ignore height axis
    Pen land = new Pen("land", numberOfAnimalsCanFit, 1, 25);
    Pen water = new Pen("water", numberOfAnimalsCanFit, 1, 25);
    Pen air = new Pen("air", numberOfAnimalsCanFit, 1, 25);
    Pen mixed = new Pen("mixed", numberOfAnimalsCanFit, 1, 25);
    Pen petting = new Pen("petting", numberOfAnimalsCanFit, 1, 25);

    Keeper alan = new Keeper("alan", land, petting);
    Keeper alex = new Keeper("alex", water, mixed);
    Keeper farhad = new Keeper("farhad", air, water);
    Keeper hardip = new Keeper("hardip", land, air);

    HashMap pens = new HashMap();
    HashMap keepers = new HashMap();

    ArrayList<Animal> landAnimals = new ArrayList<>();
    ArrayList<Animal> waterAnimals = new ArrayList<>();
    ArrayList<Animal> airAnimals = new ArrayList<>();
    ArrayList<Animal> pettingAnimals = new ArrayList<>();
    ArrayList<Animal> mixedAnimals = new ArrayList<>();

    @FXML
    public void initialize() {
        try {
            WeatherAPI weather = WeatherAPI.getWeather();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialiseZoo() throws InterruptedException {

        try {
            animalTypeDropDown.getItems().clear();
            penTypeDropDown.getItems().clear();
        } catch (Exception e) {
            initialiseButton.setText("Could not initialise Zoo: something went wrong :(");
        } finally {
            // hiding the button to stop re-population of lists
            initialiseButton.setTranslateX(9000);
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


        customPenTypeDropDown.getItems().addAll(
                "land",
                "aquarium",
                "aviary",
                "mixed",
                "petting"
        );

        penTypeDropDown.getItems().addAll(
                "land",
                "aquarium",
                "aviary",
                "mixed",
                "petting"
        );
    }

    /////////////////
    //// PEN TAB ////

    public void handlePenSubmitButton() {

        penType = (String) penTypeDropDown.getValue();

        if (penType.equals("land") && alanCheckbox.isSelected()) {
            keepers.put(land, alan);
            System.out.println(keepers);
        }
        if (penType.equals("land") && hardipCheckbox.isSelected()) {
            keepers.put(land, hardip);
        }

        if (penType.equals("aquarium") && alexCheckbox.isSelected()) {
            keepers.put(water, alex);
        }
        if (penType.equals("aquarium") && farhadCheckbox.isSelected()) {
            keepers.put(water, farhad);
        }
        if (penType.equals("aviary") && farhadCheckbox.isSelected()) {
            keepers.put(air, farhad);
            System.out.println(keepers);
        }
        if (penType.equals("aviary") && hardipCheckbox.isSelected()) {
            keepers.put(air, hardip);
            System.out.println(keepers);
        }
        if (penType.equals("mixed") && alexCheckbox.isSelected()) {
            keepers.put(mixed, alex);
        }
        if (penType.equals("petting") && alanCheckbox.isSelected()) {
            keepers.put(petting, alan);
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
            Cat cat = new Cat("cat", 4, 0, 0, petting);
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                pettingAnimals.add(cat);
                pens.put(petting, pettingAnimals);
                System.out.println(Arrays.asList(pens));
            } else if (pettingAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }
        }

        if (animalType.equals("Dog")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                Dog dog = new Dog("dog", 3.5, 0, 0, petting);
                pettingAnimals.add(dog);
                pens.put(petting, pettingAnimals);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (pettingAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }
        }
        if (animalType.equals("Dolphin")) {
            if (waterAnimals.size() <= numberOfAnimalsCanFit) {
                Dolphin dolphin = new Dolphin("dolphin", 0, 40, 0, water);
                waterAnimals.add(dolphin);
                pens.put(water, waterAnimals);
                waterAnimalCounter.setText("water: " + waterAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (waterAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageWater);
            }

        }
        if (animalType.equals("Goat")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                Goat goat = new Goat("goat", 3, 0, 0, petting);
                this.pettingAnimals.add(goat);
                pens.put(petting, pettingAnimals);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (pettingAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }

        }
        if (animalType.equals("Hippo")) {
            if (mixedAnimals.size() <= numberOfAnimalsCanFit) {
                Hippo hippo = new Hippo("hippo", 0, 0, 20, mixed);
                mixedAnimals.add(hippo);
                pens.put(mixed, mixedAnimals);
                mixedAnimalCounter.setText("mixed: " + mixedAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (mixedAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageMixed);
            }

        }
        if (animalType.equals("Owl")) {
            if (airAnimals.size() <= numberOfAnimalsCanFit) {
                Owl owl = new Owl("owl", 0, 0, 20, air);
                airAnimals.add(owl);
                pens.put(air, airAnimals);
                airAnimalCounter.setText("air: " + airAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (airAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageAir);
            }
        }
        if (animalType.equals("Penguin")) {
            if (mixedAnimals.size() <= numberOfAnimalsCanFit) {
                Penguin penguin = new Penguin("penguin", 2, 4, 0, mixed);
                mixedAnimals.add(penguin);
                pens.put(mixed, mixedAnimals);
                mixedAnimalCounter.setText("mixed: " + mixedAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (mixedAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageMixed);
            }

        }
        if (animalType.equals("Sloth")) {
            if (landAnimals.size() <= numberOfAnimalsCanFit) {
                Sloth sloth = new Sloth("sloth", 3, 0, 0, land);
                landAnimals.add(sloth);
                pens.put(land, landAnimals);
                landAnimalCounter.setText("land: " + landAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else if (landAnimals.size() > numberOfAnimalsCanFit) {
                animalLimitErrorLabel.setText(errorMessageLand);
            }

        }
    }

    public void handleCustomSubmitButton() {
        String animalType;
        int landSize;
        int waterSize;
        int airSize;
        Pen penType;
        String selectedPenType;

        // arraylist start at 0 so we plus 1 to size.
        int landAnimalSize = landAnimals.size() + 1;
        int waterAnimalSize = waterAnimals.size() + 1;
        int airAnimalSize = airAnimals.size() + 1;
        int pettingAnimalSize = pettingAnimals.size() + 1;
        int mixedAnimalSize = mixedAnimals.size() + 1;

        landAnimalCounter.setText("land: " + landAnimals.size());
        waterAnimalCounter.setText("water: " + waterAnimals.size());
        airAnimalCounter.setText("air: " + airAnimals.size());
        pettingAnimalCounter.setText("petting: " + pettingAnimals.size());
        mixedAnimalCounter.setText("mixed: " + mixedAnimals.size());

        animalType = customAnimalTypeTextField.getText();
        landSize = (int) customAnimalSizeLandSpinner.getValue();
        waterSize = (int) customAnimalSizeWaterSpinner.getValue();
        airSize = (int) customAnimalSizeAirSpinner.getValue();
        selectedPenType = customPenTypeDropDown.getValue().toString();

        if (selectedPenType.equals("land")) {
            if (landAnimals.size() <= numberOfAnimalsCanFit) {
                penType = land;
                CustomAnimal customAnimal = new CustomAnimal(animalType, landSize, waterSize, airSize, penType);
                landAnimals.add(customAnimal);
                pens.put(land, landAnimals);
                landAnimalCounter.setText("land: " + landAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else {
                animalLimitErrorLabel.setText(errorMessageLand);
            }
        }
        if (selectedPenType.equals("aquarium")) {
            if (waterAnimals.size() <= numberOfAnimalsCanFit) {
                penType = water;
                CustomAnimal customAnimal = new CustomAnimal(animalType, landSize, waterSize, airSize, penType);
                waterAnimals.add(customAnimal);
                pens.put(water, waterAnimals);
                waterAnimalCounter.setText("water: " + waterAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else {
                animalLimitErrorLabel.setText(errorMessageWater);
            }
        }
        if (selectedPenType.equals("aviary")) {
            if (airAnimals.size() <= numberOfAnimalsCanFit) {
                penType = air;
                CustomAnimal customAnimal = new CustomAnimal(animalType, landSize, waterSize, airSize, penType);
                airAnimals.add(customAnimal);
                pens.put(air, airAnimals);
                airAnimalCounter.setText("air: " + airAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else {
                animalLimitErrorLabel.setText(errorMessageAir);
            }
        }
        if (mixedAnimals.size() <= numberOfAnimalsCanFit) {
            if (selectedPenType.equals("mixed")) {
                penType = mixed;
                CustomAnimal customAnimal = new CustomAnimal(animalType, landSize, waterSize, airSize, penType);
                mixedAnimals.add(customAnimal);
                pens.put(mixed, mixedAnimals);
                mixedAnimalCounter.setText("mixed: " + mixedAnimalSize);
                System.out.println(Arrays.asList(pens));
            }
        } else {
            animalLimitErrorLabel.setText(errorMessageMixed);
        }

        if (selectedPenType.equals("petting")) {
            if (pettingAnimals.size() <= numberOfAnimalsCanFit) {
                penType = petting;
                CustomAnimal customAnimal = new CustomAnimal(animalType, landSize, waterSize, airSize, penType);
                pettingAnimals.add(customAnimal);
                pens.put(petting, pettingAnimals);
                pettingAnimalCounter.setText("petting: " + pettingAnimalSize);
                System.out.println(Arrays.asList(pens));
            } else {
                animalLimitErrorLabel.setText(errorMessagePetting);
            }
        }
    }
}
