package hbc.code.test.pricefetcher.constants;

import java.util.HashMap;

public class CoinConstants {
    public static final String BTC_KRW = "BTC_KRW";
    public static final String ETH_KRW = "ETH_KRW";
    public static final String EOS_KRW = "EOS_KRW";
    public static final String BCH_KRW = "BCH_KRW";
    public static final String XRP_KRW = "XRP_KRW";

    public static final String BTC = "BTC";
    public static final String ETH = "ETH";
    public static final String EOS = "EOS";
    public static final String BCH = "BCH";
    public static final String XRP = "XRP";


    public static final HashMap<String, String> DEFAULT_COIN = new HashMap<>();

    static{
        DEFAULT_COIN.put(BTC, BTC_KRW);
        DEFAULT_COIN.put(ETH, ETH_KRW);
        DEFAULT_COIN.put(EOS, EOS_KRW);
        DEFAULT_COIN.put(BCH, BCH_KRW);
        DEFAULT_COIN.put(XRP, XRP_KRW);
    }

}
