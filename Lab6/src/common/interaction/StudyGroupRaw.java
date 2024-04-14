package common.interaction;

import common.data.Coordinates;
import common.data.Semester;
import common.data.Person;


import java.io.Serializable;
import java.util.Objects;

/**
 * Class for get Organization value.
 */
public class StudyGroupRaw implements Serializable {
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final Long studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    private final long transferredStudents; //Значение поля должно быть больше 0
    private final Long averageMark; //Значение поля должно быть больше 0, Поле может быть null
    private final Semester semesterEnum; //Поле не может быть null
    private final Person groupAdmin; //Поле не может быть null


    public StudyGroupRaw(String name, Coordinates coordinates, Long studentsCount, long transferredStudents,
                         Long averageMark, Semester semesterEnum, Person groupAdmin) {
        this.name = name;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.transferredStudents = transferredStudents;
        this.averageMark = averageMark;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public long getTransferredStudents() {
        return transferredStudents;
    }

    public Long getAverageMark() {
        return averageMark;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    @Override
    public String toString() {
        return "StudyGroupRaw{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", studentsCount=" + studentsCount +
                ", transferredStudents=" + transferredStudents +
                ", averageMark=" + averageMark +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyGroupRaw that = (StudyGroupRaw) o;
        return transferredStudents == that.transferredStudents && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(studentsCount, that.studentsCount) && Objects.equals(averageMark, that.averageMark) && semesterEnum == that.semesterEnum && Objects.equals(groupAdmin, that.groupAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, coordinates, studentsCount, transferredStudents, averageMark, semesterEnum, groupAdmin);
    }
}