package hxz.myLeaseOfHouses;

public class HouseInformation {
    private static long pubId = 0; //8位
    private long Id;
    private String owner;
    private long phone;
    private String region;
    private double rent;
    private String state;

    public HouseInformation(String owner, long phone, String region, double rent, String state) {
        this.owner = owner;
        this.phone = phone;
        this.region = region;
        this.rent = rent;
        this.state = state;
        Id = ++pubId;
    }

    public String info() {
        String str0 = String.format("%-8s", Id);
        String str1 = String.format("%-6s", owner); //6个字符
        String str2 = String.format("%-12s", phone);
        String str3 = String.format("%-8s", region);
        String str4 = String.format("%.2f", rent);
        str4 = String.format("%-10s", str4);

        return str0 + str1 + str2 + str3 + str4 + state;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getId() {
        return Id;
    }
}
