package service;

import model.Driver;
import repository.DriverRepository;

import java.util.List;

public class DriverService {

    DriverRepository driverRepository;
    public DriverService(){

    }

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String addDriver(Driver driver){
        driverRepository.addDriver(driver);
        return "added new driver";
    }

    public List<Driver> getAllDriverList(){
        List<Driver> temp= driverRepository.getDriverList();
        return temp;
    }
}
