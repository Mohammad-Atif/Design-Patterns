package org.example.observer.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Practicing shreyansh j, observer  notify me questions
 * When a user visits amazon website and see a product not available, he clicks on notify me
 * Whenever the product is available, the notification is sent to the user.
 */

interface Observer{
    void update();
}

interface Observable {

    void add(Observer observer);
    void remove(Observer observer);
    void updateAll();
}

class NotificationService {
    public void sendNotification(String s) {
        System.out.println(s + "Item is available now");
    }
}

class AmazonCart implements Observable {
    List<Observer> observers;
    List<String> availableItems;
    public AmazonCart() {
        this.observers = new ArrayList<>();
        availableItems = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void updateAll() {
        observers.forEach(Observer::update);
    }

    public void makeItemAvailable(String s) {
        availableItems.add(s);
        updateAll();
    }
}



class User implements Observer {
    private Observable cartObservable;
    private NotificationService notificationService;
    public User(Observable observable, NotificationService notificationService) {
        this.cartObservable = observable;
        this.notificationService = notificationService;
    }

    @Override
    public void update() {
        AmazonCart amazonCart = (AmazonCart) cartObservable;
        notificationService.sendNotification(amazonCart.availableItems.toString());
    }

}


public class NotifyMeAmazonCart {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        AmazonCart amazonCart = new AmazonCart();
        User user1 = new User(amazonCart,notificationService);
        User user2 = new User(amazonCart,notificationService);
        amazonCart.add(user1);
        amazonCart.add(user2);

        amazonCart.makeItemAvailable("Iphone 12 pro");

    }
}
