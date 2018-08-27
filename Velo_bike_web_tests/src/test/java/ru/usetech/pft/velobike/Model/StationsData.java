package ru.usetech.pft.velobike.Model;

public class StationsData {
    private String id;
    private String freeElectricPlaces;
    private String freeOrdinaryPlaces;

    public StationsData(String id, String freeElectricPlaces, String freeOrdinaryPlaces) {
        this.id = id;
        this.freeElectricPlaces = freeElectricPlaces;
        this.freeOrdinaryPlaces = freeOrdinaryPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationsData that = (StationsData) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (freeElectricPlaces != null ? !freeElectricPlaces.equals(that.freeElectricPlaces) : that.freeElectricPlaces != null)
            return false;
        return freeOrdinaryPlaces != null ? freeOrdinaryPlaces.equals(that.freeOrdinaryPlaces) : that.freeOrdinaryPlaces == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (freeElectricPlaces != null ? freeElectricPlaces.hashCode() : 0);
        result = 31 * result + (freeOrdinaryPlaces != null ? freeOrdinaryPlaces.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StationsData{" +
                "id='" + id + '\'' +
                ", freeElectricPlaces='" + freeElectricPlaces + '\'' +
                ", freeOrdinaryPlaces='" + freeOrdinaryPlaces + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFreeElectricPlaces() {
        return freeElectricPlaces;
    }

    public void setFreeElectricPlaces(String freeElectricPlaces) {
        this.freeElectricPlaces = freeElectricPlaces;
    }

    public String getFreeOrdinaryPlaces() {
        return freeOrdinaryPlaces;
    }

    public void setFreeOrdinaryPlaces(String freeOrdinaryPlaces) {
        this.freeOrdinaryPlaces = freeOrdinaryPlaces;
    }
}
