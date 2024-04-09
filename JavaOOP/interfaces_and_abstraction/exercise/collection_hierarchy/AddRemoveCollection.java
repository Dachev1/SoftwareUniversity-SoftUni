package interfaces_and_abstraction.exercise.collection_hierarchy;

import interfaces_and_abstraction.exercise.collection_hierarchy.interfaces.AddRemovable;
import interfaces_and_abstraction.exercise.collection_hierarchy.interfaces.Addable;

public class AddRemoveCollection extends Collection implements AddRemovable, Addable {
    @Override
    public String remove() {
        return super.removeLast();
    }

    @Override
    public int add(String item) {
        super.addFirst(item);
        return 0;
    }
}