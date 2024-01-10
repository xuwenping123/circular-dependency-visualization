package org.github.circular.dependency.visualization;

import org.github.circular.dependency.visualization.bean.set.ClassD;
import org.github.circular.dependency.visualization.bean.set.ClassE;
import org.github.circular.dependency.visualization.bean.set.ClassF;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Import({
        ClassD.class, ClassE.class, ClassF.class
})
public class ExecutorTest implements ApplicationContextAware {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Ignore
    @Test
    public void buildCircularDependencyMessage() {
        System.out.println("starting");
        ClassE classE = applicationContext.getBean(ClassE.class);
        System.out.println(classE);
    }
}