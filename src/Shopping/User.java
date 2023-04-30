package Shopping;

public abstract class User {
    protected UserInfo userInfo1;
    protected Address address;

    public abstract void getUserInfo();
    public abstract void welcomeMsg();
    public abstract void login(String userName, String password);


}