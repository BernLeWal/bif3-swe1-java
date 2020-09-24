package bif3.swe1.oop;

import bif3.swe1.oop.classes.ClassWithMembers;
import bif3.swe1.oop.inheritance.BaseClass;
import bif3.swe1.oop.inheritance.DerivedClass;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // different types of string concatenation & interpolation
        String someStringValue = "some value";
        String anotherStringValue = "another value";
        String differentStringValue = "different value";

        String doNotConcatStringLikeThis = "Use this to format " + someStringValue + " with " + anotherStringValue + " and " + differentStringValue;
        String concatString = someStringValue.concat( anotherStringValue.concat(differentStringValue) );
        String concatStringBetter = new StringBuilder().append(someStringValue).append(anotherStringValue).append(differentStringValue).toString();
        String formatString = String.format("Use this to format %s with %s and %s", someStringValue, anotherStringValue, differentStringValue );

        System.out.println("-----");

        // class members
        System.out.println(ClassWithMembers.STATIC_STRING);
        ClassWithMembers classWithMembers = new ClassWithMembers();
        classWithMembers.changeSomeValues(10);
        classWithMembers.writeSomething();

        System.out.println("-----");

        // Inheritance & Basic Polymorphism
        BaseClass bc = new BaseClass();
        DerivedClass dc = new DerivedClass();
        BaseClass bcdc = new DerivedClass();

        bc.method1();
        bc.method2();

        dc.method1();
        dc.method2();

        // runtime polymorphism
        // calls method1 of derived class because of implicit-virtual/override
        bcdc.method1();
        // remark: no method-hiding here
        // calls overloaded method2 of derived class because of casting
        ((DerivedClass)bcdc).method2("sdf");

        System.out.println("-----");
    }
}
