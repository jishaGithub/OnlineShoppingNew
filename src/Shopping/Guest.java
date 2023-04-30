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
        userInfo1 = new UserInfo("Guest","guest@gmail.com");
        userInfo1.getCustomerInfo();

    }

    @Override
    public void welcomeMsg() {
        System.out.println("Welcome to guest portal");

    }

    @Override
    public void login(String userName, String password) {
        if(userName.equals(this.getUserName())&&(password.equals(this.getPassword()))) {
            System.out.println(this.getUserName()+" logged in successfully");
        }
        else {
            System.out.println("Try again");
        }

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