package org.github.circular.dependency.visualization.parser;

import org.github.circular.dependency.visualization.context.ContextAware;
import org.github.circular.dependency.visualization.message.Message;

import java.util.List;

public interface Parser extends ContextAware {

    List<Message> parse(List<Message> messages);
}