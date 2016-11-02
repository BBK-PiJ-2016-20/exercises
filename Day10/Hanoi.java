/**
 * A legend says that, somewhere in the East, near Hanoi, there is a temple. In
 * the temple, there are three posts. In the posts, there are 64 discs of 64
 * different sizes. When the world was created, all the discs were in the first
 * post; when all the discs are moved to the last post, the world will end. The
 * monks in the temple move the discs between posts, but they must obey two
 * simple rules. First, only one disc can be moved at a time, from one post to
 * another post (it cannot be left anywhere else). Last, but not least, a disc
 * can only be placed on top of a bigger disc, never on top of a smaller disc.
 * The smallest disc can be placed on any post (all other discs are bigger); the
 * biggest disc can only be placed on an empty post. Create a method that
 * calculates the number of moves necessary to move a set of n Hanoi disks from
 * the initial post to the last post.
*/

public class Hanoi {
    /**
     * Return the number of moves required to move n disks from the first post
     * to the last post.
     */
    public static int moves(int n) {
        if (n == 1) {
            return 1;
        }

        // To move n disks from post 1 to post 3, you must first move
        // n - 1 disks to post 2, then move the bottom disk to post 3
        // then move n - 1 disks to post 3.
        return 2 * moves(n - 1) + 1; 
    }

    public static void main(String[] args) {
        int n;
        if (args.length < 1) {
            n = 64;
        } else {
            n = Integer.parseInt(args[0]);
        }

        System.out.println(moves(n));
    }
}