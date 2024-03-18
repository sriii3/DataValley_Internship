class Animal {
    void makeSound() {
        System.out.println("Some generic sound");
    }
    
    void makeSound(String specificSound) {
        System.out.println(specificSound);
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
    
    void makeSound(int frequency) {
        System.out.println("Woof at frequency: " + frequency);
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        
        animal.makeSound();  
        animal.makeSound("Meow");

        dog.makeSound();  
        dog.makeSound(100);  
        
        
        animal = new Dog(); 
        animal.makeSound(); 
    }
}
