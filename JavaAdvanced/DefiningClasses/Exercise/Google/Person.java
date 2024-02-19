package DefiningClasses.Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Parent> parentList;
    private List<Child> childList;
    private List<Pokemon> pokemonList;

    public Person() {
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public Person(String name, Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pokemons) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.parentList = parents;
        this.childList = children;
        this.pokemonList = pokemons;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void printFormat(){
        System.out.println("Company:");
        if(company!=null) {
            System.out.println(company);
        }
        System.out.println("Car:");
        if(car!=null) {
            System.out.println(car);
        }
        System.out.println("Pokemon:");
        if(!getPokemonList().isEmpty()) {
            getPokemonList().forEach(pokemon -> System.out.printf("%s%n", pokemon));
        }
        System.out.println("Parents:");
        if(!getParentList().isEmpty()) {
            getParentList().forEach(parent -> System.out.printf("%s%n", parent));
        }
        System.out.println("Children:");
        if(!getChildList().isEmpty()) {
            getChildList().forEach(children -> System.out.printf("%s%n", children));
        }
    }
}
