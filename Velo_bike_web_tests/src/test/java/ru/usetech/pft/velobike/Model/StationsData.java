package ru.usetech.pft.velobike.Model;

public class StationsData {
    private int id;
    private int freeElectricPlaces;
    private int freeOrdinaryPlaces;

    public StationsData(int id, int freeElectricPlaces, int freeOrdinaryPlaces) {
        this.id = id;
        this.freeElectricPlaces = freeElectricPlaces;
        this.freeOrdinaryPlaces = freeOrdinaryPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationsData that = (StationsData) o;

        if (id != that.id) return false;
        if (freeElectricPlaces != that.freeElectricPlaces) return false;
        return freeOrdinaryPlaces == that.freeOrdinaryPlaces;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + freeElectricPlaces;
        result = 31 * result + freeOrdinaryPlaces;
        return result;
    }

    @Override
    public String toString() {
        return "StationsData{" +
                "id=" + id +
                ", freeElectricPlaces=" + freeElectricPlaces +
                ", freeOrdinaryPlaces=" + freeOrdinaryPlaces +
                '}';
    }

    public int  getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }

    public int  getFreeElectricPlaces() {
        return freeElectricPlaces;
    }

    public void setFreeElectricPlaces(int  freeElectricPlaces) {
        this.freeElectricPlaces = freeElectricPlaces;
    }

    public int  getFreeOrdinaryPlaces() {
        return freeOrdinaryPlaces;
    }

    public void setFreeOrdinaryPlaces(int  freeOrdinaryPlaces) {
        this.freeOrdinaryPlaces = freeOrdinaryPlaces;
    }
}
