package pao.blsalin.studentSerialization;

import pao.blsalin.studentSerialization.domain.Student;
import pao.blsalin.studentSerialization.serialization.StudentStorage;
import pao.blsalin.studentSerialization.serialization.deserializer.RawDataStudentDeserializer;
import pao.blsalin.studentSerialization.serialization.deserializer.TextStudentDeserializer;
import pao.blsalin.studentSerialization.serialization.serializer.RawDataStudentSerializer;
import pao.blsalin.studentSerialization.serialization.serializer.TextStudentSerializer;

import java.io.IOException;

public class Main {

    private final static boolean runBonus = false;

    public static void main(String[] args) {
        StudentStorage storage;
        if (runBonus) {
            storage = getStorageForBonus();
        } else {
            storage = getStorageForTask6();
        }

        StudentSerializationTester tester = new StudentSerializationTester(storage);
        tester.runTests();

        runCustomTests(storage);
    }

    private static void runCustomTests(StudentStorage storage) {
        // TODO: Aici va puteti scrie teste proprii pentru verificarea corectitudinii
    }

    private static StudentStorage getStorageForTask6() {
        return new StudentStorage(new RawDataStudentSerializer(), new RawDataStudentDeserializer());
    }

    private static StudentStorage getStorageForBonus() {
        return new StudentStorage(new TextStudentSerializer(), new TextStudentDeserializer());
    }
}
