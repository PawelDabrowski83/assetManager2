import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkNode {
    public static final Pattern MAIN_CONFIG = Pattern.compile("java NetworkNode -ident (\\d+) -tcpport (\\d+) (.*)");
    public static final Pattern ASSET_CONFIG = Pattern.compile("([A-Z]:\\d+)");

    public static void main(String[] args) {
        int id;
        int port;
        Map<Character, Integer> assets = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            System.out.println(i + " = " + args[i]);
        }

        if (args.length>2) {
            if ("-ident".equals(args[2])) {
                id = Integer.parseInt(args[3]);
            }
        }
        if (args.length > 5) {
            if ("-tcpport".equals(args[4])) {
                port = Integer.parseInt(args[5]);
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 6; i < args.length; i++) {
            stringList.add(args[i]);
        }
        Matcher matcher = ASSET_CONFIG.matcher(stringList.get(0));
    }
}
