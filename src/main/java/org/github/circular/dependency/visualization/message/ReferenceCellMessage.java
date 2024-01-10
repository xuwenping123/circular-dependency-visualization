package org.github.circular.dependency.visualization.message;

public class ReferenceCellMessage implements Message {

    private String bean;

    public ReferenceCellMessage(String bean) {
        this.bean = bean;
    }

    @Override
    public Message toMessage(String str) {
        return null;
    }

    @Override
    public String toString() {
        return "bean='" + bean + "'";
    }
}
