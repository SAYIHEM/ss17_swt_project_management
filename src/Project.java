import java.util.*;

public class Project {

    protected String name;
    protected String description;
    protected Task mainTask;

    public Project(String name, String description, double rate) {

        if (name == null) throw new NullPointerException();
        if (description == null) throw new NullPointerException();

        if (name.isEmpty()) throw new IllegalArgumentException();
        if (description.isEmpty()) throw new IllegalArgumentException();
        if (rate <= 0) throw new IllegalArgumentException();

        this.name = name;
        this.description = description;
        this.mainTask = new Task(name, description, rate);
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public void setTask(Task newTask) {

        if (newTask == null) throw new NullPointerException();

        this.mainTask = newTask;
    }

    public double getDuration() {

        return this.mainTask.getTimeRequired();
    }

    public long getTotalCost() {

        return this.mainTask.getCostEstimate();
    }

    public Map<Calendar, List<Deliverable>> allDeliverables() {

        Map<Calendar, List<Deliverable>> deliverableMap = new HashMap<>();

        for (Deliverable deliverable : this.mainTask.allDeliverables()) {

            List<Deliverable> list;

            if (deliverableMap.containsKey(deliverable.getDate())) {

                list = deliverableMap.get(deliverable.getDate());

                list.add(deliverable);
                deliverableMap.replace(deliverable.getDate(), list);

            } else {

                list = new ArrayList<>();
                list.add(deliverable);

                deliverableMap.put(deliverable.getDate(), list);
            }
        }

        return deliverableMap;
    }
}
