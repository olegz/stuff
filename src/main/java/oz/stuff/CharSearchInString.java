package oz.stuff;

public class CharSearchInString {

    public static void main(String[] args) {
        String[] driverStrings = "java.util.concurrent.atomic.AtomicInteger".split("(?<=\\G.{4})");
        String[] comparableStrings = "avrutcimIr".split("(?<=\\G.{3})");
        // should return true as all characters in 'comparableStrings' are
        // present in 'driverStrings'
        System.out.println(performCompare(driverStrings, comparableStrings));
    }

    /**
     *
     */
    private static boolean performCompare(String[] driverStrings, String[] comparableStrings) {
        int csCount = 0;
        String driverString = "";
        for (int dsCount = 0; dsCount < driverStrings.length;) {
            innerLoop: for (; csCount < comparableStrings.length;) {
                String comparableString = comparableStrings[csCount];
                if (compares(driverString, comparableString)) {
                    csCount++;
                } else {
                    driverString += driverStrings[dsCount];
                    dsCount++;
                }
                break innerLoop;
            }
            if (csCount == comparableStrings.length) {
                break;
            }
        }
        // will return true if all strings in 'comparableStrings' were matched
        // to at least one string in 'driverStrings'
        return csCount == comparableStrings.length;
    }

    private static boolean compares(String a, String b) {
        byte[] bArray = b.getBytes();
        for (int i = 0; i < bArray.length; i++) {
            byte x = bArray[i];
            if (!a.contains((char) x + "")) {
                return false;
            }
        }
        return true;
    }
}
