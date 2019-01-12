package hbc.code.test.pricefetcher.FAO;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

public class FAO{

    public File getFile() throws IOException{
        File file = new ClassPathResource("static/price.json").getFile();
        return file;

    }


}
