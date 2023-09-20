package CSD201_3;

public class Person {

    private int STT;
    private String name;
    private String job;

    public Person() {
    }

    public Person(int STT, String name, String job) {
        this.STT = STT;
        this.name = name;
        this.job = job;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
