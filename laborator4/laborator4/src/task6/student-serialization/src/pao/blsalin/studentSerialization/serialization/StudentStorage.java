package pao.blsalin.studentSerialization.serialization;

import pao.blsalin.studentSerialization.domain.Student;
import pao.blsalin.studentSerialization.serialization.deserializer.StudentDeserializer;
import pao.blsalin.studentSerialization.serialization.serializer.StudentSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) throws IOException, ClassNotFoundException {
        List<Student> studentsFromFile = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            while (true) {
                Student student = (Student) objectInputStream.readObject();
                studentsFromFile.add(student);
            }
        } catch (EOFException e) {
        }
        return studentsFromFile;
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(outputStream))) {
            for (Student student : students) {
                objectOutputStream.writeObject(student);
            }
        }
    }
}
