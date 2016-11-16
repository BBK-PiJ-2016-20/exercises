public class McCarthy91 {
    public static int mcCarthy91(int n, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("---");
        }
        System.out.println(n);
        if (n > 100) {
            return n - 10;
        } else {
            return mcCarthy91(mcCarthy91(n + 11, depth + 1), depth + 1);
        }
    }

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = 50;
        } else {
            n = Integer.parseInt(args[0]);
        }
        System.out.println(mcCarthy91(n, 0));
    }
}