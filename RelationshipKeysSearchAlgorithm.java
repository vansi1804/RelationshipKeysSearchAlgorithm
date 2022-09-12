
import java.util.ArrayList;
import java.util.Scanner;

/**
 * RelationshipKeysSearchAlgorithm
 */
public class RelationshipKeysSearchAlgorithm {

    public static void Keys() {
        ArrayList<String> G = new ArrayList<>();
        ArrayList<ArrayList<String>> Fa = new ArrayList<>(new ArrayList<>());
        ArrayList<ArrayList<String>> Fb = new ArrayList<>(new ArrayList<>());
        try (Scanner sc = new Scanner(System.in)) {
            String x;
            do {
                System.out.println("1. Nhập G");
                System.out.println("2. Nhập F");
                System.out.print("===> Nhập nào: ");
                x = sc.nextLine();
                switch (x) {
                    case "1":
                        String g;
                        do {
                            System.out.print("Nhập G" + G.size() + "(Để trống và enter để ngưng nhập): ");
                            g = sc.nextLine();
                            while (G.contains(g)) {
                                System.out.println("=====> Trùng lặp dữ liệu, kiểm tra lại G và nhập lại.");
                                System.out.println("=====> G" + G.toString());
                                System.out.print("Nhập lại nè (Để trống và enter để ngưng nhập): ");
                                g = sc.nextLine();
                            }
                            if (!g.isBlank()) {
                                G.add(g);
                            }
                        } while (!g.isBlank());
                        break;

                    case "2":
                        ArrayList<String> fa = new ArrayList<>();
                        ArrayList<String> fb = new ArrayList<>();
                        String f;
                        do {
                            System.out.print("Nhập Fa" + Fa.size() + fa.size() + "(Để trống và enter để ngưng nhập): ");
                            f = sc.nextLine();
                            while (fa.contains(f)) {
                                System.out.println("=====> Trùng lặp dữ liệu, kiểm tra lại Fa và nhập lại.");
                                System.out.println("=====> Fa" + fa.toString());
                                System.out.print("Nhập lại nè (Để trống và enter để ngưng nhập): ");
                                f = sc.nextLine();
                            }
                            if (!f.isBlank()) {
                                if (!G.contains(f)) {
                                    System.out.println(
                                            "\"" + f + "\"" + " không nằm trong G" + G.toString() + ". Nhập lại cái:");
                                } else {
                                    fa.add(f);
                                }
                            }
                        } while (!f.isBlank());
                        Fa.add(fa);
                        do {
                            System.out.print("Nhập Fb" + Fb.size() + fb.size() + "(Để trống và enter để ngưng nhập): ");
                            f = sc.nextLine();
                            while (fa.contains(f)) {
                                System.out.println("=====> Trùng lặp dữ liệu, kiểm tra lại Fa và nhập lại.");
                                System.out.println("=====> Fa" + fb.toString());
                                System.out.print("Nhập lại nè (Để trống và enter để ngưng nhập): ");
                                f = sc.nextLine();
                            }
                            if (!f.isBlank()) {
                                if (!G.contains(f)) {
                                    System.out.println(
                                            "\"" + f + "\"" + " không nằm trong G" + G.toString() + ". Nhập lại cái:");
                                } else {
                                    fb.add(f);
                                }
                            }
                        } while (!f.isBlank());
                        Fb.add(fb);
                        System.out.println(Fa.toString());
                        System.out.println(Fb.toString());
                        break;
                }
            } while (!x.isBlank());
        }
        Keys(G, Fa, Fb);
    }

    public static ArrayList<String> testG() {
        ArrayList<String> G = new ArrayList<>();
        G.add("MsGV");
        G.add("HoTen");
        G.add("MsMH");
        G.add("TenMH");
        G.add("Phong");
        G.add("Thu");
        G.add("Ca");
        return G;
    }

    public static ArrayList<ArrayList<String>> testFa() {
        ArrayList<ArrayList<String>> Fa = new ArrayList<>();
        ArrayList<String> f1 = new ArrayList<>();
        f1.add("MsGV");
        Fa.add(f1);
        ArrayList<String> f2 = new ArrayList<>();
        f2.add("MsMH");
        Fa.add(f2);
        ArrayList<String> f3 = new ArrayList<>();
        f3.add("Phong");
        f3.add("Thu");
        f3.add("Ca");
        Fa.add(f3);
        ArrayList<String> f4 = new ArrayList<>();
        f4.add("MsGV");
        f4.add("Thu");
        f4.add("Ca");
        Fa.add(f4);
        return Fa;
    }

    public static ArrayList<ArrayList<String>> testFb() {
        ArrayList<ArrayList<String>> Fb = new ArrayList<>();
        ArrayList<String> f1 = new ArrayList<>();
        f1.add("HoTen");
        Fb.add(f1);
        ArrayList<String> f2 = new ArrayList<>();
        f2.add("TenMH");
        Fb.add(f2);
        ArrayList<String> f3 = new ArrayList<>();
        f3.add("MsMH");
        Fb.add(f3);
        ArrayList<String> f4 = new ArrayList<>();
        f4.add("Phong");
        Fb.add(f4);
        return Fb;
    }

    public static void Keys(ArrayList<String> G, ArrayList<ArrayList<String>> Fa, ArrayList<ArrayList<String>> Fb) {
        System.out.println("G = " + G.toString());
        System.out.print("F = {");
        for (int i = 0; i < Fa.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(Fa.get(i).toString());
            System.out.print("->");
            System.out.print(Fb.get(i).toString());
        }
        System.out.println("}");

        ArrayList<String> Keys = new ArrayList<>();
        for (ArrayList<String> fa : Fa) {
            for (String f : fa) {
                if (!Keys.contains(f)) {
                    Keys.add(f);
                }
            }
        }
        for (ArrayList<String> fb : Fb) {
            for (String f : fb) {
                if (Keys.contains(f)) {
                    Keys.remove(f);
                }
            }
        }
        System.out.println("Keys = " + Keys.toString());
    }

    public static void main(String[] args) {

        Keys(testG(), testFa(), testFb());
        // Keys();
    }
}