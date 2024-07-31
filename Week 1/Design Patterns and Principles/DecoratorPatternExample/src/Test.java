public class Test {
    public static void main(String[] args) {
        // Basic EmailNotifier
        Notifier emailNotifier = new EmailNotifier();

        // Decorating with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Decorating further with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Message through all decorated channels
        slackNotifier.send("Welcome to Cognizant Java FSE");
    }
}
