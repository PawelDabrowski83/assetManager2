import java.util.*;

public class ActualNode {
    private int id;
    private int port;
    private List<Asset> assets;
    static List<ActualNode> allNodes = new ArrayList<>();

    public ActualNode(int id, int port, List<Asset> assets) {
        this.id = id;
        this.port = port;
        this.assets = assets;
        allNodes.add(this);
    }

    public static List<ActualNode> getAllNodes() {
        return allNodes;
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

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
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

    public static String getAllAssets() {
        Map<String, Integer> map = new TreeMap<>();
        allNodes.forEach(n -> n.assets.forEach(a -> map.put(a.getSymbol(), map.getOrDefault(a.getSymbol(), 0)+1)));
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> sb.append(k).append(":").append(v).append(" "));
        return sb.toString().trim();
    }
}
