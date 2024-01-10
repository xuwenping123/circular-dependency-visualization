package org.github.circular.dependency.visualization.display;

import org.github.circular.dependency.visualization.context.Context;
import org.github.circular.dependency.visualization.message.Message;

import java.util.List;

public class PrintDisplay implements Display {

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context  = context;
    }

    @Override
    public void doDisplay(List<Message> messages) {
        messages.forEach(System.out::println);
    }
}
