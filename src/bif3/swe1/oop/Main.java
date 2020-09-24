package bif3.swe1.oop;

import bif3.swe1.oop.classes.ClassWithMembers;
import bif3.swe1.oop.inheritance.BaseClass;
import bif3.swe1.oop.inheritance.DerivedClass;
import bif3.swe1.oop.polymorphism.abstractbaseclass.AbstractShape;
import bif3.swe1.oop.polymorphism.abstractbaseclass.DerivedCircle;
import bif3.swe1.oop.polymorphism.abstractbaseclass.DerivedCompoundShape;
import bif3.swe1.oop.polymorphism.abstractbaseclass.DerivedLine;

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

        // Polymorphism with abstract base class
        AbstractShape abstractLine = new DerivedLine(0, 1,1, 1);
        abstractLine.showOrigin();
        double abstractLinePerimeter = abstractLine.getPerimeter();

        AbstractShape abstractCircle = new DerivedCircle(5, 5, 3);
        abstractCircle.showOrigin();
        double abstractCircleArea = abstractCircle.getArea();

        DerivedCompoundShape derivedCompound = new DerivedCompoundShape(7, 7);
        derivedCompound.add(abstractLine);
        derivedCompound.add(abstractCircle);
        derivedCompound.add(new DerivedLine(3, 4, 5, 6));
        derivedCompound.showOrigin();
        derivedCompound.printShapeType();

        // casting works in IDE, but will throw an error at runtime if "line" is something else than a Line object
        //AbstractShape shape = new DerivedCircle(0, 0, 1);
        //DerivedLine line3 = (DerivedLine)shape;

        System.out.println("-----");
    }
}
