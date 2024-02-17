import java.util.ArrayList;

interface Subject {
    public String getState();

    public void setState(String state);

    public void registerObserver(Observer observer);

    public void notifyAllObservers();
}

class Blog implements Subject {
    private ArrayList <Observer> observers = new ArrayList<Observer>();
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

abstract class Observer {
    protected Subject Blog;

    public abstract void update();
}

class User extends Observer {
    public User (Subject subject) {
        this.Blog = subject;
        this.Blog.registerObserver(this);
    }

    public void update() {
        System.out.println(Blog.getState());
    }
}



public class Task1 {
    public static void main(String[] args) {
        Subject MyBlog = new Blog();

        User user1 = new User(MyBlog);
        
        MyBlog.setState("Vacation Blog");

        User user2 = new User(MyBlog);
        
        MyBlog.setState("Educational Trip Blog");
    }
}