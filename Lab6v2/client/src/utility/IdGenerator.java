package utility;

import models.StudyGroup;

import java.util.HashSet;

public class IdGenerator {
    private final HashSet<StudyGroup> studyGroupCollection;

    public IdGenerator(HashSet<StudyGroup> studyGroupCollection) {
        this.studyGroupCollection = studyGroupCollection;
    }

    /**
     * Генерация нового id, выбирается наибольший существующий id и добавляется 1.
     * @return id учебной группы, которая была только что создана. Если коллекция пуста, то возвращается 0
     */
    public int generateNewIdForCollection(){
        if (studyGroupCollection.isEmpty()) return 1;
        else return
                studyGroupCollection.stream()
                        .mapToInt(StudyGroup::getId)
                        .filter(studyGroup -> studyGroup >= 0)
                        .max()
                        .orElse(0) + 1;
    }
}
