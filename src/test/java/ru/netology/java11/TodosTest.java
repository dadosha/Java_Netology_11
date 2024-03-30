package ru.netology.java11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodosTest {
    Todos todos = new Todos();
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestAllTaskSearch() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("о");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestZeroTaskSearch() {

        Task[] expected = {};
        Task[] actual = todos.search("45345");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestOneTaskSearch() {

        Task[] expected = {meeting};
        Task[] actual = todos.search("3");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestFewTaskSearch() {
        SimpleTask simpleTask2 = new SimpleTask(15, "Несколько задач");

        String[] subtasks2 = {"Несколько задач", "Яйца", "Хлеб"};
        Epic epic2 = new Epic(155, subtasks2);

        todos.add(simpleTask2);
        todos.add(epic2);

        Task[] expected = {simpleTask2, epic2};
        Task[] actual = todos.search("Несколько задач");
        Assertions.assertArrayEquals(expected, actual);
    }
}