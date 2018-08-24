# Zoo Buddy - The zoo management system built in Java

This is the repo of Zack's submission for their assignment - Advanced 

<blockquote class="imgur-embed-pub" lang="en" data-id="EyF8lR1"><a href="//imgur.com/EyF8lR1">View Program</a></blockquote>

## Getting Started

### Prerequisites

What things you need to install the software

```
Java
Gson either through maven or gradle
For the weather API to function you must have an active internet connection
```

### Installing

how to get a development env running

```
Either clone into you local environment or download master file and import into IDE
```

## Running the tests

Creating custom pens
```
working as intended when button is pressed - ✓
```
Creating custom animals
```
working as intended when button is pressed - ✓
```

Storing animals in pens
```
working as intended and done automatically when choosing a default animal, and users can store a custom animal wherever they wish to - ✓
```

Assigning keepers to pens
```
working as intended an when user presses button. ✓
One limitation is that the user will need to create either a default animal to generate a already made pen, or users will have to create a custom pen to assign keepers.
```

Dropdown lists are populated on application start
```
working as intended when software is initialised - ✓
```

Spinner/Counters are functioning
```
working as intended when spinner up and down arrow is pressed - ✓
```

API displaying current weather
```
working as intended when software is launched - ✓
```

## APPLICATION NOTES

**software flow**

unfortunately due to a error in my initial designs, i had realised the the flow of the software did not allow certain things, i.e keepers to be used without having other criteria met such as pens already created. This can become confusing to first timer users that are not aware of this as they may find unexcpected behavior from the software.

## Reflection

i had originally started this projcet with little no idea of how it would be approached, this in hindsight was a big mistake as it made the overall flow of my project very messy. I would lose track of what did/didnt work, poor and lazy code was written which caused further issues down the line. I found it hard very hard to think of the backend logic and how it would interact with the GUI without creating the GUI first. This meant i had to jump into Scenebuilder and create my very first GUI.

**Creating the GUI**
Creating the GUI was pretty fun to be fair, i had a lot of ideas and at times lost track of where i was becuase i didnt keep note of new ideas that came to mind (i will note ideas down in the future). The original scenebuilder built into IntelliJ was total garbage, which meant the editor would crash every few minutes and the UI was cramped and awkward to navigate. To counter this i had to download a 3rd party appliation - * [Scene Builder](https://gluonhq.com/products/scene-builder/) .

This app made it a breeze to create a UI and most importantly it did not crash!

**The backend logic and learning about controller and UI interactions**
When starting with JavaFX i quickly learnt  that the you didnt really want logical code to be ruining in the main class. (i made that mistake early on so that was lucky!) I learnt about the almighty Controller.java class.

The controller class would be the bridge between the logic and functionality behind elements on the GUI. In tandem with the controller, javaFX would give you the ability to wire up code with GUI elements such as buttons by giving them fxID's. These ID's is what allowed the code to understand which element it was giving functionaly to.

**Future suggestions and ideas**
If there is anything i can take away from this project, it is that planning how user journeys will go is the very important!
Unfortunately i did not do this when starting my proect, but what is more important is that i have finally learnt the concequences of not doing so.

Another few thing that i struggled on and aim to improve on is giving smart names to variables and not repeating code that is already written (i think thats a hidden rule or something). I found myself repeating code multiple times this project due to they way i was getting user input through the GUI. These two things became a huge problem the larger my codebase grew as it became extremely hard to read and navigate through without getting confused and potentially writing code in the wrong places (i did that a few times).

For next time:
- I wouldnt use Java
- Find a framework the supports clean UI building
- Possibly incorporate more libraries to do the heavy lifting for me - dont re-invent the wheel sort of thing
- perhaps think of doing a web app instead
- better planning with a UML
- accurate noting of ideas along the way to avoid losing track of thoughts

## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [GSON](https://github.com/google/gson)
* [CSS](https://en.wikipedia.org/wiki/Cascading_Style_Sheets) - Used to make my ui fancy - its still garbage though
* [Scene Builder](https://gluonhq.com/products/scene-builder/) - because intelliJ's UI builder is absolute ass

## Authors

* **Zack Polc**

## License

* [Do what fk you want public licence](http://www.wtfpl.net/)

## Acknowledgments

* Google
* YouTube

