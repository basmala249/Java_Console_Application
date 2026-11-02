package project;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
    // create a reader
    Reader reader = Files.newBufferedReader(Paths.get("data.json"));

    // create parser
    JsonArray parser = (JsonArray) Jsoner.deserialize(reader);

    parser.forEach(obj -> {
        JsonObject jsonObject = (JsonObject) obj;
        String id = (String) jsonObject.get("id");
        String author = (String) jsonObject.get("author");
        String title = (String) jsonObject.get("title");
        BigDecimal price = (BigDecimal) jsonObject.get("price");
        String genre = (String) jsonObject.get("genre");
        String description = (String) jsonObject.get("description");
        String publish_date = (String) jsonObject.get("publish_date");
        System.out.println("Book ID: " + id);
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
        System.out.println("Genre: " + genre);
        System.out.println("Description: " + description);
        System.out.println("Publish Date: " + publish_date);
        
    });
    //close reader
    reader.close();

} catch (Exception ex) {
    ex.printStackTrace();
}
    }
}
