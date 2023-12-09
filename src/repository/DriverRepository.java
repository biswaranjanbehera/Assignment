package repository;

import model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    List<Driver> driverList = new ArrayList<>();

    public DriverRepository(){

    }
    public DriverRepository(List<Driver> driverList) {
        this.driverList = driverList;
    }

    public void addDriver(Driver driver){
        driverList.add(driver);
    }

    public List<Driver> getDriverList(){
        return driverList;
    }
}
