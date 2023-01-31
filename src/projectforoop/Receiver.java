package projectforoop;

public class Receiver extends Person {
    private int quantity;
    
    
    public Receiver(String name, String contactNumber, String bloodType, int quantity) {
        super(name,contactNumber, bloodType);
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return super.toString() + " " + quantity;
    }
    
    
}
