public class ParkingFloor {
    
    // All these 8 fields will be static because they are gonna be relative to all instances of a floor (we are not gonna have many instances though)
    public static final Integer slots_SUV = 50;
    public static final Integer slots_HATCHBACK = 50;
    public static final Integer slots_SEDAN = 50;
    public static final Integer slots_TWO_WHEELER = 50;

    public static Integer free_SUV = 50;
    public static Integer free_HATCHBACK = 50;
    public static Integer free_SEDAN = 50;
    public static Integer free_TWO_WHEELER = 50;

    
    public void putVehicle(Vehicle vehicle){

        System.out.println("Entering car " + vehicle.getV_number());

        Type t = vehicle.getType();
        switch(t) {
            case HATCHBACK:
                free_HATCHBACK-=1;
                break;
            case SEDAN:
                free_SEDAN-=1;
                break;
            case SUV:
                free_SUV-=1;
                break;
            case TWO_WHEELER:
                free_TWO_WHEELER-=1;
                break;
            default:
                break;

        }
    }

    public void getVehicle(Vehicle vehicle){

        System.out.println("Exiting vehicle " + vehicle.getV_number());

        Type t = vehicle.getType();
        switch(t) {
            case HATCHBACK:
                free_HATCHBACK+=1;
                break;
            case SEDAN:
                free_SEDAN+=1;
                break;
            case SUV:
                free_SUV+=1;
                break;
            case TWO_WHEELER:
                free_TWO_WHEELER+=1;
                break;
            default:
                break;
        }
    }

    public boolean isFree(Type type){

        switch(type){

            case HATCHBACK:
                if(free_HATCHBACK > 2) {
                    return true;
                }
                return false;
            case SEDAN:
                if(free_SEDAN > 2) {
                    return true;
                }
                return false;
            case SUV:
                if(free_SUV > 2) {
                    return true;
                }
                return false;    

            case TWO_WHEELER:
                if(free_TWO_WHEELER > 2) {
                    return true;
                }
                return false;
     
            default:
                break;

        }

        return false;
    }

}
