import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

interface TraversalAbstraction{
    Object first();
    Object next();
    boolean isDone();
}

interface Collection {
    TraversalAbstraction createTraversalObject();
}

class ListCollection implements Collection {
    private List<Object> list;

    public ListCollection(List<Object> list) {
        this.list = list;
    }

    public TraversalAbstraction createTraversalObject() {
        return new ListTraversal(list);
    }
}

class MapCollection implements Collection {
    private Map<Object, Object> map;

    public MapCollection(Map<Object, Object> map) {
        this.map = map;
    }

    public TraversalAbstraction createTraversalObject() {
        return new MapTraversal(map);
    }
}

class ListTraversal implements TraversalAbstraction {
    private List<Object> list;
    private int index;

    public ListTraversal(List<Object> list) {
        this.list = list;
        this.index = 0;
    }
    
    public Object first() {
        return null;
    }

    public Object next() {
        return list.get(index++);
    }

    public boolean isDone() {
        return index >= list.size();
    }
}

class MapTraversal implements TraversalAbstraction {
    private Map<Object, Object> map;
    private Iterator <Object> iterator;

    public MapTraversal(Map<Object, Object> map) {
        this.map = map;
        this.iterator = map.keySet().iterator();
    }
    
    public Object first() {
        return null;
    }
    
    public Object next() {
        Object key = iterator.next();
        return map.get(key);
    }

    public boolean isDone() {
        return !iterator.hasNext();
    }
}

class Task1 {
    public static void main(String[] args) {
        List<Object> MyList = new ArrayList<>();

        MyList.add("Pakistan");
        MyList.add("United States");
        MyList.add("India");

        Collection MylistCollection = new ListCollection(MyList);

        TraversalAbstraction listTraversalObject = MylistCollection.createTraversalObject();
        
        while (!listTraversalObject.isDone()) {
            Object element = listTraversalObject.next();
            System.out.println(element);
        }

        Map<Object, Object> MyMap = new HashMap<>();

        MyMap.put("Pakistan", "Islamabad");
        MyMap.put("United States", "Washington");
        MyMap.put("India", "Dehli");

        Collection mapCollection = new MapCollection(MyMap);

        TraversalAbstraction mapTraversalObject = mapCollection.createTraversalObject();
        while (!mapTraversalObject.isDone()) {
            Object element = mapTraversalObject.next();
            System.out.println(element);
        }
    }
}