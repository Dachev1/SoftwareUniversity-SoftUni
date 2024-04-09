package interfaces_and_abstraction.exercise.collection_hierarchy;

import interfaces_and_abstraction.exercise.collection_hierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String item) {
        super.addLast(item);
        return super.getItems().size() - 1;
    }
}