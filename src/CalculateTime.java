import java.util.Scanner;

public class CalculateTime {




    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select Customer from C1 C2 C3 C4: ");
        String customer = scanner.next(); // Selected Customer
        CalculateDistanceAndTime cr = new CalculateDistanceAndTime();
        Customer selctedCustomer = cr.chooseCustomer(customer);
        Double distance = cr.selectStoreAndDroneDepo(selctedCustomer);
        Double time = (distance/60)*60;
        System.out.println("Time Taken for the drone to Deliver to Customer " + customer+ "is " + time+ " Minutes");



    }


}
