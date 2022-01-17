import java.util.regex.Pattern;

public class NetworkNode {
    public static final Pattern MAIN_CONFIG = Pattern.compile("java NetworkNode -ident (\\d+) -tcpport (\\d+) (.*)");
    public static final Pattern ASSET_CONFIG = Pattern.compile("([A-Z]:\\d+)");

    public static void main(String[] args) {

    }
}
