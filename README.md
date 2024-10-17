import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        System.out.println("Hello! I'm your chatbot. Ask me anything!");

        while (true) {
            System.out.print("You: ");
            userInput = scanner.nextLine().toLowerCase();

            // Exit if the user types "bye"
            if (userInput.equals("bye")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            }

            // Simple chatbot responses
            switch (userInput) {
                case "hi":
                case "hello":
                    System.out.println("ChatBot: Hi there! How can I help you?");
                    break;
                case "how are you?":
                    System.out.println("ChatBot: I'm just a bunch of code, but thanks for asking!");
                    break;
                case "what's your name?":
                    System.out.println("ChatBot: I am a simple Java chatbot.");
                    break;
                case "what can you do?":
                    System.out.println("ChatBot: I can have a simple conversation with you.");
                    break;
                default:
                    System.out.println("ChatBot: Sorry, I don't understand that.");
                    break;
            }
        }

        scanner.close();
    }
}
