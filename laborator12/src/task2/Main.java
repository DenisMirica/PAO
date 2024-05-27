package task2;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            int id = new Random().nextInt(100) + 1;
            String resource = HttpClientExample.getResourceById(id);
            System.out.println("Resource with ID " + id + ": " + resource);

            String newResource = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
            String response = HttpClientExample.createResource(newResource);
            System.out.println("Resource created: " + newResource);
            System.out.println("Response: " + response);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
