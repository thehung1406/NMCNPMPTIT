package model;

public class Technician {
    private int id;
    private String name;
    private String Note;
    public Technician() {}
    public Technician(int id, String name, String note) {
        this.id = id;
        this.name = name;
        Note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
