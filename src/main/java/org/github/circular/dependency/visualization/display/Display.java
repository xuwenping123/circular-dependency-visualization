package org.github.circular.dependency.visualization.display;

import org.github.circular.dependency.visualization.context.ContextAware;
import org.github.circular.dependency.visualization.message.Message;

import java.util.List;

public interface Display extends ContextAware {

    void doDisplay(List<Message> messages);
}
