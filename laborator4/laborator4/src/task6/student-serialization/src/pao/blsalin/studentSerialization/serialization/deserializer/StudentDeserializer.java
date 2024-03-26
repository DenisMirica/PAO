package pao.blsalin.studentSerialization.serialization.deserializer;

import pao.blsalin.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.InputStream;

public interface StudentDeserializer {
    Student deserializer(InputStream inputStream) throws IOException, ClassNotFoundException;
}
