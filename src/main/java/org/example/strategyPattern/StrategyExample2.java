package org.example.strategyPattern;

// now yahan pe calling code will decide ki how the behaviour should be achieved

interface NavigationStrategy {
    void navigate();
}

// suppose this is better in highways
class DjiktrasNavigation implements NavigationStrategy{

    @Override
    public void navigate() {
        System.out.println("Using Djiktras Algorithm to navigate");
    }
}

// suppose this algo is better in crowded roads
class NewNavigation implements NavigationStrategy {

    @Override
    public void navigate() {
        System.out.println("Using New  Algorithm to navigate");
    }
}


class NavigationSystem {

    private NavigationStrategy navigationStrategy;

    public NavigationSystem(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
    }

    void navigate() {
        navigationStrategy.navigate();
    }

    void radar() {
        // radas system in car
    }
}


public class StrategyExample2 {

    public static void main(String[] args) {
        NavigationSystem navigationSystem = new NavigationSystem(new DjiktrasNavigation());
        // suppose right now highway is going on
        navigationSystem.navigate();

        //now it is roaming in aminabad
        navigationSystem.setNavigationStrategy(new NewNavigation());
        navigationSystem.navigate();
    }


}
