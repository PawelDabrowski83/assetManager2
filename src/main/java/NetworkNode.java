import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkNode {
    public static final Pattern ASSET_CONFIG = Pattern.compile("([A-Z]):(\\d+)");
    public static final Pattern FIRST_WORD = Pattern.compile("(\\S+).*$");

    public static void main(String[] args) throws IOException {
        int id = 0;
        int port = 0;
        List<Asset> assets = new ArrayList<>();

//        for (int i = 0; i < args.length; i++) {
//            System.out.println(i + " = " + args[i]);
//        }

        if (args.length>0) {
            if ("-ident".equals(args[0])) {
                id = Integer.parseInt(args[1]);
                System.out.println("matched: " + id);
            }
        }
        if (args.length > 2) {
            if ("-tcpport".equals(args[2])) {
                port = Integer.parseInt(args[3]);
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

        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(actualNode.getPort());

        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println("Opening socket");
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                String messageReceived = "";
                while (!"-quit".equals(messageReceived)) {
                    messageReceived = bufferedReader.readLine();
                    matcher = FIRST_WORD.matcher(messageReceived);
                    String command = matcher.find() ? matcher.group(1) : "";
                    System.out.println("Client: " + messageReceived);
                    System.out.println("Command: " + command);

                    String messageToSend = "";
                    switch (command) {
                        case "-info":
                            messageToSend = ActualNode.allNodes.toString();
                            break;
                        case "-free":

                            break;
                        case "-reserve":
                            break;
                        default:
                            messageToSend = "Command is not recognized.";
                    }

                    bufferedWriter.write(messageToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                }
                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
