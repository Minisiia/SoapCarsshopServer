package soap_carsshop_server.entity;

public class Mark {
    private int id;
    private String mark;

    public Mark(int id, String mark) {
        this.id = id;
        this.mark = mark;
    }

    public Mark() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
