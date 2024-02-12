interface Food {
    public String makeFood();
}

class SimpleFood implements Food {
    public String makeFood() {
        return "Base Food";
    }
}

abstract class FoodDecorator implements Food {
    protected Food specialFood;
    public FoodDecorator(Food specialFood) {
        this.specialFood = specialFood;
    }
    public String makeFood() {
        return specialFood.makeFood();
    }
}

class VegDecorator extends FoodDecorator {
    public VegDecorator(Food specialFood) {
        super(specialFood);
    }
    public String makeFood() {
        return specialFood.makeFood() + makeVeg();
    }
    private String makeVeg() {
        return " + Vegetarian";
    }
}

class NonVeg extends FoodDecorator {
    public NonVeg(Food specialFood) {
        super(specialFood);
    }
    public String makeFood() {
        return specialFood.makeFood() + makeNonVeg();
    }
    private String makeNonVeg() {
        return " + Non-Vegetarian";
    }
}
    
class Task1{
    public static void main(String args[]) {
        Food HotFood = new NonVeg(new SimpleFood());

        System.out.println(HotFood.makeFood());
    }    
}