
package Shopping;
    public class Address {
        private int userId;
        private int addressId;
        private String streetAddress;
        private String city;
        private String state;
        private int zip;
        //custom constructor
        public Address(int addressId, int userId) {
            this.addressId = addressId;
            this.userId = userId;
        }
        //setter for setting address
        public void setAddress(String streetAddress, String city, String state, int zip) {
            this.streetAddress = streetAddress;
            this.city = city;
            this.state = state;
            this.zip = zip;
        }
        // getter for getting address
        public String getAddress() {
            return this.addressId+"  "+this.streetAddress +","+ this.city +","+  this.state +","+ this.zip;
        }
        // getter for userId
        public int getUserId() {
            return userId;
        }
        //setter for userId
        public void setUserId(int userId) {
            this.userId = userId;
        }
    }

