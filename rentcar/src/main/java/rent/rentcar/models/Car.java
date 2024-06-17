package rent.rentcar.models;

public class Car implements Vehicle{
    private Long id;
    private String company;
    private String model;
    private int makeYear;
    private VehicleType type;
    private String color;
    private int totalKm;
    private String factoryNumber;
    private String registNumber;

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public String getCompany() {
        return "";
    }

    @Override
    public String getModel() {
        return "";
    }

    @Override
    public int getMakeYear() {
        return 0;
    }

    @Override
    public VehicleType getType() {
        return null;
    }

    @Override
    public String getColor() {
        return "";
    }

    @Override
    public int getTotalKM() {
        return 0;
    }

    @Override
    public String getFactoryNumber() {
        return "";
    }

    @Override
    public String getRegistNumber() {
        return "";
    }

    @Override
    public VehicleType getStatus() {
        return null;
    }

    @Override
    public String getDriver() {
        return "";
    }

    @Override
    public String reserve() {
        return "";
    }

    @Override
    public String cancel() {
        return "";
    }

    @Override
    public String rentVehicle() {
        return "";
    }

    @Override
    public String returnVehicle() {
        return "";
    }
}
