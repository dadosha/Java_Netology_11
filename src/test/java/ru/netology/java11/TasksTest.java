package ru.netology.java11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TasksTest {
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка 4",
            "Во вторник после обеда"
    );

    @ParameterizedTest
    @CsvSource({
            "о,true",
            "4,false",
    })
    public void TestSearchSimpleTest(String equals, boolean expected) {

        boolean actual = simpleTask.matches(equals);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "о,true",
            "4,false",
    })
    public void TestSearchEpic(String equals, boolean expected) {

        boolean actual = epic.matches(equals);
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "о,true",
            "4,true",
            "5,false",
    })
    public void TestSearchMeeting(String equals, boolean expected) {

        boolean actual = meeting.matches(equals);
        Assertions.assertEquals(expected, actual);
    }
}
