package application;

import model_entities.Department;

public class App {
    
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        System.out.println(obj);
    }
}