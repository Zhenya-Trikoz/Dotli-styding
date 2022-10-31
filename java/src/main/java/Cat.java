import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Cat {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {

        Animal animal = new Animal("Test", "Animal", 0);
        System.out.println("Об'єкт до рефлексії");
        System.out.println(animal);
        withReflection(animal, "Dark", "Cat", 3);
        System.out.println("Об'єкт після рефлексії");
        System.out.println(animal);

        System.out.println("Введіть клас який вас цікавить: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        informClass(str);
    }

    private static void withReflection(Animal animal, String name, String viewAnimal, int age) throws IllegalAccessException {
        Class<? extends Animal> aClass = animal.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            if ("name".equals(field.getName())) {
                field.setAccessible(true);
                Object o = field.get(animal);
                field.set(animal, name);
                System.out.printf("Змінено поле %s старе значення %s на нове %s", field.getName(), o, name);
                System.out.println();
            }
            if ("viewAnimal".equals(field.getName())) {
                field.setAccessible(true);
                Object o = field.get(animal);
                field.set(animal, viewAnimal);
                System.out.printf("Змінено поле %s старе значення %s на нове %s", field.getName(), o, viewAnimal);
                System.out.println();
            }
            if ("age".equals(field.getName())) {
                field.setAccessible(true);
                Object o = field.get(animal);
                field.set(animal, age);
                System.out.printf("Змінено поле %s старе значення %s на нове %s", field.getName(), o, age);
                System.out.println();
            }
        }

    }

    private static void informClass(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        System.out.printf("Поля класу %s: %n", cl.getName());

        for (Field field : cl.getDeclaredFields()) {
            System.out.print(field.getName() + " ");
        }
        System.out.println();

        System.out.printf("Конструктори класу %s: %n", cl.getName());

        for (Constructor constructor : cl.getConstructors()) {
            System.out.print(constructor.getName() + " ");
        }
        System.out.println();

        System.out.printf("Методи класу %s: %n", cl.getName());

        for (Method method : cl.getDeclaredMethods()) {
            System.out.print(method.getName() + " ");
        }

    }
}
