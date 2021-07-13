import java.util.List;

class ParkingLot{

    // Parking Lot has multiple floors
    List<ParkingFloor> parking_Floors;

    // Parking Lot has multiple entry and exits
    List<ParkingEntry> parking_entries;
    List<ParkingExit> parking_exits;

}

class ParkingFloor {
    
    Integer floor_id;

    // Each floor has used slots, vacant slots, but this is a little complex
    // Why, it will be different for each kind of vehicle
    ParkingSpace space;
}

class ParkingSpace{

    Integer space_id;

    Integer total_sedan;
    Integer vacant_sedan;

    Integer total_suv;
    Integer vacant_suv;

    Integer total_bike;
    Integer vacant_bike;
}