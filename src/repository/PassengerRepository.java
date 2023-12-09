package repository;

import model.Driver;
import model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerRepository {
    List<Passenger> passengerList = new ArrayList<>();
    public PassengerRepository(){

    }

    public PassengerRepository(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public List<Passenger> getPassengerList(){
        return passengerList;
    }
}
