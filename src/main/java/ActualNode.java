import java.util.Map;

public class ActualNode {
    private int id;
    private int port;
    private Map<Character, Integer> assets;

    public ActualNode(int id, int port, Map<Character, Integer> assets) {
        this.id = id;
        this.port = port;
        this.assets = assets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Map<Character, Integer> getAssets() {
        return assets;
    }

    public void setAssets(Map<Character, Integer> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "ActualNode{" +
                "id=" + id +
                ", port=" + port +
                ", assets=" + assets +
                '}';
    }
}
