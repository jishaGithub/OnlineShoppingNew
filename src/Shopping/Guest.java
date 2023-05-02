package Shopping;
public class Guest extends User{
    private int guestId;
    private  String userName;
    private  String password;

    public Guest(int guestId, String userName,String password) {
        this.guestId = guestId;
        this.setUserName(userName);
        this.password = password;
    }


    @Override
    public void getUserInfo() {
        super.getGuestInfo();
    }

    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to guest portal");
    }

    @Override
    public void login(String userName, String password) throws SameValueException {
        if(userName==password){
            throw new SameValueException("The username and password cannot be same");
        }
        if(userName.equals(this.getUserName())&&(password.equals(this.getPassword()))) {
            System.out.println(this.getUserName()+" logged in successfully");
        }
        else {
            System.out.println("Try again");
        }

    }

    public void setAddress(int addressId,String streetAddress, String city, String state, int zip) throws NotValidZipException {
        super.setAddressUser(addressId,streetAddress,city,state,zip);
    }
    public void registerUser(String name, String emailAddress, String phoneNumber){
        super.setUserInfo(name,emailAddress,phoneNumber, address);
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}