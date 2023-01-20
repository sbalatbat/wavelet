import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;

    private static final int FUNNY_NUMBER = 69;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Hello there.\nMerp Number: %d", num);
        } else if (url.getPath().equals("/increment")) {
            num += 1;
            if (num==FUNNY_NUMBER) {
                return String.format("Number incremented!") + "\nNice.";
            }
            else {
                return String.format("Number incremented!") + "\nGet Rekt!";
            }
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("count")) {
                    num += Integer.parseInt(parameters[1]);
                    if (num==FUNNY_NUMBER) {
                        return String.format("Number increased by %s! It's now %d", parameters[1], num) + "\nNice.";
                    }
                    else {
                        return String.format("Number increased by %s! It's now %d", parameters[1], num) + "\nRoasted!";
                    }
                }
            }
            return "404 Not Found!\nGit gud!";
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
