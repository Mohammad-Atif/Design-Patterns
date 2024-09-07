package org.example.strategyPattern;

/**
 * 1st use case -  Many Child class with some having same functionality
 */

interface DriveStrategy {
    void drive();
}

class NormalDrive implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Normal driving functionality");
    }
}

class SportyDrive implements DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Sporty driving functionality");
    }
}

class Vehicle {
    private DriveStrategy driveStrategy;

    // it is responsibility of child class, which drive it wants
    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();;
    }

}

// now There is F1 vehicle which needs sporty drive funcionality
class FormulaVehicle extends Vehicle {

    public FormulaVehicle() {
        super(new SportyDrive());
    }

    // other features or methods
}

// now CommercialVehicle needs normal drive

class CommercialVehicle extends Vehicle {
    public CommercialVehicle() {
        super(new NormalDrive());
    }
    // other features or methods
}

/** ab NonCommercialVehicle also needs normal drive
 * ab agar strategy nhi use krte to drive ko sare class Override krke apni apni functionality dete
 * and is case me kyuki CommercialVehicle and NonCommercial me drive same trah hai to code duplicate hoti in drive() override me
**/
class NonCommercialVehicle extends Vehicle {
    public NonCommercialVehicle() {
        super(new NormalDrive());
    }
    // other features or methods
}

public class StrategyExample1 {

    public static void main(String[] args) {
        Vehicle nissanFormula1 = new FormulaVehicle();
        nissanFormula1.drive();;

        Vehicle boleroCarSawari = new CommercialVehicle();
        boleroCarSawari.drive();

        Vehicle swift = new NonCommercialVehicle();
        swift.drive();
    }

}
