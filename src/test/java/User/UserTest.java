package User;

import Deserializer.Deserializer;
import Deserializer.JsonUserDeserializer;
import Deserializer.CsvUserDeserializer;
import Deserializer.XmlUserDeserializer;
import Serializer.JsonUserSerializer;
import Serializer.CsvUserSerializer;
import Serializer.XmlUserSerializer;
import Serializer.Serializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private List<User> newUsers(){
        ArrayList<User> userCollection = new ArrayList<User>();
        userCollection.add(new User(1, "User 1", "user1@mail.ru"));
        userCollection.add(new User(2, "User 2", "user2@mail.ru"));
        userCollection.add(new User(3, "User 3", "user3@mail.ru"));
        userCollection.add(new User(4, "User 4", "user4@mail.ru"));
        userCollection.add(new User(5, "User 5", "user5@mail.ru"));
        userCollection.add(new User(6, "User 6", "user6@mail.ru"));
        userCollection.add(new User(7, "User 7", "user7@mail.ru"));
        userCollection.add(new User(8, "User 8", "user8@mail.ru"));
        userCollection.add(new User(9, "User 9", "user9@mail.ru"));
        userCollection.add(new User(10, "User 10", "user10@mail.ru"));
        return userCollection;
    }

    @Test
    public void JsonUserTest(){
        Collection<User> userCollection = newUsers();
        File jsonFile = new File("users.json");
        Serializer serializer = new JsonUserSerializer();
        serializer.serialize (userCollection, jsonFile.getName());
        Assertions.assertTrue((jsonFile).exists());
        Assertions.assertTrue((jsonFile).length()>0);
        Deserializer deserializer = new JsonUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(jsonFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    public void XmlUserTest(){
        Collection<User> userCollection = newUsers();
        File xmlFile = new File("users.xml");
        Serializer serializer = new XmlUserSerializer();
        serializer.serialize (userCollection, xmlFile.getName());
        Assertions.assertTrue((xmlFile).exists());
        Assertions.assertTrue((xmlFile).length()>0);
        Deserializer deserializer = new XmlUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(xmlFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

    @Test
    public void CsvUserTest(){
        Collection<User> userCollection = newUsers();
        File csvFile = new File("users.csv");
        Serializer serializer = new CsvUserSerializer();
        serializer.serialize (userCollection, csvFile.getName());
        Assertions.assertTrue((csvFile).exists());
        Assertions.assertTrue((csvFile).length()>0);
        Deserializer deserializer = new CsvUserDeserializer();
        Collection<User> deserializeUsers = deserializer.deserialize(csvFile.getName());
        Assertions.assertTrue((userCollection).containsAll(deserializeUsers));
    }

}