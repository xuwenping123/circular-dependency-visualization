package org.github.circular.dependency.visualization.message;

import java.util.ArrayList;
import java.util.List;

public class ReferenceMessage implements Message {

    private final List<ReferenceCellMessage> cells;

    public ReferenceMessage() {
        cells = new ArrayList<>();
    }

    @Override
    public Message toMessage(String str) {
        return null;
    }

    public void addReferenceCellMessage(ReferenceCellMessage referenceCellMessage) {
        cells.add(referenceCellMessage);
    }

    @Override
    public String toString() {
        return "{" + cells + "}";
    }
}
