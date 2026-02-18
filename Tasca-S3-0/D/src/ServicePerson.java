public class ServicePerson {
    private Database database;

    // Injecció de dependència per constructor
    public ServicePerson(Database database) {
        this.database = database;
    }

    public void savePerson(Person person) {
        database.savePerson(person);
    }
}