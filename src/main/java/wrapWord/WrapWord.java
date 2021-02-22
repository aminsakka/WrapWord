package wrapWord;

public class WrapWord {
    final static String SPACE = " " ;

    //V1 return  line.replaceAll(" ", "\n");
    public static String wrap(String line, int maxLength) {
        if(line.length() <= maxLength) {
            return line;
        }

        int space = line.substring(0, maxLength).lastIndexOf(SPACE);

        if(!spaceIsInWordToBreak(space)) {
           return wrapWord(line, maxLength, space, space+1);
        } else
            if(line.charAt(maxLength) == ' ') {
                return wrapWord(line, maxLength, maxLength, maxLength + 1);
            }
            else {
                //TODO : improve me
                return wrapWord(line, maxLength, maxLength, maxLength);
            }
    }

    private static boolean spaceIsInWordToBreak(int space) {
        return space == -1;
    }

    private static String wrapWord(String line, int maxLength, int breakpoint, int startAt) {
        return line.substring(0, breakpoint) + "\n" + wrap(line.substring(startAt), maxLength);
    }
}
