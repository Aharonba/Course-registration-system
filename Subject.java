
public interface Subject {

    public void addObserver(CourseObserver observer);

    public void removeObserver(CourseObserver observer);

    public void notifyObservers();
}
