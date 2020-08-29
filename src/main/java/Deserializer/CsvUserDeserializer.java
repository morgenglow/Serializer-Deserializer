package Deserializer;

import User.User;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class CsvUserDeserializer implements Deserializer {
    @Override
    public Collection<User> deserialize(String inputFile) {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        File input = new File(inputFile);
        try {
            MappingIterator<User> it = csvMapper.readerFor(User.class).with(csvSchema).readValues(input);
            return it.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
