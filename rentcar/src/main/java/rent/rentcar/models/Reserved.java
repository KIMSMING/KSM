package rent.rentcar.models;

import java.util.Date;

public class Reserved {
    public Vehicle vehicle;
    public Member member;
    public Date startDate;
    public String startPoint;
    public Date endDate;
    public String endPoint;
    public int money;
    public Date reserveDate;
    public Date untilDate;
    public Date returnDate;
    public Date cancelDate;
    public RentStatus status;

}
