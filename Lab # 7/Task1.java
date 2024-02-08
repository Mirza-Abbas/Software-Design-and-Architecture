abstract class AbstractScrollBar {
    public abstract void ScrollUp();

    public abstract void ScrollDown();
}

class MotifScrollBar extends AbstractScrollBar{ 
    MotifScrollBar (String arg) {
        System.out.println("Hello! " + arg);
    }

    public void ScrollUp() {};
    public void ScrollDown() {};

} 

class PMScrollBar extends AbstractScrollBar {
    PMScrollBar (String arg) {
        System.out.println("Hello! " + arg);
    }

    public void ScrollUp() {};
    public void ScrollDown() {};
}

abstract class AbstractWindow {
    public abstract void WindowOpen(); 
    public abstract void WindowClose ();
}

class MotifWindow extends AbstractWindow {
    MotifWindow (String arg) {
        System.out.println("Hello! " + arg);
    }

    public void WindowOpen() {};
    public void WindowClose() {};
}

class PMWindow extends AbstractWindow {
    PMWindow (String arg) {
        System.out.println("Hello! " + arg);
    }

    public void WindowOpen() {};
    public void WindowClose() {};
}

abstract class WidgetFactory {
    abstract AbstractScrollBar createScrollBar();

    abstract AbstractWindow createWindow();
}

class MotifWidgetFactory extends WidgetFactory {
    AbstractScrollBar createScrollBar() {
        return new MotifScrollBar("MotifScrollBar Created");
    }

    AbstractWindow createWindow() {
        return new MotifWindow ("MotifWindow Created");
    }
}

class PMWidgetFactory extends WidgetFactory {
    AbstractScrollBar createScrollBar() {
        return new PMScrollBar("PMScrollBar Created");
    }

    AbstractWindow createWindow() {
        return new PMWindow ("PMWindow Created");
    }
}

class FactoryMaker{
    private static WidgetFactory pf = null;

    static WidgetFactory getFactory(String choice) {
        if (choice.equals("a")) {
            pf = new MotifWidgetFactory();
        } 
        else if (choice.equals("b")) {
            pf=new PMWidgetFactory();
        }
        return pf;
    }
}

//Client Class:
public class Task1{
    public static void main(String args[]){
        WidgetFactory pf=FactoryMaker.getFactory("a"); 
        AbstractScrollBar product=pf.createScrollBar();

    }
}