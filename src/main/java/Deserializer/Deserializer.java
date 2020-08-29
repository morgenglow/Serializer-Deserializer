package Deserializer;
import User.User;
import java.util.Collection;

public interface Deserializer {

    Collection<User> deserialize(String inputFile);

}
