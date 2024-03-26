package pao.blsalin.studentSerialization.serialization.serializer;

import pao.blsalin.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(student);
        }
    }
}
