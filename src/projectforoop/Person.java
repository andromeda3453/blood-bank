package projectforoop;

public abstract class Person {
    private String bloodType;
    private String name;
    private String contactNumber;
    
    public Person(){
    
    }
    
    public Person(String name,String contactNumber, String bloodType) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.bloodType = bloodType;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getBloodType() {
        return bloodType;
    }
    
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
    @Override
    public String toString() {
        return name + " " + contactNumber + " " + bloodType;
    }
}
