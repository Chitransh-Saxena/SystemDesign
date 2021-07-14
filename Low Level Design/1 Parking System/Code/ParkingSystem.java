import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class UserDetails {

    public static final long RATE_PER_HOUR = 50;
    public static final long MIN_COST = 10; 

    Type vType;
    Date entryTime;
    Date exitTime;

    Integer amount;

    public UserDetails(Type vType, Date entryTime) {

        this.vType = vType;
        this.entryTime = entryTime;
    }

    public void setExitTime(Date exitTime){
        this.exitTime = exitTime;
    }

    public boolean isUserPresent(){
        if(exitTime != null) {
            return false;
        }
        else {
            return true;
        }
    }


    public long getBill() throws Exception {

        if(exitTime == null) {
            throw new Exception("Set the exit time for user\n");
        }


        long differenceInMilliSecs = Math.abs(exitTime.getTime() - entryTime.getTime());
        long hours = (differenceInMilliSecs / (60 * 60 * 1000)) % 24;

        long amount = RATE_PER_HOUR * hours;

        if(amount == 0){
            return MIN_COST;
        }
        else{
            return amount;
        }

    }
}

public class ParkingSystem {


    public static HashMap<String, UserDetails> userMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(" ==== Parking is Open ====");
        System.out.println("\nHere are the availability details");

        showParkingMetrics();


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
                makeVehicleEntry(v, floor);

            }
            else{
                System.out.println("Sorry, no space");
            }

        }
    }

    private static void makeVehicleEntry(Vehicle v, ParkingFloor floor) {

        if(checkIfUserIsInside(v.getV_number())) {

            System.out.println("\n\n*****Car with same number is already present, did you steal the vehicle and change the number or what?****\n");
        }
        else{
            Date now = new Date();
            UserDetails user = new UserDetails(v.getType(), now);
            userMap.put(v.getV_number(), user);

            floor.putVehicle(v);
            showParkingMetrics();
        }
    }

    private static void showParkingMetrics() {

        System.out.println("TOTAL SEDAN SLOTS = " + ParkingFloor.slots_SEDAN + "\nFREE SEDAN SLOTS = " + ParkingFloor.free_SEDAN);
        System.out.println("\nTOTAL SUV SLOTS = " + ParkingFloor.slots_SUV + "\nFREE SUV SLOTS = " + ParkingFloor.free_SUV);
        System.out.println("\nTOTAL HATCHBACK SLOTS = " + ParkingFloor.slots_HATCHBACK + "\nFREE HATCHBACK SLOTS = " + ParkingFloor.free_HATCHBACK);
        System.out.println("\nTOTAL TWO WHEELER = " + ParkingFloor.slots_TWO_WHEELER + "\nFREE TWO WHEELER SLOTS = " + ParkingFloor.free_TWO_WHEELER);
    }

    private static boolean checkIfUserIsInside(String v_number) {

        if(userMap.containsKey(v_number)) {

            UserDetails user = userMap.get(v_number);
            return user.isUserPresent();
        }
        else{
            return false;
        }

    }
}
