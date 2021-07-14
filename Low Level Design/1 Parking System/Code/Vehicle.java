public class Vehicle {

    // Save vehicle details in order for system to ingest that
    private String v_number;
    private Type type;

    public Vehicle (String v_number, Type type){
        this.v_number = v_number;
        this.type = type;
    }

    
    

    /**
     * @return String return the v_number
     */
    public String getV_number() {
        return this.v_number;
    }


    /**
     * @return Type return the type
     */
    public Type getType() {
        return this.type;
    }

}
