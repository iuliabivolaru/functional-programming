package pond;

class Baap {
    public int h = 4;
    public int getH() {
System.out.println("Baap " + h); // aici se acceseaza mereu 4 pt ca e this.h     
return h;
    } }

public class Beta extends Baap {
    public int h = 44;
    public int getH() {
        System.out.println("Beta " + h);// aici se acceseaza mereu 44, pt ca e this.h     
        return h;
    }

    public static void main(String[] args) {
        Baap b = new Beta();
        System.out.println(b.h + " " + b.getH());
        Beta bb = (Beta) b;
        System.out.println(bb.h + " " + bb.getH());
    } }
