public class SubTask {
    private String description;
    private boolean finished;

    public SubTask(String description, boolean finished) {
        this.description = description;
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
