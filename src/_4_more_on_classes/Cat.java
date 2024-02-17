package _4_more_on_classes;

public class Cat {
    // identify real-world attributes of class and implement as class attributes
    //    String name = "Fluffy";
    //    int age = 3;
    //    String breed = "Siamese";
    //    double weight = 10.5;

    // add appropriate access modifier for each attribute
    private String name;
    private int age;
    private String breed;
    private double weight;

    // define constructor for class
    public Cat(String name, int age, String breed, double weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
    }
    // explicitly define default constructor by overloading previous constructor.
    public Cat(){
        this("Fluffy", 3, "Siamese", 10.5);
    }

    // define setters for each attribute of class
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // define getters for each attribute of the class
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getBreed(){
        return breed;
    }

    public double getWeight(){
        return weight;
    }

    // define a toString method
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nbreed: " + breed + "\nweight: " + weight;
    }

}