package ru.netology.java11;

public class Epic extends Task {
    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public boolean matches(String query) {
        for (String task : subtasks) {
            if (task.contains(query)) {
                return true;
            }
        }
        return false;
    }
}