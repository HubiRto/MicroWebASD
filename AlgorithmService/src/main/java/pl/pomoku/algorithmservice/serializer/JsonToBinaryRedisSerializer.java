package pl.pomoku.algorithmservice.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

@Component
public class JsonToBinaryRedisSerializer<T> implements RedisSerializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(T t) throws SerializationException {
        try {
            String json = objectMapper.writeValueAsString(t);
            return json.getBytes();
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error serializing object to JSON", e);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        try {
            String json = new String(bytes);
            return objectMapper.readValue(json, (Class<T>) Object.class);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Error deserializing JSON to object", e);
        }
    }
}
