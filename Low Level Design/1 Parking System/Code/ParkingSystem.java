import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


class UserDetails {

    String userName;
    String vehicleNumber;
    Date entryTime;
    Date exitTime;

    Integer amount;

    public UserDetails(String userName, String vehicleNumber, Date entryTime) {

        this.userName = userName;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
    }

    public void setExitTime(Date exitTime){
        this.exitTime = exitTime;
    }

    public long getBill() {

        // Charging Rupees 50 per hour

        long differenceInMilliSecs = Math.abs(exitTime.getTime() - entryTime.getTime());
        long hours = (differenceInMilliSecs / (60 * 60 * 1000)) % 24;

        long amount = 50 * hours;

        if(amount == 0){
            return 10;
        }
        else{
            return amount;
        }

    }
    
}

public class ParkingSystem {


    public HashMap<String, String> userDetails;

    public static void main(String[] args) {

        System.out.println(" ==== Parking is Open ====");
        System.out.println("\nHere are the availability details");

        System.out.println("TOTAL SEDAN SLOTS = " + ParkingFloor.slots_SEDAN + "\nFREE SEDAN SLOTS = " + ParkingFloor.free_SEDAN);
        System.out.println("\nTOTAL SUV SLOTS = " + ParkingFloor.slots_SUV + "\nFREE SEDAN SLOTS = " + ParkingFloor.free_SUV);
        System.out.println("\nTOTAL HATCHBACK SLOTS = " + ParkingFloor.slots_HATCHBACK + "\nFREE SEDAN SLOTS = " + ParkingFloor.free_HATCHBACK);
        System.out.println("\nTOTAL TWO WHEELER = " + ParkingFloor.slots_TWO_WHEELER + "\nFREE SEDAN SLOTS = " + ParkingFloor.free_TWO_WHEELER);


        // Parking lot will close if admin manually closes it (ctrl + c)
        // or we reach some time limit
        // Usually parking lots close at night, for simplicity I am closing it in 1 minute (if no acitvity)

        ParkingFloor floor = new ParkingFloor();

        while(true) {

            System.out.println("\nWelcome, please enter your vehicle details");
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter Vehicle Number");
            String v_number = sc.next();

            System.out.println("Enter Vehicle Type, based on following choices -  SEDAN, HATCHBACK, SUV, TWO_WHEELER");
            String vType = sc.next();

            sc.close();

            Vehicle v = new Vehicle(v_number, Type.valueOf(vType));

            System.out.println("Checking availability of slot, please wait ... ");
            
            if(floor.isFree(v.getType()) == true){

                System.out.println("Available, Entering user");


            }
            else{
                System.out.println("Sorry, no space");
            }
            


        }
    }
}
