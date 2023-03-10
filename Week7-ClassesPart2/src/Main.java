import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mammal koala = new Mammal("munch", "grey", "bear");

        Dog pepper = new Dog("woof", "black and white", "pepper", 100, "beagle lab mutt");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("What's your dogs breed?");

        String dogsBreed = keyboard.nextLine();

        pepper.setBreed(dogsBreed);
        printMammalDetails(pepper);

        Square smallSquare = new Square(10);

        smallSquare.setWidth(20);
    }

    public static void printMammalDetails(Mammal mammal){
        System.out.println("noise: " + mammal.getNoise());
        System.out.println("color: " + mammal.getHairColor());
        System.out.println("name: "+ mammal.getName());

        System.out.println(mammal.makeNoise());

    }
}