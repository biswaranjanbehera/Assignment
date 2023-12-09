package util;

import model.Driver;
import model.Passenger;
import repository.DriverRepository;
import repository.PassengerRepository;

import java.util.List;
import java.util.Map;

public class Util {

    public static int calculateDistance(int x1,int y1,int x2,int y2){
        return (int) Math.sqrt(((x2-x1)*(x2-x1)) +((y2-y1)*(y2-y1)));
    }

    /*public static Double findPassengerRating(DriverRepository driverRepository,String passengerName){
        double rating  = 0.0;
        int c= 0;
        List<Driver> driverList = driverRepository.getDriverList();
        for(int i=0;i<driverList.size();i++){
            Map<String,Integer> mp = driverList.get(i).getPassengerList();
            if(mp.containsKey(passengerName)){
                rating = rating + mp.get(passengerName);
                c++;
            }
        }
        return rating / c;
    }*/
    //using stream api
    public static Double findPassengerRating(DriverRepository driverRepository, String passengerName) {
        List<Driver> driverList = driverRepository.getDriverList();
        double rating = driverList.stream()
                .mapToDouble(driver -> {
                    Map<String, Integer> passengerMap = driver.getPassengerList();
                    return passengerMap.getOrDefault(passengerName, 0);
                })
                .filter(ratingForPassenger -> ratingForPassenger > 0)
                .average()
                .orElse(0.0);
        return rating;
    }

    public static Double findDriverRating(PassengerRepository passengerRepository,String driverName){
        double rating  = 0;
        int c= 0;
        List<Passenger> passengerList = passengerRepository.getPassengerList();
        for(int i=0;i<passengerList.size();i++){
            Map<String,Integer> mp = passengerList.get(i).getDriverList();
            if(mp.containsKey(driverName)){
                c++;
                rating = rating + mp.get(driverName);
            }
        }
        return rating/c;

    }

    public static boolean hasPrevious(String driverName,String passengerName,PassengerRepository passengerRepository){
        List<Passenger> passengerList = passengerRepository.getPassengerList();
        for(int i=0;i<passengerList.size();i++){
            if(passengerList.get(i).getPassengerName().equals(passengerName)){
                Map<String,Integer> mp = passengerList.get(i).getDriverList();
                if(mp.containsKey(driverName))
                    return true;
            }
        }
        return false;
    }
}


