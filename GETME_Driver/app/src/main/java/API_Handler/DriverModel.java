package API_Handler;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DriverModel {
    @SerializedName("Admin_id")
    @Expose
    public String adminId;

    @SerializedName("driver_licence")
    @Expose
    public String driverLicense;

    @SerializedName("FFpassword")
    @Expose
    public String ffPassword;

    @SerializedName("FF_nam")
    @Expose
    public String ffName;

    @SerializedName("Flatitudelocation")
    @Expose
    public double latitudeLocation;

    @SerializedName("Flongitudelocation")
    @Expose
    public double longitudeLocation;

    @SerializedName("FL_name")
    @Expose
    public String flName;

    @SerializedName("freelance_id")
    @Expose
    public String freelanceId;

    @SerializedName("plate_no")
    @Expose
    public String plateNo;

    @SerializedName("seats")
    @Expose
    public int seats;

    // Constructor
    public DriverModel(String adminId, String driverLicense, String ffPassword, String ffName,
                       double latitudeLocation, double longitudeLocation, String flName,
                       String freelanceId, String plateNo, int seats) {
        this.adminId = adminId;
        this.driverLicense = driverLicense;
        this.ffPassword = ffPassword;
        this.ffName = ffName;
        this.latitudeLocation = latitudeLocation;
        this.longitudeLocation = longitudeLocation;
        this.flName = flName;
        this.freelanceId = freelanceId;
        this.plateNo = plateNo;
        this.seats = seats;
    }

    // Getters and setters (optional)

    // Other methods and functionality can be added here
}
