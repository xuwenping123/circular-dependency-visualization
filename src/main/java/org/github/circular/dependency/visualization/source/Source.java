package org.github.circular.dependency.visualization.source;

import org.github.circular.dependency.visualization.context.ContextAware;
import org.github.circular.dependency.visualization.message.Message;

import java.util.List;

public interface Source extends ContextAware {

    List<Message> getMessages();
}
