package HomeWork4.Task4_1;

/**
 * Created by gaara on 4/24/17.
 */
public class Computer implements Comparable <Computer>  {
    private String model;
    private int coreCount;

    public Computer(String model, int coreCount) {
        setModel(model);
        setCoreCount(coreCount);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "model='" + model + '\'' +
                ", coreCount=" + coreCount +
                '}';
    }


    @Override
    public int compareTo(Computer o) {
        return this.getCoreCount() - o.getCoreCount() == 0 ? this.getModel().compareTo(o.getModel())
                : this.getCoreCount() - o.getCoreCount();
    }
}
