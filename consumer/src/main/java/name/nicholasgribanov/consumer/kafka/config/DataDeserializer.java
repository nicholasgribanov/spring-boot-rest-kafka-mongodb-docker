package name.nicholasgribanov.consumer.kafka.config;

import name.nicholasgribanov.dto.Data;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class DataDeserializer implements Deserializer<Data> {
    private boolean isKey;

    @Override
    public void configure(Map<String, ?> map, boolean b) {
        this.isKey = b;

    }

    @Override
    public Data deserialize(String s, byte[] data) {
        if (data == null)
            return null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));

            return (Data) objectInputStream.readObject();
        } catch (IOException e) {
            throw new SerializationException("Error deserialising", e);
        } catch (ClassNotFoundException e) {
            throw new SerializationException("Error deserialising", e);
        }
    }

    @Override
    public void close() {

    }
}
