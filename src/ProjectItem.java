public abstract class ProjectItem implements Comparable<Object> {

    protected String name;
    protected String details;
    protected double rate;

    public ProjectItem(String name, String details, double rate) {

        if (name == null) throw new NullPointerException();
        if (details == null) throw new NullPointerException();

        if (name.isEmpty()) throw new IllegalArgumentException();
        if (details.isEmpty()) throw new IllegalArgumentException();

        if (rate <= 0) throw new IllegalArgumentException();

        this.name = name;
        this.details = details;
        this.rate = rate;
    }

    public void setDetails(String newDetails) {

        if (newDetails == null) throw new NullPointerException();
        if (newDetails.isEmpty()) throw new IllegalArgumentException();

        this.details = newDetails;
    }

    public long getCostEstimate() {

        double timeCost = getTimeRequired() * rate;
        double totalCost = timeCost + getMaterialCost();

        return Math.round(totalCost);
    }

    public abstract double getTimeRequired();
    public abstract long getMaterialCost();

    @Override
    public boolean equals(Object o) {

        ProjectItem item;

        if (o instanceof ProjectItem) {

            item = (ProjectItem) o;

        } else {

            return false;
        }

        return this.name.equals(item.name);
    }

    @Override
    public int compareTo(Object o) {

        ProjectItem item;

        if (o instanceof ProjectItem) {

            item = (ProjectItem) o;
            return this.name.equals(item.name) ? 0 : -1;

        } else {

            return -1;
        }
    }
}
