public class Pair {
    String invId;
    StringBuilder sb;
    double subTotal = 0;
    double Tax = 0;
    double discount = 0;
    double Total = 0;

    public StringBuilder getSb(){
        return this.sb;
    }
    public double getTotal(){
        return this.Total;
    }
    public double getSubTotal(){
        return this.subTotal;
    }
    public String getInvId(){
        return this.invId;
    }
    public double getTax(){
        return this.Tax;
    }
    public double getDiscount(){
        return this.discount;
    }
    public void setSb(StringBuilder sb){
        this.sb = sb;
    }
    public void setSubTotal(double subTotal){
        this.subTotal = subTotal;
    }
    public void setInvId(String invId){
        this.invId = invId;
    }
    public void setTax(double tax){
        this.Tax = tax; 
    }
    public void setDiscount(double discount){
        this.discount = discount;
    }
    public void setTotal(double total){
        this.Total = total;
    }


}
