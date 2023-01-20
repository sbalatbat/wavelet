public class SearchEngine {

    String[] strings;

    public String handleRequest(URI url) {
        // Prints out all the items in the list & prompts
        if (url.getPath().equals("/")) {
            System.out.println("Here is the current list content.");
            for (int i=0; i<strings.length; i++) {
                System.out.println(strings[i]);
            }
            System.out.println();
            return String.format("List items total: %d", strings.length);
        }
        // add TODO
        /*
        else if (url.getPath().equals("/increment")) {
            num += 1;
            if (num==FUNNY_NUMBER) {
                return String.format("Number incremented!") + "\nNice.";
            }
            else {
                return String.format("Number incremented!") + "\nGet Rekt!";
            }
        }
        // search query TODO
        else if (url.getPath().contains("/add")) {
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
        }
        else {
            return "404 Not Found!";
        }
        */
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
