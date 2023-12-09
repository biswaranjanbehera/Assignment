import model.Driver;
import model.DriverRequest;
import model.Passenger;
import repository.DriverRepository;
import repository.PassengerRepository;
import service.DriverService;
import service.PassengerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        DriverRepository driverRepository = new DriverRepository();
        DriverService driverService = new DriverService(driverRepository);
        PassengerRepository passengerRepository = new PassengerRepository();
        PassengerService passengerService = new PassengerService(passengerRepository,driverRepository);




        //Driver adding ---------------------------------------------------------------------------

        //-----driver d1 added-----------
        Map<String,Integer> passengerList = new HashMap<>();
        passengerList.put("c1",5);
        Driver d = new Driver("d1",passengerList);
        driverService.addDriver(d);

        Map<String,Integer> passengerList2 = new HashMap<>();
        passengerList2.put("c2",4);
        d = new Driver("d1",passengerList2);
        driverService.addDriver(d);

        Map<String,Integer> passengerList3 = new HashMap<>();
        passengerList3.put("c3",2);
        d = new Driver("d1",passengerList3);
        driverService.addDriver(d);
        //-------driver d2 added-----------
        Map<String,Integer> passengerList4 = new HashMap<>();
        passengerList4.put("c1",1);
        d = new Driver("d2",passengerList4);
        driverService.addDriver(d);

        Map<String,Integer> passengerList5 = new HashMap<>();
        passengerList5.put("c2",5);
        d = new Driver("d2",passengerList5);
        driverService.addDriver(d);

        Map<String,Integer> passengerList6 = new HashMap<>();
        passengerList6.put("c3",5);
        d = new Driver("d2",passengerList6);
        driverService.addDriver(d);
        //-------driver d3 added-----------
        Map<String,Integer> passengerList7 = new HashMap<>();
        passengerList7.put("c1",2);
        d = new Driver("d3",passengerList7);

        Map<String,Integer> passengerList8 = new HashMap<>();
        driverService.addDriver(d);
        passengerList8.put("c2",5);
        d = new Driver("d3",passengerList8);
        driverService.addDriver(d);

        Map<String,Integer> passengerList9 = new HashMap<>();
        passengerList9.put("c3",3);
        d = new Driver("d3",passengerList9);
        driverService.addDriver(d);


        //Passenger adding ---------------------------------------------------------------------------
        //-----passenger  added-----------
        Map<String,Integer> driverList1 = new HashMap<>();
        driverList1.put("d1",4);
        Passenger p = new Passenger("c1",driverList1);
        passengerService.addPassenger(p);

        Map<String,Integer> driverList2 = new HashMap<>();
        driverList2.put("d1",5);
        p = new Passenger("c2",driverList2);
        passengerService.addPassenger(p);

        Map<String,Integer> driverList3 = new HashMap<>();
        driverList3.put("d1",1);
        p = new Passenger("c3",driverList3);
        passengerService.addPassenger(p);
        //-----passenger  added-----------
        Map<String,Integer> driverList4 = new HashMap<>();
        driverList4.put("d2",5);
        p = new Passenger("c1",driverList4);
        passengerService.addPassenger(p);

        Map<String,Integer> driverList5 = new HashMap<>();
        driverList5.put("d2",5);
        p = new Passenger("c2",driverList5);
        passengerService.addPassenger(p);

        Map<String,Integer> driverList6= new HashMap<>();
        driverList6.put("d2",4);
        p = new Passenger("c3",driverList6);
        passengerService.addPassenger(p);
        //-----passenger  added-----------
        Map<String,Integer> driverList7 = new HashMap<>();
        driverList7.put("d3",3);
        p = new Passenger("c1",driverList7);
        passengerService.addPassenger(p);

        Map<String,Integer> driverList8 = new HashMap<>();
        driverList8.put("d3",4);
        p = new Passenger("c2",driverList8);
        passengerService.addPassenger(p);

        Map<String,Integer> driverList9 = new HashMap<>();
        driverList9.put("d3",3);
        p = new Passenger("c3",driverList9);
        passengerService.addPassenger(p);

        //Test cases------------------------
        DriverRequest driverRequest = new DriverRequest();
        List<DriverRequest> driverRequestsList = new ArrayList<>();
        driverRequest = new DriverRequest("d1",1,0);
        driverRequestsList.add(driverRequest);
        driverRequest = new DriverRequest("d2",2,0);
        driverRequestsList.add(driverRequest);
        driverRequest = new DriverRequest("d3",3,0);
        driverRequestsList.add(driverRequest);



        /*List<Driver>dr = driverRepository.getDriverList();
        for(int i=0;i<dr.size();i++){
            System.out.println(dr.get(i).getDriverName());
            System.out.println(dr.get(i).getPassengerList());
        }
        System.out.println("---------------");
        List<Passenger>pr = passengerRepository.getPassengerList();
        for(int i=0;i<pr.size();i++){
            System.out.println(pr.get(i).getPassengerName());
            System.out.println(pr.get(i).getDriverList());
        }*/

        System.out.println("----------------------------");
        passengerService.findNear(driverRequestsList,"c2",1,0);


    }
}
//DriverRepository has passenger list and passenger rating
//PassengerRepository has driver list and driver rating