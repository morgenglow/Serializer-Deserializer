package Serializer;

import User.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collection;
import java.io.File;
import java.io.IOException;



public class JsonUserSerializer implements Serializer {
    @Override
    public void serialize(Collection<User> userCollection, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        File output = new File(outputFile);
        try {
            objectMapper.writerFor(userCollection.getClass()).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
