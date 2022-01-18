public class Asset {
    static public int count;
    private int id;
    private char symbol;
    private int clientId;

    public Asset(int id, char symbol, int clientId) {
        this.id = count++;
        this.symbol = symbol;
        this.clientId = -1;
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

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
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
