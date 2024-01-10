package org.github.circular.dependency.visualization.bean.set;

import org.springframework.stereotype.Service;

@Service
public class ClassD {

    private ClassE classE;

    public ClassD(ClassE classE) {
        this.classE = classE;
    }
}
