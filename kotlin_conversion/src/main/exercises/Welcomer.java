public class Welcomer {
    private final String message;

    private Welcomer(String message) {
        this.message = message;
        System.out.println("Welcome to Real World " + message);
    }

    private String printEachCharacter() {
        if (message != null) {
            printCharacters(message);
            return "Go " + message + "!";
        }
        return "No message";
    }

    private void printCharacters(String message) {
        for (Character part : message.toUpperCase().toCharArray()) {
            System.out.println("Give me a " + part + "!");
        }
    }

    public static void main(String[] args) {
        String finalMessage = new Welcomer("Kotlin").printEachCharacter();
        System.out.println(finalMessage);
    }
}
