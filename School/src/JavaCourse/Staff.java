package JavaCourse;

public abstract class Staff<T> {
    private String status, name, surName;
    private long salary;

    public Staff(String status, String name, String surname) {
        this.status = status; this.name = name; this.surName = surname;
    }

    abstract void setSalary(long amount);

    public long getSalary() {
        return salary;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
