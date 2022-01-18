import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkNode {
    public static final Pattern ASSET_CONFIG = Pattern.compile("([A-Z]):(\\d+)");

    public static void main(String[] args) {
        int id = 0;
        int port = 0;
        List<Asset> assets = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            System.out.println(i + " = " + args[i]);
        }

        if (args.length>0) {
            if ("-ident".equals(args[2])) {
                id = Integer.parseInt(args[3]);
            }
        }
        if (args.length > 2) {
            if ("-tcpport".equals(args[4])) {
                port = Integer.parseInt(args[5]);
            }
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 4; i < args.length; i++) {
            stringList.add(args[i]);
        }
        stringList.forEach(System.out::println);

        Matcher matcher;
        for (int i = 0; i < stringList.size(); i++) {
            matcher = ASSET_CONFIG.matcher(stringList.get(i));
            while(matcher.find()) {
                System.out.println(matcher.group());
                for (int j = 0; j < Integer.parseInt(matcher.group(2)); j++) {
                    Asset asset = new Asset(matcher.group(1));
                    assets.add(asset);
                }

            }
        }

        ActualNode actualNode = new ActualNode(id, port, assets);
        System.out.println(actualNode);
        System.out.println("ALL:");
        System.out.println(ActualNode.allNodes);
    }
}
