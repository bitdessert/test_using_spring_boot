package hbc.code.test.pricefetcher;

import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/data")
public class API {
    @GetMapping(value = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
    public String allCurrency(){
        Fetcher fetcher = new Fetcher();
        return fetcher.fetchAllPrice().toString();
    }
    @GetMapping(value = "/currency/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String currency(@PathVariable("currency") String currency){
        Fetcher fetcher = new Fetcher();
        return fetcher.fetchPrice(currency).toString();
    }
}
