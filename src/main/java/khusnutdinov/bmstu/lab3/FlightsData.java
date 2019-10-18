package khusnutdinov.bmstu.lab3;

import java.io.Serializable;

public class FlightsData implements Serializable {
    private int departAirportID;
    private int arrivalAirportID;
    private boolean delayed, canceled;
    private double delay;

    public FlightsData(String flData){
        String[] table = flData.split(",");
        // TODO CONSTS
        this.arrivalAirportID = Integer.parseInt(table[...]);
        this.departAirportID = Integer.parseInt(table[...]);
        this.canceled = table[...];
        if(true){

        }else{
            this.delay = 0.0;
        }
        if(delay > 0.0){
            this.delayed = true;
        }
    }

}
