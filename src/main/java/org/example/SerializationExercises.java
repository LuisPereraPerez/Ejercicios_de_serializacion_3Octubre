package org.example;

import com.google.gson.Gson;
import org.example.model.Movie;
import org.example.model.Session;
import org.example.model.Theater;

import java.io.*;
import java.util.Scanner;

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
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Exercise2 {

        public static void main(String[] args) {

            // movie 1
            try {
                BufferedReader br = new BufferedReader(new FileReader("movie1.json"));
                String text;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    Gson gson = new Gson();
                    Movie movie1back = gson.fromJson(text, Movie.class);
                    System.out.println(movie1back);

                    if (movie1back != null) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("save_movie1.json");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(movie1back);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            // movie 2
            try {
                BufferedReader br = new BufferedReader(new FileReader("movie2.json"));
                String text;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    Gson gson = new Gson();
                    Movie movie2back = gson.fromJson(text, Movie.class);
                    System.out.println(movie2back);

                    if (movie2back != null) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("save_movie2.json");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(movie2back);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            // theater 1
            try {
                BufferedReader br = new BufferedReader(new FileReader("theater1.json"));
                String text;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    Gson gson = new Gson();
                    Theater theater1back = gson.fromJson(text, Theater.class);
                    System.out.println(theater1back);

                    if (theater1back != null) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("save_theater1.json");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(theater1back);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            // theater 2
            try {
                BufferedReader br = new BufferedReader(new FileReader("theater2.json"));
                String text;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    Gson gson = new Gson();
                    Theater theater2back = gson.fromJson(text, Theater.class);
                    System.out.println(theater2back);

                    if (theater2back != null) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("save_theater2.json");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(theater2back);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            // session 1
            try {
                BufferedReader br = new BufferedReader(new FileReader("session1.json"));
                String text;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    Gson gson = new Gson();
                    Session session1back = gson.fromJson(text, Session.class);
                    System.out.println(session1back);

                    if (session1back != null) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("save_session1.json");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(session1back);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            // session 2
            try {
                BufferedReader br = new BufferedReader(new FileReader("session2.json"));
                String text;
                while ((text = br.readLine()) != null) {
                    System.out.println(text);
                    Gson gson = new Gson();
                    Session session2back = gson.fromJson(text, Session.class);
                    System.out.println(session2back);

                    if (session2back != null) {
                        try {
                            FileOutputStream fileOut = new FileOutputStream("save_session2.json");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(session2back);
                            out.close();
                            fileOut.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static class Exercise3 {

        public static void main(String[] args) throws IOException {
            // movie1
            try {
                FileInputStream fileIn = new FileInputStream("save_movie1.json");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Movie movie1back = (Movie) in.readObject();
                in.close();
                fileIn.close();
                System.out.println(movie1back);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // movie2
            try {
                FileInputStream fileIn = new FileInputStream("save_movie2.json");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Movie movie2back = (Movie) in.readObject();
                in.close();
                fileIn.close();
                System.out.println(movie2back);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // theater1
            try {
                FileInputStream fileIn = new FileInputStream("save_theater1.json");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Theater theater1back = (Theater) in.readObject();
                in.close();
                fileIn.close();
                System.out.println(theater1back);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // theater2
            try {
                FileInputStream fileIn = new FileInputStream("save_theater2.json");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Theater theater2back = (Theater) in.readObject();
                in.close();
                fileIn.close();
                System.out.println(theater2back);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // session1
            try {
                FileInputStream fileIn = new FileInputStream("save_session1.json");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Session session1back = (Session) in.readObject();
                in.close();
                fileIn.close();
                System.out.println(session1back);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            // session2
            try {
                FileInputStream fileIn = new FileInputStream("save_session2.json");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Session session2back = (Session) in.readObject();
                in.close();
                fileIn.close();
                System.out.println(session2back);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
}