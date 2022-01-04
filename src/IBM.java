import java.util.*;

public class IBM {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String s = "c4";
        list.add("u2");
        list.add("r7");
        list.add("d4");
        findFinalPosition(s, list);
    }

    private static void findFinalPosition(String startPosition, List<String> movements) {
        String[] arr = startPosition.split("");
        String str = arr[0];
        char startPositionChar = str.charAt(0);
        int startPositionNum = Integer.parseInt(arr[1]);

        ArrayList<String> result = new ArrayList<>();

        for(int i = 0;i < movements.size();i++) {
            String[] everyDirection = movements.get(i).split("");
            String pos = everyDirection[0];
            char position = pos.charAt(0);
            int positionNum = Integer.parseInt(everyDirection[1]);

            if(position == 'u') { // then i need to change number -- positionNum will change
                result.add(startPositionChar + "" + (startPositionNum + positionNum));
                startPositionNum = positionNum + startPositionNum;
                if(startPositionChar > 'h' || startPositionNum > 8) {
                    System.out.println("Invalid input");
                    return;
                }
            } else if(position == 'd') { // then i need to change number
                result.add(startPositionChar + "" + (startPositionNum - positionNum));
                startPositionNum = (startPositionNum - positionNum);
                if(startPositionChar > 'h' || startPositionNum > 8) {
                    System.out.println("Invalid input");
                    return;
                }
            } else if(position == 'r') { // then i need to change char
                startPositionChar = (char) (startPositionChar + positionNum);
                result.add(startPositionChar + "" + startPositionNum);
                if(startPositionChar > 'h' || startPositionNum > 8) {
                    System.out.println("Invalid input");
                    return;
                }
            } else if(position == 'l') { // then i need to change char
                startPositionChar = (char) (startPositionChar - positionNum);
                result.add(startPositionChar + "" + startPositionNum);
                if(startPositionChar > 'h' || startPositionNum > 8) {
                    System.out.println("Invalid input");
                    return;
                }
            }
        }

        System.out.println(result.get(result.size() - 1));
    }
}