public class Encoded {
    private String inString;
    private int stringLen;
    private String outString;

    public Encoded() {
        this.inString = "";
        this.stringLen = 0;
        this.outString = "";
    }

    public Encoded(String inString) {
        this.inString = inString;
        this.stringLen = getStringLen(inString);
        this.outString = shiftChar(inString, this.stringLen);
    }

    public int getStringLen(String inString) {
        return (int) inString.chars().filter(c -> !Character.isWhitespace(c)).count();
    }

    public boolean checkStringValidity(String inString) {
        return inString.chars().allMatch(c -> Character.isUpperCase(c) || Character.isDigit(c) || Character.isWhitespace(c));
    }

    public String reversedString(String inString) {
        return new StringBuilder(inString).reverse().toString();
    }

    public String shiftChar(String inString, int stringLen) {
        String reversed = reversedString(inString);
        StringBuilder encoded = new StringBuilder();
        for (char c : reversed.toCharArray()) {
            encoded.append(shiftCharacter(c, stringLen));
        }
        return encoded.toString();
    }

    private char shiftCharacter(char c, int shift) {
        // Define the character set according to the provided table
        String chars = "ABCDEFGHIJ0123456789KLMNOPQRST !@#$%UVWXYZ";
        int index = chars.indexOf(c);
        if (index == -1) return c; // Just in case
        return chars.charAt((index + shift) % chars.length());
    }

    public String getOutString() {
        return this.outString;
    }
}
