package khusnutdinov.bmstu.lab3;

import java.io.Serializable;

public class FlightsData implements Serializable {

    private static final int DEST_AIRPORT_ID_INDEX = 14;
    private static final int FLIGHT_DELAY_INDEX = 17;
    private static final int 


    private int departAirportID;
    private int arrivalAirportID;
    private boolean delayed, cancelled;
    private double delay;

    public FlightsData(String flData){
        String[] table = flData.split(",");
        // TODO CONSTS
        this.arrivalAirportID = Integer.parseInt(table[...]);
        this.departAirportID = Integer.parseInt(table[...]);
        this.cancelled = table[...];
        if(true){
            delay = ...;
        }else{
            this.delay = 0.0;
        }
        if(delay > 0.0){
            this.delayed = true;
        }else{
            this.delayed = false;
        }
    }

    public int getArrivalAirportID(){
        return arrivalAirportID;
    }

    public int getDepartAirportID(){
        return departAirportID;
    }

    public double getDelay(){
        return delay;
    }

    public boolean getCancelled(){
        return cancelled;
    }

    public boolean getDelayed(){
        return delayed;
    }

}
