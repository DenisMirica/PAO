package pao.blsalin.studentSerialization.serialization.serializer;

import pao.blsalin.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.OutputStream;

public interface StudentSerializer {
    void serialize(OutputStream outputStream, Student student) throws IOException;
}
