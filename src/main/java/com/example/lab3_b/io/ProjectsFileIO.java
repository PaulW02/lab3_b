package com.example.lab3_b.io;

import com.example.lab3_b.model.Project;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hints on how to implement serialization and deserialization
 * of lists of projects and users.
 */
public class ProjectsFileIO {

    /**
     * Call this method before the application exits, to store the users and projects,
     * in serialized form.
     */
    public static void serializeToFile(File file, List<Project> data) throws IOException {

        ObjectOutputStream out = null; //för att kunna serialisera object

        try{
            out = new ObjectOutputStream(new FileOutputStream(file));
            out.writeObject(data);
        }
        finally {
            if(out != null){
                out.close();
            }
        }
        // ...
        // and then, make sure the file always get closed
    }
    /**
     * Call this method at startup of the application, to deserialize the users and
     * from file the specified file.
     */
    @SuppressWarnings("unchecked")
    public static List<Project> deSerializeFromFile(File file) throws IOException, ClassNotFoundException {

        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(file));
            return (List<Project>) in.readObject();
        } finally{
            if (in != null){
                in.close();
            }
        }
    }
        // ...
        // and then, make sure the file always get closed

    private ProjectsFileIO() {

    }
}
