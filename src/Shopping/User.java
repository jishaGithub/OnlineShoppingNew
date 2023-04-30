package Shopping;

public class User {
    private int userId;
    private String userName;
    private String password;
    private int addressId;
    //custom constructor
    public User(int userId, int addressId) {
        this.userId = userId;
        this.addressId = addressId;
    }
    //setter for login information
    public void setLoginCredentials(String userName,String password) {
        this.userName = userName;
        this.password = password;
    }
    //getter for userInfo
    public String getUserInformation() {
        return "UserId: "+this.userId + " UserName: "+this.userName +" Password: "+this.password;
    }
    //getter for userName
    public String getUserName() {
        return this.userName;
    }
    //getter for password
    public String getPassword() {
        return this.password;
    }
    // method for
    public int getAddressId() {

        return this.addressId;
    }





}
