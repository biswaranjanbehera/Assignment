package model;

import java.util.Map;

public class Driver {
    public String driverName;
    public Map<String,Integer> passengerList;

    public Driver(){

    }
    public Driver(String driverName, Map<String, Integer> passengerList) {
        this.driverName = driverName;
        this.passengerList = passengerList;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setPassengerList(Map<String, Integer> passengerList) {
        this.passengerList = passengerList;
    }

    public String getDriverName() {
        return driverName;
    }

    public Map<String, Integer> getPassengerList() {
        return passengerList;
    }
}
