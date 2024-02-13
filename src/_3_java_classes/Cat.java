package _3_java_classes;
public class Cat {
    // identify real-world attributes of class and implement as class attributes
        //    String name = "Fluffy";
        //    int age = 3;
        //    String breed = "Siamese";
        //    double weight = 10.5;

    String name;
    int age;
    String breed;
    double weight;

    // define constructor for class
    public Cat(String name, int age, String breed, double weight){
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
    }

    // define setters for each attribute of class
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    // next class - define getters for each attribute of class


    public static void main(String[] args){
        // instantiate class
        Cat myCat = new Cat("Fluffy", 37, "Golden Retriever", 32.1);
        System.out.println(myCat);
    }

    // define a toString method
    public String toString(){
        return "Name: " + name + "\nAge: " + age + "\nbreed: " + breed + "\nweight: " + weight;
    }
}