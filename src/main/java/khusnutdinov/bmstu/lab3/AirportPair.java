package khusnutdinov.bmstu.lab3;

import java.io.Serializable;

public class AirportPair implements Serializable {
    private int totalFlights;
    private int cancelledFlights;
    private int delayedFlights;
    private double maxDelay;

    public AirportPair(int totalFlights, int cancelledFlights, int delayedFlights, double maxDelay){
        this.totalFlights = totalFlights;
        this.cancelledFlights = cancelledFlights;
        this.delayedFlights = delayedFlights;
        this.maxDelay = maxDelay;
    }

    public static AirportPair addData(AirportPair airportPair1, AirportPair airportPair2){
        return new AirportPair(
                airportPair1.totalFlights + airportPair2.totalFlights,
                airportPair1.cancelledFlights + airportPair2.cancelledFlights,
                airportPair1.delayedFlights + airportPair2.delayedFlights,
                Math.max(airportPair1.maxDelay, airportPair2.maxDelay)
        );
    }

    public  AirportPair addFlight(int cancelledFlight, int delayedFlight, double maxDelay){
        return new AirportPair(
                this.totalFlights + 1,
                this.cancelledFlights + cancelledFlight,
                this.delayedFlights + delayedFlight,
                Math.max(this.maxDelay, maxDelay)
        );
    }

    public int getCancelledFlights() {
        return cancelledFlights;
    }

    public int getDelayedFlights() {
        return delayedFlights;
    }

    public double getMaxDelay() {
        return maxDelay;
    }

    public int getTotalFlights() {
        return totalFlights;
    }

    public double getDelayPercentage(){
        return (double)delayedFlights / totalFlights;
    }

    public double getCancelledPercentage(){
        return (double)cancelledFlights / totalFlights;
    }
}
