package inland;

import inland.Animal;

public class Zebra extends Animal {

    public Zebra(int age) {
        super(age);
    }

    public Zebra() {
        this(4);
    }

    private float getAverageWeight(int a, float b) {
        return 50+20;
    }

    //it`s a new method; nu are nicio leg cu cea din parinte; daca in parinte era public/protected, nu ar mai fi mers, fiind private
    private String testMethod(){
        return null;
    }

    public static void staticMethod(){

    }

//    public static void nonStaticMethodInParent() {
//
//    }

    public static void main(String[] args) {
        System.out.println(new Animal(5).getAverageWeight(5, 5));
        int x = 5;
        int z = x++ + ++x + --x;
        System.out.println(z);
    }
}
