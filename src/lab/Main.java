

import java.util.Scanner;

class Animal {
    public void makeSound() {
        System.out.println();
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println();
    }
}

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeSound();
    }

}
