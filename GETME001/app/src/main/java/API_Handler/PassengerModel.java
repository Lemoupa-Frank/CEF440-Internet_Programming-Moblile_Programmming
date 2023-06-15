package API_Handler;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassengerModel {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("pass_id")
    @Expose
    private int pass_id;

    // Constructors
    public PassengerModel(String username, String password, String contact, int pass_id) {
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.pass_id = pass_id;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getPassId() {
        return pass_id;
    }

    public void setPassId(int pass_id) {
        this.pass_id = pass_id;
    }
}
