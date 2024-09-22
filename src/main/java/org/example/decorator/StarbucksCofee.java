package org.example.decorator;

/**
 * Here we will see how decorators can save us from class Exlosion
 * We can make any type of cofee like cofee with soy milk and butter
 */

abstract class Bevarage {
    public abstract String getDescription();
    public abstract int getCost();
}

/**
 * yaha pe Decorator Beverage ko isliye extend kr rha kyuki decorate krne ke baad bhi wo object beverage hi rhe
 * and composition isliye hai kyuki isko use krke hi nayi functionality add krenge
 */

abstract class BevarageDecorator extends Bevarage {

    public BevarageDecorator(Bevarage bevarage) {
        this.bevarage = bevarage;
    }

    protected Bevarage bevarage;
}

// main type of cofeees jo ki normally milti hai
class Latte extends Bevarage {

    @Override
    public String getDescription() {
        return "Latte";
    }

    @Override
    public int getCost() {
        return 5;
    }
}

class Cappacino extends Bevarage {

    @Override
    public String getDescription() {
        return "Cappacino";
    }

    @Override
    public int getCost() {
        return 5;
    }
}


// ab ye sab chizen humari marzi hai jo cofee me daal skte hai
// ab isko lekr hum existing cofee ko decorate krenge
// agr nhi krte to har type ki subclass banani pdti like lateeWithMilk latteWithMilk&ChocoChips

class ChocoChips extends BevarageDecorator {
    public ChocoChips(Bevarage bevarage) {
        super(bevarage);
    }

    @Override
    public String getDescription() {
        return this.bevarage.getDescription() + "+ ChocoChips";
    }

    @Override
    public int getCost() {
        return this.bevarage.getCost() + 5;
    }
}

class Milk extends BevarageDecorator {
    public Milk(Bevarage bevarage) {
        super(bevarage);
    }

    @Override
    public String getDescription() {
        return this.bevarage.getDescription() + "+ Milk";
    }

    @Override
    public int getCost() {
        return this.bevarage.getCost() + 5;
    }
}

class Whip extends BevarageDecorator {
    public Whip(Bevarage bevarage) {
        super(bevarage);
    }

    @Override
    public String getDescription() {
        return this.bevarage.getDescription() + "+ Whipped";
    }

    @Override
    public int getCost() {
        return this.bevarage.getCost() + 5;
    }
}

public class StarbucksCofee {
    public static void main(String[] args) {
        // suppose a person ordered normal coffee which is latte for example

        Bevarage latte = new Latte();
        System.out.println(latte.getDescription());

        // Person2 - orders cappacino with milk
        Bevarage normalCappacino = new Cappacino();
        Bevarage withMilkCappacino = new Milk(normalCappacino);
        System.out.println(withMilkCappacino.getDescription());

        // Person 3- orders latte with milk & chocochips and also whipped
        Bevarage latte2 = new Latte();
        Bevarage withMilkLatte = new Milk(latte2);
        Bevarage withChocoChipsMilkLatte = new ChocoChips(withMilkLatte);
        Bevarage whippedChocoChipsMilkLatte = new Whip(withChocoChipsMilkLatte);
        System.out.println(whippedChocoChipsMilkLatte.getDescription());


    }
}
