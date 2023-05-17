package stengsogning;

public class AppStrengSøgning {
    public static int find(String sm, String m) {
        int indeks = -1;
        int i = 0;
        while (indeks == -1 && i <= sm.length() - m.length()) {
            if (match(sm, m, i)) {
                indeks = i;
            } else {
                i++;
            }
        }
        return indeks;
    }

    private static boolean match(String sm, String m, int i) {
        boolean foundDiff = false;
        int j = 0;
        while (!foundDiff && j < m.length()) {
            if (sm.charAt(i + j) != m.charAt(j)) {
                foundDiff = true;
            } else {
                j++;
            }
        }
        return !foundDiff;
    }

    public static void main(String[] args) {
        System.out.println(find("God juleferie", "jul"));
        String sm = "God juleferie";
        String m = "jul";
        System.out.println(sm.indexOf(m));
    }

}
