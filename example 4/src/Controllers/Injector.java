package Controllers;

public class Injector {

    private static final Reader reader = new Reader();
    private static final BasicFoodController foodController = new BasicFoodController();
    private static final RecipeController recipeController = new RecipeController();
    private static final ExerciseController exerciseController = new ExerciseController();
    private static final LogController logController = new LogController();

    public static Reader getReader(){
        return reader;
    }

    public static BasicFoodController getFoodController(){
        return foodController;
    }

    public static RecipeController getRecipeController(){
        return recipeController;
    }

    public static ExerciseController getExerciseController(){
        return exerciseController;
    }

    public static LogController getLogController(){
        return logController;
    }
}
