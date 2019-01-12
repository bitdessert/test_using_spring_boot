package hbc.code.test.pricefetcher;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import hbc.code.test.pricefetcher.FAO.FAO;

//import org.json.JSONObject;
import hbc.code.test.pricefetcher.constants.CoinConstants;
import hbc.code.test.pricefetcher.vo.FetcherVO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Fetcher {

    private JsonObject priceObj = null;

    public Fetcher(){
        FAO fao = new FAO();
        try{
            priceObj = new JsonParser().parse(new FileReader(fao.getFile())).getAsJsonObject();
        }catch (IOException e){
            System.out.println("File not found");
//        }catch (ParseException e){
//            System.out.println("parse error");
//
        }


    }

//    private JSONObject getPriceObj(){
//        return this.priceObj;
//    }
//
    private void setVo(FetcherVO vo, String coinName, String marketName, String priceKeyName){
        vo.setCoin(coinName);
        vo.setLastPrice(priceObj.getAsJsonObject(coinName).getAsJsonObject(marketName).getAsJsonPrimitive(priceKeyName).getAsString());
    }
    public JsonObject fetchAllPrice(){
        FetcherVO btcVo = new FetcherVO();
        FetcherVO ethVo = new FetcherVO();
        FetcherVO eosVo = new FetcherVO();
        FetcherVO bchVo = new FetcherVO();
        FetcherVO xrpVo = new FetcherVO();

        this.setVo(btcVo, CoinConstants.BTC_KRW, "bithumb", "last");
        this.setVo(ethVo, CoinConstants.ETH_KRW, "bithumb", "last");
        this.setVo(eosVo, CoinConstants.EOS_KRW, "bithumb", "last");
        this.setVo(bchVo, CoinConstants.BCH_KRW, "bithumb", "last");
        this.setVo(xrpVo, CoinConstants.XRP_KRW, "bithumb", "last");

        JsonObject response = new JsonObject();
        response.addProperty(CoinConstants.BCH_KRW, btcVo.getLastPrice());
        response.addProperty(CoinConstants.ETH_KRW, ethVo.getLastPrice());
        response.addProperty(CoinConstants.EOS_KRW, eosVo.getLastPrice());
        response.addProperty(CoinConstants.BCH_KRW, bchVo.getLastPrice());
        response.addProperty(CoinConstants.XRP_KRW, xrpVo.getLastPrice());

        return response;

    }

    public JsonObject fetchPrice(String currency){
        FetcherVO vo = new FetcherVO();
        System.out.println(CoinConstants.DEFAULT_COIN.get(currency.toUpperCase()));
        setVo(vo, CoinConstants.DEFAULT_COIN.get(currency.toUpperCase()), "bithumb", "last");

        JsonObject response = new JsonObject();
        response.addProperty(CoinConstants.DEFAULT_COIN.get(currency.toUpperCase()), vo.getLastPrice());
        return response;
    }
}
