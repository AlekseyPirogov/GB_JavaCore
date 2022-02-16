package Lesson_1_Object.Ex1_ExampleCode;

public class _33_NewClient implements _02_ExampleInterface, _31_Information {

    @Override
    public void exampleInterface(int var1) {
        System.out.println("Example interface. Variable: " + var1);
    }

    @Override
    public void function() {
        System.out.println("Function \"function\".");
    }
}
