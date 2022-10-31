public class Animal {
    public String name;
    private String viewAnimal;
    protected int age;

    public Animal(String name, String viewAnimal, int age) {
        this.name = name;
        this.viewAnimal = viewAnimal;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", viewAnimal='" + viewAnimal + '\'' +
                ", age=" + age +
                '}';
    }
}
