package pao.blsalin.studentSerialization.serialization.deserializer;

import pao.blsalin.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class RawDataStudentDeserializer implements StudentDeserializer {
    @Override
    public Student deserializer(InputStream inputStream) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (Student) objectInputStream.readObject();
        }
    }
}
