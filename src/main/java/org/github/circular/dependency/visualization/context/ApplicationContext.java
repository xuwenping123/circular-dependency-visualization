package org.github.circular.dependency.visualization.context;

public class ApplicationContext implements Context {

    private GlobalConfigurator globalConfigurator;

    public ApplicationContext(GlobalConfigurator globalConfigurator) {
        this.globalConfigurator = globalConfigurator;
    }

    @Override
    public GlobalConfigurator getGlobalConfigurator() {
        return this.globalConfigurator;
    }
}
