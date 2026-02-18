public class Main {
    public static void main(String[] args) {
        User userValid = new User("Eduard Cantos", "eduard@mail.com", "Password123");
        User userNotValid = new User(null, "eduard_mail.com", "passw");

        UserManagement registrationService = new UserManagement();

        try {
            registrationService.register(userValid);
            System.out.println("Usuari registrat correctament!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            registrationService.register(userNotValid);
            System.out.println("Usuari registrat correctament!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
