package Shopping;

public class UserInfo {
    private String name;
    private String emailAddress;
    private String phoneNumber;
    Address address ;


    public UserInfo(String name, String emailAddress, String phoneNumber, Address address) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public UserInfo(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
    }

    public void getCustomerInfo() {
        System.out.println(this.name +" "+this.emailAddress+" "+this.phoneNumber+this.address);
    }
    public void getSellerInfo() {
        System.out.println(this.name +" "+this.emailAddress);
    }
    public void getGuestInfo() {
        System.out.println(this.name+" ");
    }





    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

}