package API_Handler;

import com.google.gson.annotations.SerializedName;

public class responsemodel {
    @SerializedName("D1name")
    private String d1name;

    @SerializedName("D1long")
    private double d1long;

    @SerializedName("D1lat")
    private double d1lat;

    @SerializedName("D2name")
    private String d2name;

    @SerializedName("D2long")
    private double d2long;

    @SerializedName("D2lat")
    private double d2lat;

    @SerializedName("D3name")
    private String d3name;

    @SerializedName("D3long")
    private double d3long;

    @SerializedName("D3lat")
    private double d3lat;

    public String getD1Name() {
        return d1name;
    }

    public double getD1Long() {
        return d1long;
    }

    public double getD1Lat() {
        return d1lat;
    }

    public String getD2Name() {
        return d2name;
    }

    public double getD2Long() {
        return d2long;
    }

    public double getD2Lat() {
        return d2lat;
    }

    public String getD3Name() {
        return d3name;
    }

    public double getD3Long() {
        return d3long;
    }

    public double getD3Lat() {
        return d3lat;
    }
}
