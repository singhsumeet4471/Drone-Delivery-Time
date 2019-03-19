import java.util.*;

public class CalculateDistanceAndTime {

    public double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c ;

        double height = 0.0;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public Customer chooseCustomer(String choice){

        switch(choice){
            case "C1":
                Customer c1 = new Customer(51.211729,6.770123);
                return c1;
            case "C2":
                Customer c2 = new Customer(51.235204,6.778520);
                return c2;
            case "C3":
                Customer c3 = new Customer(51.229462,6.746983);
                return c3;
            case "C4":
                Customer c4 = new Customer(51.208141,6.831176);
                return c4;
        }

        return null;

    }


    public Double selectStoreAndDroneDepo(Customer cust){

//        double custLat = cust.getLatitude();
//        double custlan = cust.getLongitude();

        Store s1 = new Store(51.237558,6.720090);
        Store s2 = new Store(51.208895,6.778425);
        Store s3 = new Store(51.202364,6.717797);
        Store s4 = new Store(51.231328,6.684919);
        Store s5 = new Store(51.296623,6.831402);

        List<Store> store = new ArrayList<>();
        store.addAll(Arrays.asList(s1, s2, s3, s4, s5));


        DroneDepo d1 = new DroneDepo(51.235127,6.825511);
        DroneDepo d2 = new DroneDepo(51.236912,6.723876);

        List<DroneDepo> droneDepo = new ArrayList<>();
        droneDepo.addAll(Arrays.asList(d1, d2));

        HashMap<Store,Double> distanceStore = new HashMap<>();

        for(Store element : store) {
            distanceStore.put(element,distance(cust.getLatitude(),element.getLatitude(),cust.getLongitude(),element.getLongitude()));
        }

        Double minDistancStore = Collections.min(distanceStore.values());
        Double selectedStroreLat = 0.0;
        Double selectedStroreLan = 0.0;

        for (Map.Entry<Store, Double> entry : distanceStore.entrySet()) {
            if (minDistancStore.equals(entry.getValue())) {
                selectedStroreLat = entry.getKey().getLatitude();
                selectedStroreLan = entry.getKey().getLongitude();
            }
        }


        HashMap<DroneDepo,Double> distancedepo = new HashMap<>();

        for(Store element : store) {
            distanceStore.put(element,distance(selectedStroreLat,element.getLatitude(),selectedStroreLan,element.getLongitude()));
        }

        Double minDistancDroneDepo = Collections.min(distanceStore.values());


        return (minDistancStore + minDistancDroneDepo);


    }


}
