package org.github.circular.dependency.visualization.parser;

import org.github.circular.dependency.visualization.context.Context;
import org.github.circular.dependency.visualization.message.Message;
import org.github.circular.dependency.visualization.message.ReferenceCellMessage;
import org.github.circular.dependency.visualization.message.ReferenceMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularParser implements Parser {

    private final static String EMPTY_STRING = "";

    private Context context;

    private Pattern beanPattern = Pattern.compile("Error creating bean with name '(.*?)'");


    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public List<Message> parse(List<Message> messages) {
        if (messages == null || messages.isEmpty()) {
            return Collections.emptyList();
        }
        messages = doFilter(messages);
        return match(messages);
    }

    public List<Message> doFilter(List<Message> messages) {
        boolean flag = false;
        List<Message> result = new ArrayList<>(messages.size());
        for (Message message : messages) {
            String str = message.toString();
            if (str.contains("Failed to load ApplicationContext")) {
                flag = true;
            }
            if (flag && str.contains("Error creating bean with name")) {
                result.add(message);
            }
            if (flag && EMPTY_STRING.equals(str)) {
                break;
            }
        }
        return result;
    }

    public List<Message> match(List<Message> messages) {
        List<Message> result = new ArrayList<>(messages.size());
        for (Message message : messages) {
            String str = message.toString();
            Matcher matcher = beanPattern.matcher(str);
            ReferenceMessage referenceMessage = new ReferenceMessage();
            while (matcher.find()) {
                String hitter = matcher.group();
                String bean = hitter.substring("Error creating bean with name '".length(), hitter.length() - 1);
                ReferenceCellMessage referenceCellMessage = new ReferenceCellMessage(bean);
                referenceMessage.addReferenceCellMessage(referenceCellMessage);
            }
            result.add(referenceMessage);
        }
        return result;
    }
}
