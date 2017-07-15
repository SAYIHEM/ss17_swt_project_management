import java.util.ArrayList;
import java.util.List;

public class Task extends ProjectItem {

    private List<ProjectItem> projectItems;

    public Task(String name, String details, double rate) {
        super(name, details, rate);

        projectItems = new ArrayList<>();
    }

    @Override
    public double getTimeRequired() {

        double time = 0;

        for (ProjectItem item : this.projectItems) {

            time += item.getTimeRequired();
        }

        return time;
    }

    @Override
    public long getMaterialCost() {

        long cost = 0;

        for (ProjectItem item : this.projectItems) {

            cost += item.getMaterialCost();
        }

        return cost;
    }

    public void addProjectItem(ProjectItem pi) {

        if (pi == null) throw new NullPointerException();

        this.projectItems.add(pi);
    }

    public void removeProjectItem(ProjectItem pi) {

        if (pi == null) throw new NullPointerException();

        this.projectItems.remove(pi);
    }

    public List<Deliverable> allDeliverables() {

        List<Deliverable> deliverables = new ArrayList<>();

        for (ProjectItem item : this.projectItems) {

            if (item instanceof Deliverable) deliverables.add((Deliverable) item);
            if (item instanceof Task) deliverables.addAll(((Task) item).allDeliverables());
        }

        return deliverables;
    }


}
