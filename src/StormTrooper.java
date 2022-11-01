public class StormTrooper extends Trooper{
    private String name = "";
    private static int soldierCount = 0;
    public StormTrooper(String unit, int number){
        super(unit, number);
        soldierCount++;
        this.trooperKind = "StormTrooper";
        this.marchModifier = 1.10;
    }
    public double march(double duration) {
        return duration = marchSpeed * duration * marchModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static int getSoldierCount() {
        return soldierCount;
    }

    public static void setSoldierCount(int soldierCount) {
        StormTrooper.soldierCount = soldierCount;
    }

    public String toString(){
        return name + "("+ super.toString() + ")" +" a " + getTrooperKind();
    }
}
