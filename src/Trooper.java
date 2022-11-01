/*
Title: Trooper
Abstract: The purpose of this program is to create a trooper which is extended by StormTrooper and RebelTrooper then
in the StormTrooper and RebelTrooper they have march, soldercount, toString and constructor changed to fit the type of
trooper they are.
Author: Aaron Martinez
Date: 10/4/22
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;

public abstract class Trooper {
    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier;

    Trooper() {
        this("AA", 0);

    }

    public Trooper(String unit, int number) {
        this.number = number;
        this.unit = unit;
        marchSpeed = 5;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper t) {
        if (t == null) {
            return;
        }
        if (!units.containsKey(t.unit)) {
            List<Trooper> trooperList = new ArrayList<Trooper>();
            units.put(t.unit, trooperList);
            trooperList.add(t);
            return;
        }
        units.get(t.unit).add(t);
    }

    public abstract double march(double duration);


    //creates attack method
    public boolean attack(Trooper target, int roll) {
        // checks to see if target equals the current object or if the roll is equal to 1
        if (this.equals(target) || roll == 1) {
            System.out.println(this.toString() + " is targeting itself.");
            System.out.println(this.toString() + " rolled a " + roll + " and hurt itself in the confusion");
            return true;
        }

        // checks to see if the current object is an instance of StormTrooper
        if (this instanceof StormTrooper) {
            // checks to see if the current object is an instance of RebelTrooper
            if (target instanceof RebelTrooper) {
                System.out.println("rolled a " + roll + " against the rebel scum.");
                if (roll > 10 && roll % 2 == 0) {
                    return true;
                }
                // checks to see if the current object is an instance of StormTrooper if true return false
            } else if (target instanceof StormTrooper) {
                System.out.println("No treason in the ranks");
                return false;
                // if the target is anything else other than StormTrooper ot rebelTrooper return true
            } else {
                System.out.println("Acceptable Collateral Damage!");
                if (roll > 10 || roll % 2 == 0) {
                    return true;
                }
            }
        }

        // checks to see if the current object is an instance of RebelTrooper
        if (this instanceof RebelTrooper ) {
            // checks to see if the current object is an instance of RebelTrooper
            if(target instanceof RebelTrooper){
                System.out.println("Imperial Spy");
                return false;
                // checks to see if the current object is an instance of StormTrooper
            } else if (target instanceof StormTrooper){
                System.out.println( "rolled a " +  roll + " against the imperial scum.");
                if (roll > 5 || roll % 2 != 0){
                    return true;
                }
                // if the target is anything else other than StormTrooper ot rebelTrooper return true
            } else {
                System.out.println("Rebels target an innocent bystander.");
                if (roll >= 18 && roll % 2 == 0){
                    return true;
                }
            }
        }

        return false;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    public double getMarchModifier() {
        return marchModifier;
    }

    public void setMarchModifier(double marchModifier) {
        this.marchModifier = marchModifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trooper trooper)) return false;
        return getNumber() == trooper.getNumber() && Double.compare(trooper.getMarchSpeed(), getMarchSpeed()) == 0 && Double.compare(trooper.getMarchModifier(), getMarchModifier()) == 0 && Objects.equals(getUnit(), trooper.getUnit()) && Objects.equals(getTrooperKind(), trooper.getTrooperKind());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnit(), getNumber(), getTrooperKind(), getMarchSpeed(), getMarchModifier());
    }

    public String toString(){
        return unit + number + ":";
    }

}
