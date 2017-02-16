package goose;

import pond.Gosling;
import shore.Bird;

public class Goose extends Bird {

    public void helpGooseSwim() {
        Goose other = new Goose();
        other.floatInWater();
        System.out.println(other.text);
    }

    public void helpOtherGooseSwim() {
        Bird other = new Goose();
        Bird other2 = new Gosling();

        Goose g2 = (Goose) other;

        Gosling g3 = (Gosling) other;

//        other.floatInWater(); //doesnt compile
//        System.out.println(other.text); //doesnt compile
    }

}
