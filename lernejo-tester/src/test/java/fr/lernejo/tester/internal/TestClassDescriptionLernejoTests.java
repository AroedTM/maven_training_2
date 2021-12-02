package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

import java.lang.reflect.Method;
import java.util.List;

class TestClassDescriptionLernejoTests {

    static void check(Class<?> the_class){
        TestClassDescription class_to_compare = new TestClassDescription(the_class);
        List<Method> result = class_to_compare.listTestMethods();
        System.out.println(result);
    }

    public static void main(String[] args)
    {
        check(SomeLernejoTests.class);
    }
}
