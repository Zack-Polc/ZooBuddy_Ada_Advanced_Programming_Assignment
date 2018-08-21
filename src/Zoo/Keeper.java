/*
    ● Hardip : Responsible for Dry Pens and Aviaries
    ● Alex : Responsible for Aquariums and Part water, part dry pens
    ● Farhad : Responsible for Aviaries and Aquariums
    ● Alan : Responsible for Dry Pens and Petting Pens
 */

package Zoo;

public class Keeper {
    String name;
    Pen assignedPen1;
    Pen assignedPen2;

    Keeper(String name, Pen assignedPen1, Pen assignedPen2) {
        this.name = name;
        this.assignedPen1 = assignedPen1;
        this.assignedPen2 =  assignedPen2;
    }

    public String getName() {
        return name;
    }


    public String getAssignedPen() {
        String assignedPens = assignedPen1.getType() + " + " + assignedPen2.getType();
        return assignedPens;
    }
}