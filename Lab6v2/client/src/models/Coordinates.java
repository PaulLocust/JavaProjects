package models;

import utility.Validatable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Этот класс показывает расположение StudyGroup на оси координат x и y
 */
public class Coordinates implements Validatable, Serializable {
    private long x;
    private Double y; //Максимальное значение поля: 849, Поле не может быть null

    public Coordinates(long x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean validate() {
        return y != null && y <= 849;
    }

    /**
     * Получить координату x
     * @return значение координаты x
     */
    public long getX() {
        return x;
    }

    /**
     * Установить координату x
     * @param x coordinate x
     */
    public void setX(long x) {
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
     * Метод для преобразования полей класса Coordinates в удобную для чтения строку
     * @return Строку из полей Coordinates
     */
    @Override
    public String toString() {
        return "Coordinates: " +
                "x = " + x +
                ", y = " + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


}
