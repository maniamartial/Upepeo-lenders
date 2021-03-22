
/**
 *
 * @author hp
 */
class members {
    private String firstname;
    private String lastname;
    private String username;
 
    private String email;
       private int phone;
    private String occupation;
    private String password;
    private String streetNo;
    private int PhoneNum;
        private String MembershipID;
    private String RegisteredDate;
    private String houseNum;

       public members(String firstname, String lastname, String password, String email, int phone, String occupation,  String MembershipID, 
                                                         String RegisteredDate, String username,  String streetNo, String houseNum) 
               
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.occupation = occupation;
        this.password = password;
        this.streetNo = streetNo;
     
        this.MembershipID = MembershipID;
        this.RegisteredDate = RegisteredDate;
        this.houseNum = houseNum;
    }
      // public members(String firstname, String lastname, String password, String email, int phone, String occupation,  String MembershipID, )

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getPassword() {
        return password;
    }

    public String getStreetNo() {
        return streetNo;
    
    }

    public String getMembershipID() {
        return MembershipID;
    }

    public String getRegisteredDate() {
        return RegisteredDate;
    }

    public String getHouseNum() {
        return houseNum;
    }
    

}