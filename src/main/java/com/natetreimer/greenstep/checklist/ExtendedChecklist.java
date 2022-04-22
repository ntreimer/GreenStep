package com.natetreimer.greenstep.checklist;

public class ExtendedChecklist {
    private boolean completed;
    private Checklist checklist;
    public ExtendedChecklist() {
    }
    public ExtendedChecklist(boolean completed, Checklist checklist) {
        this.completed = completed;
        this.checklist = checklist;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public Checklist getChecklist() {
        return checklist;
    }
    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }
    @Override
    public String toString() {
        return "ExtendedChecklist{" +
                "completed=" + completed +
                ", checklist=" + checklist +
                '}';
    }
}