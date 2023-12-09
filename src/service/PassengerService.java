package service;

import model.Driver;
import model.DriverRequest;
import model.Passenger;
import repository.DriverRepository;
import repository.PassengerRepository;
import util.Util;

import java.util.*;

public class PassengerService {

    PassengerRepository passengerRepository;
    DriverRepository driverRepository;

    public PassengerService(){

    }

    public PassengerService(PassengerRepository passengerRepository,DriverRepository driverRepository) {
        this.passengerRepository = passengerRepository;
        this.driverRepository = driverRepository;
    }

    public String addPassenger(Passenger passenger){
        passengerRepository.addPassenger(passenger);
        return "added new passenger";
    }

    public List<Passenger> getAllPassengerList(){
        List<Passenger> temp= passengerRepository.getPassengerList();
        return temp;
    }

    public Map<String,Integer> help(List<DriverRequest> eligibleDriverList,int x_cord,int y_cord){
        int ans = Integer.MAX_VALUE;
        String finalDriverName = "";
        int finalDistance = 0;
        for(int i=0;i<eligibleDriverList.size();i++){
            String name =eligibleDriverList.get(i).getName();
            int x = eligibleDriverList.get(i).getX();
            int y = eligibleDriverList.get(i).getY();
            int dist = Util.calculateDistance(x_cord,y_cord,x,y);
            if(dist<ans){
                ans = dist;
                finalDriverName = name;
            }
        }
        finalDistance = ans;
        Map<String,Integer> result =new HashMap<>();
        result.put(finalDriverName,finalDistance);
        return result;
    }

    public void findNear(List<DriverRequest> driverRequest, String passenger, int x_cord, int y_cord){
        double passengerRating  =  Util.findPassengerRating(driverRepository,passenger);
        Map<String,Integer> result = new HashMap<>();
        List<DriverRequest> eligibleDriverListWithRating = new ArrayList<>();
        List<DriverRequest> eligibleDriverListPrevious = new ArrayList<>();
        for(int i =0;i<driverRequest.size();i++){
            String driverName = driverRequest.get(i).getName();
            double driverRating = Util.findDriverRating(passengerRepository,driverName);
            if(driverRating>=passengerRating){
                eligibleDriverListWithRating.add(driverRequest.get(i));
            }
            boolean f = Util.hasPrevious(driverName,passenger,passengerRepository);
            if(f==true)
                eligibleDriverListPrevious.add(driverRequest.get(i));
        }

        if(eligibleDriverListWithRating.size()>=0){                 // case 1 condition if point 1 satisfied
            result = help(eligibleDriverListWithRating,x_cord,y_cord);
        }else{                                                      //case 2 if point 1 is not satisified
            result = help(eligibleDriverListPrevious,x_cord,y_cord);

        }

        Iterator<String> iterator = result.keySet().iterator();
        String finalDriverName = ((Iterator<?>) iterator).hasNext() ? iterator.next() : "";
        double finalDriverAvgRating = Util.findDriverRating(passengerRepository,finalDriverName);
        Integer finalDistance = result.get(finalDriverName);

        System.out.println("Average rating:- "+passengerRating);
        System.out.println("Eligible Drivers:- "+finalDriverName+" , "+finalDriverAvgRating);
        System.out.println("Eligible driver by distance:- "+finalDriverName+" , "+finalDistance);
    }
}
