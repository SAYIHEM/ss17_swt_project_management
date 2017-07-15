import java.util.List;

public class Adapter extends Project implements IProject {

    public Adapter(String name, String description, double rate) {
        super(name, description, rate);
    }

    @Override
    public void setTask(Task newTask) {

        if (newTask == null) throw new NullPointerException();

        this.mainTask = newTask;
    }

    @Override
    public double getDuration() {

        return this.mainTask.getTimeRequired();
    }

    @Override
    public long getTotalCost() {

        return this.mainTask.getCostEstimate();
    }

    @Override
    public List<Deliverable> getDeliverables() {

        return this.mainTask.allDeliverables();
    }
}
