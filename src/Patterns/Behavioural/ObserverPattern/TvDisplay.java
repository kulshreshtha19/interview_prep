package Patterns.Behavioural.ObserverPattern;

public class TvDisplay implements Observer{

    private String weather;

    @Override
    public void update(String weather){
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println(weather + " is on the tv");
    }
}
