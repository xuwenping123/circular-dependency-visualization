package org.github.circular.dependency.visualization.source;

import org.github.circular.dependency.visualization.context.Context;
import org.github.circular.dependency.visualization.context.ContextAware;
import org.github.circular.dependency.visualization.exception.IllegalConfigParamException;
import org.github.circular.dependency.visualization.message.Message;
import org.github.circular.dependency.visualization.message.RowMessage;
import org.github.circular.dependency.visualization.util.FileUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileSource implements Source {

    private Context context;

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public List<Message> getMessages() {
        String sourceFile = context.getGlobalConfigurator().getConfigValue("source.file.path", String.class);
        List<String> rows;
        try {
            rows = FileUtils.readerFileLines(sourceFile);
        } catch (IOException e) {
            throw new IllegalConfigParamException("source.file.path: " + sourceFile, e);
        }
        if (rows == null || rows.isEmpty()) {
            throw new IllegalConfigParamException("source file is empty");
        }

        return rows.stream().map(RowMessage::new).collect(Collectors.toList());
    }
}
