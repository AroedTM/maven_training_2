package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {

    Class<?> my_class;

    public TestClassDescription(Class<?> m_class) {
        this.my_class = m_class;
    }

    public List<Method> listTestMethods(){
        List<Method> list = List.of(this.my_class.getDeclaredMethods());
        List<Method> result = new ArrayList<>();
        for (Method method : list) {
            int cpt = 0;
            if(Modifier.isPublic(method.getModifiers())){
                cpt++;
            }
            if(method.getReturnType().equals(Void.TYPE)){
                cpt++;
            }
            if(method.getParameterCount() == 0){
                cpt++;
            }
            if(method.isAnnotationPresent(TestMethod.class)){
                cpt++;
            }
            if(cpt == 4)
                result.add(method);
        }
        return result;
    }
}
