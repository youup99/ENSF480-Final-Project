public class DatabaseController{
    private PropertyDatabase propertyDatabase;
    private UserDatabase userDatabase;

    public DatabaseController(PropertyDatabase propertyDatabase, UserDatabase userDatabase){
        this.propertyDatabase = propertyDatabase;
        this.userDatabase = userDatabase;
    }
}