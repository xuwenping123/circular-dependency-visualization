package org.github.circular.dependency.visualization.context;

import org.github.circular.dependency.visualization.exception.IllegalConfigParamException;
import org.github.circular.dependency.visualization.util.FileUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GlobalConfigurator {

    private final Map<String, Object> globalConfigMapper = new HashMap<>();

    public void init(String configFilePath) {
        List<String> rows;
        try {
            rows = FileUtils.readerFileLines(configFilePath);
        } catch (IOException e) {
            throw new IllegalConfigParamException("configFilePath: " + configFilePath, e);
        }
        if (rows != null && !rows.isEmpty()) {
            for (String row : rows) {
                String[] array = row.split("=");
                if (array.length != 2) {
                    throw new IllegalConfigParamException("globalConfigValue: " + row);
                }
                globalConfigMapper.put(array[0], array[1]);
            }
        }
    }

    public void init(Map<String, Object> configMapper) {
        if (configMapper != null && !configMapper.isEmpty()) {
            globalConfigMapper.putAll(configMapper);
        }
        globalConfigMapper.putAll(System.getenv());
    }

    public <T> T getConfigValue(String configName, Class<T> clazz) {
        if (globalConfigMapper.containsKey(configName)) {
            Object value = globalConfigMapper.get(configName);
            if (Boolean.class.equals(clazz)) {
                return (T) Boolean.valueOf(value.toString());
            } else if (Integer.class.equals(clazz)) {
                return (T) Integer.valueOf(value.toString());
            } else {
                return (T) value;
            }
        }
        return null;
    }
}
