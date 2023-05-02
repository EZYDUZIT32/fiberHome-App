package Model;

public class AdminOrders
{
    private String firstname, secondname, phone, email, location, residence, mbps, date, time;

    public AdminOrders() {
    }

    public AdminOrders(String firstname, String secondname, String phone, String email, String location, String residence, String mbps,String date,String time) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.phone = phone;
        this.email = email;
        this.location = location;
        this.residence = residence;
        this.mbps = mbps;
        this.date = date;
        this.time = time;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getMbps() {
        return mbps;
    }

    public void setMbps(String mbps) {
        this.mbps = mbps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
