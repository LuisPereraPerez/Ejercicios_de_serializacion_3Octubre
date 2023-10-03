package org.example;

import com.google.gson.Gson;
import org.example.model.Movie;
import org.example.model.Session;
import org.example.model.Theater;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SerializationExercises {

    public static class Exercise1 {

        public static void main(String[] args) {
            Movie movie1 = new Movie("Barbie", 114);
            Movie movie2 = new Movie("Oppenheimer", 180);

            Theater theater1 = new Theater("Juan Ramon Jimenez", "Telde");
            Theater theater2 = new Theater("Barcelo", "Madrid");

            Session session1 = new Session(movie1, theater1, "17:30");
            Session session2 = new Session(movie2, theater2, "19:00");

            Gson gson = new Gson();

            String movie1Json = gson.toJson(movie1);
            saveJsonToFile("movie1.json", movie1Json);

            String movie2Json = gson.toJson(movie2);
            saveJsonToFile("movie2.json", movie2Json);

            String theater1Json = gson.toJson(theater1);
            saveJsonToFile("theater1.json", theater1Json);

            String theater2Json = gson.toJson(theater2);
            saveJsonToFile("theater2.json", theater2Json);

            String session1Json = gson.toJson(session1);
            saveJsonToFile("session1.json", session1Json);

            String session2Json = gson.toJson(session2);
            saveJsonToFile("session2.json", session2Json);
        }

        private static void saveJsonToFile(String filename, String json) {
            try (FileWriter fileWriter = new FileWriter(filename)) {
                fileWriter.write(json);
                System.out.println("Saved " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Exercise2 {

        public static void main(String[] args) {
            List<Object> objectsToSerialize = new ArrayList<>();

            Movie movie1 = deserializeFromJson("movie1.json", Movie.class);
            objectsToSerialize.add(movie1);

            Movie movie2 = deserializeFromJson("movie2.json", Movie.class);
            objectsToSerialize.add(movie2);

            Theater theater1 = deserializeFromJson("theater1.json", Theater.class);
            objectsToSerialize.add(theater1);

            Theater theater2 = deserializeFromJson("theater2.json", Theater.class);
            objectsToSerialize.add(theater2);

            Session session1 = deserializeFromJson("session1.json", Session.class);
            objectsToSerialize.add(session1);

            Session session2 = deserializeFromJson("session2.json", Session.class);
            objectsToSerialize.add(session2);

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized_objects.dat"))) {
                for (Object obj : objectsToSerialize) {
                    oos.writeObject(obj);
                }
                System.out.println("Serialized objects successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static <T> T deserializeFromJson(String filename, Class<T> clazz) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                Gson gson = new Gson();
                return gson.fromJson(bufferedReader, clazz);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    public static class Exercise3 {

        public static void main(String[] args) {
            List<Object> deserializedObjects = deserializeFromSerializedFile("serialized_objects.dat");
        }

        private static List<Object> deserializeFromSerializedFile(String filename) {
            List<Object> deserializedObjects = new ArrayList<>();

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                while (true) {
                    try {
                        Object obj = ois.readObject();
                        deserializedObjects.add(obj);
                    } catch (EOFException e) {
                        // End of file reached
                        break;
                    }
                }
                System.out.println("Deserialized objects successfully.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return deserializedObjects;
        }
    }
}