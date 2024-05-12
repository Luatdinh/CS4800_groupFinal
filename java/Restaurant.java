import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private String county;
    private String operatingHours;
    private String cuisineType;
    private List<Meal> meals;
    private Menu menu;
    private CPPFoodDeliveryPlatform server;  // Added server attribute

    // Constructor updated to include CPPFoodDeliveryPlatform parameter
    public Restaurant(String name, String address, String county, String operatingHours, String cuisineType, CPPFoodDeliveryPlatform server) {
        this.name = name;
        this.address = address;
        this.county = county;
        this.operatingHours = operatingHours;
        this.cuisineType = cuisineType;
        this.meals = new ArrayList<>();
        this.menu = new Menu();
        this.server = server;
        prepareDietaryMeals();
    }

    // Prepare initial meals for different diets
    private void prepareDietaryMeals() {
        createMealForDiet("No Restriction");
        createMealForDiet("Paleo");
        createMealForDiet("Vegan");
        createMealForDiet("Nut Allergy");
    }

    // Method to create meals for a specific diet
    public void createMealForDiet(String dietaryRestriction) {
        Macronutrient macronutrient = new Macronutrient(dietaryRestriction);
        Meal meal = new Meal(15.0); // Base price for simplicity
        meal.addComponent(macronutrient.createCarb());
        meal.addComponent(macronutrient.createProtein());
        meal.addComponent(macronutrient.createFat());
        meals.add(meal);
    }

    // Method to prepare meals that delegates to the server
    public void prepareMeal() {
        server.processPrepareMeals();
    }

    // Getters and setters...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public Menu getMenu() {
        return menu;
    }
}
