package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {

    String my_package;
    public TestClassDiscoverer(String my_string){
        this.my_package = my_string;
    }

    public List<TestClassDescription> listTestClasses(){
        Reflections reflections = new Reflections(this.my_package);
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);
        List<TestClassDescription> result = new ArrayList<>();
        for(Class<?> cls : allTypes){
            String name = cls.getName();
            if(name.endsWith("LernejoTests")){
                TestClassDescription tcd = new TestClassDescription(cls);
                if(!tcd.listTestMethods().isEmpty()){
                    result.add(tcd);
                }
            }
        }
        return result;
    }
}
