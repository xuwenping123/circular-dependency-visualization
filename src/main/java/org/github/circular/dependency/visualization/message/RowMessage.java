package org.github.circular.dependency.visualization.message;

public class RowMessage implements Message {

    private String rowMessage;

    public RowMessage(String rowMessage) {
        this.rowMessage = rowMessage;
    }

    @Override
    public Message toMessage(String str) {
        return new RowMessage(str);
    }

    @Override
    public String toString() {
        return rowMessage;
    }
}
