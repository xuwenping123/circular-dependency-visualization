package org.github.circular.dependency.visualization.exception;

public class IllegalConfigParamException extends RuntimeException {

    public IllegalConfigParamException(String configParam) {
        super("Illegal Config Param! " + configParam);
    }

    public IllegalConfigParamException(String configParam, Throwable cause) {
        super("Illegal Config Param! " + configParam, cause);
    }
}
