package models;

import utility.Validatable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Этот класс показывает расположения экземпляра класса Person в пространстве
 */
public class Location implements Validatable, Serializable {
    private Double x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private Long z; //Поле не может быть null
    private String name; //Поле может быть null

    public Location(Double x, Double y, long z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    @Override
    public boolean validate() {
        return (x != null) && (y != null) && (z != null);
    }

    /**
     * Получить координату x
     * @return значение координаты x
     */
    public Double getX() {
        return x;
    }

    /**
     * Установить координату x
     * @param x coordinate x
     */
    public void setX(Double x) {
        this.x = x;
    }

    /**
     * Получить координату y
     * @return значение координаты y
     */
    public Double getY() {
        return y;
    }

    /**
     * Установить координату y
     * @param y coordinate y
     */
    public void setY(Double y) {
        this.y = y;
    }

    /**
     * Получить координату z
     * @return значение координаты z
     */
    public Long getZ() {
        return z;
    }

    /**
     * Установить координату z
     * @param z coordinate z
     */
    public void setZ(Long z) {
        this.z = z;
    }

    /**
     * Получить имя локации
     * @return значение поля name
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя локации
     * @param name location's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Преобразование полей класса Location в строку
     * @return Location.toString()
     */
    @Override
    public String toString() {
        return "Location: " +
                "x = " + x +
                ", y = " + y +
                ", z = " + z +
                ", name = '" + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(x, location.x) && Objects.equals(y, location.y) && Objects.equals(z, location.z) && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }
}
