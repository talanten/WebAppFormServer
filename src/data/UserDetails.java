package data;

import com.google.gson.JsonObject;

public class UserDetails {
    String firstName = "";
    String lastName = "";
    String email = "";
    String address = "";
    String phone = ""; 
    
    public UserDetails(String firstName, String lastName, String email, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
    
    public UserDetails(JsonObject obj) {
        this.firstName = obj.get("firstName").getAsString();
        this.lastName = obj.get("lastName").getAsString();
        this.email = obj.get("email").getAsString();
        this.address = obj.get("address").getAsString();
        this.phone = obj.get("phone").getAsString();
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return
                "fname: " + this.firstName + "\n" +
                "lname: " + this.lastName + "\n" +
                "email: " + this.email + "\n" +
                "addre: " + this.address + "\n" +
                "phone: " + this.phone + "\n"; 
    }
    

}
