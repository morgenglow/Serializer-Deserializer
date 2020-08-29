package Serializer;

import User.User;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlUserSerializer implements Serializer {
    @Override
    public void serialize(Collection<User> userCollection, String outputFile) {
        ObjectMapper objectMapper = new XmlMapper();
        File output = new File(outputFile);
        try {
            objectMapper.writerFor(userCollection.getClass()).writeValue(output, userCollection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
