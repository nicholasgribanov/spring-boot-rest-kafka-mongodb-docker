package name.nicholasgribanov.producer.kafka.config;

import name.nicholasgribanov.dto.Data;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.io.*;
import java.util.Map;

public class DataSerializer implements Serializer<Data> {
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> map, boolean b) {
        this.isKey = b;
    }

    @Override
    public byte[] serialize(String s, Data data) {
        if (data == null)
            return null;

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.flush();

            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new SerializationException("Error serializing", e);
        }

    }

    @Override
    public void close() {

    }
}
