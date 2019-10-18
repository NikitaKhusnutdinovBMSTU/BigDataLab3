package khusnutdinov.bmstu.lab3;

import java.io.Serializable;

public class FlightsData implements Serializable {

    private static final int ORIGIN_AIRPORT_ID_INDEX = 11;
    private static final int DEST_AIRPORT_ID_INDEX = 14;
    private static final int FLIGHT_DELAY_INDEX = 17;
    private static final int CANCELLED_INDEX = 19;


    private int originAirportID;
    private int destAirportID;
    private boolean delayed, cancelled;
    private double delay;

    public FlightsData(String flData){
        String[] table = flData.split(",");
        // TODO CONSTS
        this.destAirportID = Integer.parseInt(table[DEST_AIRPORT_ID_INDEX]);
        this.originAirportID = Integer.parseInt(table[ORIGIN_AIRPORT_ID_INDEX]);
        this.cancelled = table[CANCELLED_INDEX].equals("1.00");
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

    public int getDestAirportID(){
        return destAirportID;
    }

    public int getOriginAirportID(){
        return originAirportID;
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
