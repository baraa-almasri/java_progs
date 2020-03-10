public class parsing_strings {
    public static void main(String[] args){
        String  k = "10";
        int i = 5;
        int l = Integer.parseInt(k);
        double d = Double.parseDouble(k);
        long lo = Long.parseLong(k);
        //and so on
        System.out.println(i + l);
        // also operations can be done i.e:
        double v = Double.parseDouble(k) *2;
        System.out.println(i + v);
        System.out.println((i + l)*5);
    }
}
