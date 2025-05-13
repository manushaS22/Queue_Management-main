public class Customer {

    private String FirstName;
    private String LastName;
    private int BurgersRequired;

    public Customer(String FirstName, String LastName, int BurgersRequired){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BurgersRequired = BurgersRequired;
    }



    public String getFirstName() {return FirstName;} //return Customers first name using this method

    public String getLastName() {return LastName;} //return Customers last name using this method

    public int getBurgersRequired() {return BurgersRequired;} // returning the customer required burger count




}