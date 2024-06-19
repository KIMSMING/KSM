package rent.rentcar.models;

import java.sql.Date;

public class Rented {
    public Vehicle vehicle;
    public Member member;
    public Date startDate;
    public String startPoint;
    public Date endDate;
    public String endPoint;
    public int money;
    public Date rentDate;
    public Date returnDate;
    public Date brokenDate;
    public RentStatus status;
    public Reserved reserved;
}
