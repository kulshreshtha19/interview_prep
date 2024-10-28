package Patterns.Behavioural.ObserverPattern;

public class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer phoneObserver = new PhoneDisplay();
        Observer tvObserver = new TvDisplay();

        //Adding Observer
        subject.registerObserver(phoneObserver);
        subject.registerObserver(tvObserver);

        //Notifying Observer
        String weather = "10 degree";
        subject.notifyObservers(weather);

        String newWeather = "20 degree";
        subject.notifyObservers(newWeather);

        subject.removeObserver(phoneObserver);
        subject.notifyObservers(newWeather);
    }
}
