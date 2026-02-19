public class UserManagement {
    private UserValidator validator;
    private EmailService emailService;

    public UserManagement() {
        this.validator = new UserValidator();
        this.emailService = new EmailService();
    }

    public void register(User user) {
        validator.validateUser(user);
        emailService.sendConfirmationEmail(user.getEmail());

    }
}