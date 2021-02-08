class ReverseInteger {
    public int reverse(int x) {
        StringBuilder temp = new StringBuilder();
        temp.append(Math.abs(x));
        try{
            return Integer.signum(x)*Integer.valueOf(temp.reverse().toString());
        } catch(NumberFormatException nu) {
            return 0;
        }
    }
}
