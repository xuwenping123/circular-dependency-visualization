package org.github.circular.dependency.visualization.bean.set;

import org.springframework.stereotype.Service;

@Service
public class ClassE {

    private ClassF classF;

    public ClassE(ClassF classF) {
        this.classF = classF;
    }
}
