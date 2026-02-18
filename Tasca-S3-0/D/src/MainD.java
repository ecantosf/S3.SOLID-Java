public class MainD {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Joan");

        Database database = new MySQL();

        ServicePerson service = new ServicePerson(database);

        service.savePerson(person);
    }
}
