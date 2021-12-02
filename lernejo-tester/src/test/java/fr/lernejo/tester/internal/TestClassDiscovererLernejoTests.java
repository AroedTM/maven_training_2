package fr.lernejo.tester.internal;

import java.util.List;

class TestClassDiscovererLernejoTests {

    static void check(String name_package){
        TestClassDiscoverer variable = new TestClassDiscoverer(name_package);
        List<TestClassDescription> result = variable.listTestClasses();
        System.out.println(result);
    }

    public static void main(String[] args)
    {
        check("fr.lenejo.tester");
    }
}
