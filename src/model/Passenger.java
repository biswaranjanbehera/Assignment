package model;

import java.util.Map;

public class Passenger {
    public String passengerName;
    public Map<String,Integer> driverList;
    public Passenger(){

    }

    public Passenger(String passengerName, Map<String, Integer> driverList) {
        this.passengerName = passengerName;
        this.driverList = driverList;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Map<String, Integer> getDriverList() {
        return driverList;
    }

    public void setDriverList(Map<String, Integer> driverList) {
        this.driverList = driverList;
    }
}
