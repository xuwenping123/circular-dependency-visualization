package org.github.circular.dependency.visualization.bean.set;

import org.springframework.stereotype.Service;

@Service
public class ClassF {

    private ClassD classD;

    public ClassF(ClassD classD) {
        this.classD = classD;
    }
}
