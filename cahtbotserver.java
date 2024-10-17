import java.io.*;
import java.net.*;
import com.google.gson.*;

class ChatBotServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            StringBuilder body = new StringBuilder();
            String line;
            while (!(line = in.readLine()).isBlank()) {
                body.append(line);
            }

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(body.toString(), JsonObject.class);
            String userMessage = jsonObject.get("message").getAsString();
            String botResponse = getChatBotResponse(userMessage);

            JsonObject jsonResponse = new JsonObject();
            jsonResponse.addProperty("response", botResponse);

            out.write("HTTP/1.1 200 OK\r\n");
            out.write("Content-Type: application/json\r\n");
            out.write("\r\n");
            out.write(jsonResponse.toString());
            out.flush();

            clientSocket.close();
        }
    }

    private static String getChatBotResponse(String userMessage) {
        userMessage = userMessage.toLowerCase();

        if (userMessage.contains("hi") || userMessage.contains("hello")) {
            return "Hello! How can I assist you today?";
        } else if (userMessage.contains("how are you")) {
            return "I'm just a chatbot, but I'm here to help!";
        } else if (userMessage.contains("what's your name")) {
            return "I am a Java-powered chatbot.";
        } else {
            return "Sorry, I don't understand that.";
        }
    }
}
