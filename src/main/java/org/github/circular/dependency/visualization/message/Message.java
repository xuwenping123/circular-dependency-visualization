package org.github.circular.dependency.visualization.message;

public interface Message {

    Message toMessage(String str);

    String toString();
}
