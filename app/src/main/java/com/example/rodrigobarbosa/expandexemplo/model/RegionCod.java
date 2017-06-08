package com.example.rodrigobarbosa.expandexemplo.model;

/**
 * Created by rodrigobarbosa on 08/06/17.
 */

public class RegionCod {

    private long zoneId;
    private String zoneName;
    private long regionId;
    private String regionName;
    private boolean checkd;

    public long getZoneId() {
        return zoneId;
    }

    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public boolean isCheckd() {
        return checkd;
    }

    public void setCheckd(boolean checkd) {
        this.checkd = checkd;
    }
}
