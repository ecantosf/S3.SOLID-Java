public class ServicePerson {
    private Database database;

    public ServicePerson(Database database) {
        this.database = database;
    }

    public void savePerson(Person person) {
        database.savePerson(person);
    }
}