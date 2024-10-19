import java.util.ArrayList;
import java.util.List;

// Subject
interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String message);
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Create Observer interface
interface Observer {
    void update(String message);
}

// Create Concrete Observer
class NewsReader implements Observer {
    private String name;

    public NewsReader(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}


public class ObserverPatternDemo {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        NewsReader reader1 = new NewsReader("Reader 1");
        NewsReader reader2 = new NewsReader("Reader 2");

        agency.subscribe(reader1);
        agency.subscribe(reader2);

        agency.notifyObservers("Breaking news: Java is awesome!");

            }
}
