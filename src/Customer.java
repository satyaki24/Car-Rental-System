public class Customer {
    private String custName;
    private String custId;

    public Customer(String custName, String custId){
        this.custId=custId;
        this.custName=custName;
    }

    public String getCustName(){
        return custName;
    }

    public String getCustId(){
        return custId;
    }
}
