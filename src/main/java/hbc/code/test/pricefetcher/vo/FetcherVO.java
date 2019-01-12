package hbc.code.test.pricefetcher.vo;

public class FetcherVO {
    private String coin = null;

    private String lastPrice = null;

    public String getCoin() {
        return coin;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }
}
