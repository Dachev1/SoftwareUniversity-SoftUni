package interfaces_and_abstraction.exercise.collection_hierarchy;

import interfaces_and_abstraction.exercise.collection_hierarchy.interfaces.AddRemovable;
import interfaces_and_abstraction.exercise.collection_hierarchy.interfaces.Addable;
import interfaces_and_abstraction.exercise.collection_hierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements Addable, AddRemovable, MyList {

    @Override
    public String remove() {
        return super.removeFirst();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.getItems().size();
    }
}