package model;
public class FixSlot{
    private int id;
    private String Note;
    public FixSlot(){}
    public FixSlot(int id, String note) {
        this.id = id;
        Note = note;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
