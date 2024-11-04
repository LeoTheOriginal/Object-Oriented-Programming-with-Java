import java.util.Scanner;
import java.util.HashMap;

class Domino {
    int x;
    int y;

    public Domino(int p1, int p2) {
        this.x = p1;
        this.y = p2;
    }
}

public class lab02 {
    public static void main(String[] args) {
        System.out.print("Enter the number of domino pieces: ");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Domino[] t = new Domino[N];
        System.out.println("Enter values for each piece:");
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            t[i] = new Domino(x, y);
        }

        if (!(checkDom(0, -1, t, N))) {
            System.out.println("NIE");
        } else {
            HashMap<Integer, Integer> occurrences = countOccurrences(t, N);
            boolean hasOddOccurrences = false;

            for (int count : occurrences.values()) {
                if (count % 2 != 0) {
                    hasOddOccurrences = true;
                    break;
                }
            }

            if (hasOddOccurrences) {
                System.out.println("TAK");
                System.out.println("Wynik:");
                for (int key : occurrences.keySet()) {
                    if (occurrences.get(key) % 2 != 0) {
                        System.out.print(key + " ");
                    }
                }
            } else {
                System.out.println("NIE");
            }
        }

    }

    private static boolean checkDom(int i, int last, Domino[] tab, int N) {
        boolean[] used = new boolean[N];
        if (last == -1) {
            for (int j = 0; j < N; j++) {
                used[j] = false;
            }
        }
        if (i == N) {
            return true;
        }
        for (int k = 0; k < N; k++) {
            if (!used[k]) {
                used[k] = true;
                if (last == -1) {
                    return checkDom(i + 1, tab[k].x, tab, N) || checkDom(i + 1, tab[k].y, tab, N);
                }
                if (last == tab[k].x) {
                    if (checkDom(i + 1, tab[k].y, tab, N)) {
                        return true;
                    }
                }
                if (last == tab[k].y) {
                    if (checkDom(i + 1, tab[k].x, tab, N)) {
                        return true;
                    }
                }
                used[k] = false;
            }
        }
        return false;
    }

    private static HashMap<Integer, Integer> countOccurrences(Domino[] tab, int N) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int x = tab[i].x;
            int y = tab[i].y;

            occurrences.put(x, occurrences.getOrDefault(x, 0) + 1);
            occurrences.put(y, occurrences.getOrDefault(y, 0) + 1);
        }

        return occurrences;
    }
}
