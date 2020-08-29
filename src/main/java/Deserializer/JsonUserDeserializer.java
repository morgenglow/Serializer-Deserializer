package Deserializer;

import User.User;
import java.util.Collection;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class JsonUserDeserializer implements Deserializer {
    @Override
    public Collection<User> deserialize(String inputFile) {
        ObjectMapper objectMapper = new JsonMapper();
        File input = new File(inputFile);
        try {
            MappingIterator<User> it = objectMapper.readerFor(User.class).readValues(input);
            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
