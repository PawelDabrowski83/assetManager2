public class Asset {
    static public int count;
    private int id;
    private String symbol;
    private int clientId = -1;

    public Asset(String symbol) {
        this.id = count++;
        this.symbol = symbol;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", symbol=" + symbol +
                ", clientId=" + clientId +
                '}';
    }
}
