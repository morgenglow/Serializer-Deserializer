package Serializer;
import User.User;
import java.util.Collection;

public interface Serializer {
    void serialize(Collection<User> userCollection, String outputFile);
}