package org.github.circular.dependency.visualization;

import org.github.circular.dependency.visualization.context.ApplicationContext;
import org.github.circular.dependency.visualization.context.GlobalConfigurator;
import org.github.circular.dependency.visualization.display.Display;
import org.github.circular.dependency.visualization.display.PrintDisplay;
import org.github.circular.dependency.visualization.message.Message;
import org.github.circular.dependency.visualization.parser.Parser;
import org.github.circular.dependency.visualization.parser.RegularParser;
import org.github.circular.dependency.visualization.source.FileSource;
import org.github.circular.dependency.visualization.source.Source;

import java.util.List;

public class Executor {

    private String configFilePath = "src/main/resources/application.properties";

    private Source source;
    private Parser parser;
    private Display display;

    public static void main(String[] args) {
        Executor executor = new Executor();
        executor.init(args);
        executor.run();
    }

    public void init(String[] args) {
        if (args.length >= 1) {
            configFilePath = args[0];
        }

        GlobalConfigurator globalConfigurator = new GlobalConfigurator();
        globalConfigurator.init(configFilePath);

        ApplicationContext context = new ApplicationContext(globalConfigurator);

        source = new FileSource();
        source.setContext(context);

        parser = new RegularParser();
        parser.setContext(context);

        display = new PrintDisplay();
        display.setContext(context);
    }

    public void run() {
        List<Message> messages = source.getMessages();
        messages = parser.parse(messages);
        display.doDisplay(messages);
    }
}
