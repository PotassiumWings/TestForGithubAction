import parallelepiped.Circ;
import parallelepiped.Cube;
import parallelepiped.Cuboid;
import parallelepiped.Parallelepiped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MainClass {

    private static Circ readCir(String str, Scanner scanner) {
        Circ cc;
        BigDecimal rad = new BigDecimal(scanner.next());
        switch (str) {
            case "2":
                cc = new Circ(str, rad,
                        new BigDecimal(scanner.next()),
                        new BigDecimal(scanner.next()));
                break;
            case "2.1":
            case "2.2":
                cc = new Circ(str, rad,
                        new BigDecimal("0"),
                        new BigDecimal(scanner.next()));
                break;
            default:
                cc = new Circ(str, rad,
                        new BigDecimal("0"), new BigDecimal("0"));
        }
        return cc;
    }

    private static Parallelepiped readP(String str, Scanner scanner) {
        Parallelepiped pp;
        if (str.equals("1")) {
            pp = new Parallelepiped(new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()));
        } else if (str.equals("1.1")) {
            pp = new Cuboid(new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()),
                    new BigDecimal(scanner.next()));
        } else {
            pp = new Cube(new BigDecimal(scanner.next()));
        }
        return pp;
    }

    private static BigDecimal intersectSum(HashMap<String, BigDecimal> a,
                                       HashMap<String, BigDecimal> b) {
        Set<String> key1 = a.keySet();
        BigDecimal ans = new BigDecimal("0");
        for (String key : key1) {
            if (a.containsKey(key) && b.containsKey(key)) {
                ans = ans.add(a.get(key));
            }
        }
        return ans;
    }

    private static HashMap<String, BigDecimal> union(
            HashMap<String, BigDecimal> a, HashMap<String, BigDecimal> b) {
        Set<String> key1 = a.keySet();
        Set<String> key2 = b.keySet();
        HashMap<String, BigDecimal> result = new HashMap<String, BigDecimal>();
        for (String key : key1) {
            if (!b.containsKey(key)) {
                result.put(key, a.get(key));
            }
        }
        for (String key : key2) {
            if (b.containsKey(key)) {
                result.put(key, b.get(key));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BigDecimal[] maxVolume = new BigDecimal[200010];
        String[] maxVType = new String[200010];
        BigDecimal[] sumVolume = new BigDecimal[200010];
        Scanner scanner = new Scanner(System.in);
        ArrayList<HashMap<String, BigDecimal>> map = new ArrayList<>();
        int n = (int)(scanner.nextDouble());
        int m = (int)(scanner.nextDouble());
        init(maxVolume, sumVolume, map, n);
        for (int i = 0; i < m; i++) {
            BigDecimal volume = new BigDecimal("0");
            String vs;
            int type = (int)(scanner.nextDouble());
            int pos = (int)(scanner.nextDouble());
            if (pos <= 0 || pos > n || ((type == 1 || type == 2)
                    && map.get(pos).isEmpty())) {
                System.out.println("Sorry, the set is empty!");
                continue;
            }
            if (type == 1) {
                System.out.println(maxVolume[pos]);
            } else if (type == 2) {
                System.out.println(maxVType[pos]);
            } else if (type == 3) {
                System.out.println(sumVolume[pos]);
            } else if (type == 5) {
                int b = (int)(scanner.nextDouble());
                sumVolume[++n] = sumVolume[pos].add(sumVolume[b])
                        .subtract(intersectSum(map.get(pos), map.get(b)));
                map.add(n, union(map.get(pos), map.get(b)));
                if (maxVolume[pos].compareTo(maxVolume[b]) >= 0 &&
                        maxVType[pos] != null) {
                    maxVolume[n] = maxVolume[pos];
                    maxVType[n] = maxVType[pos];
                } else {
                    maxVolume[n] = maxVolume[b];
                    maxVType[n] = maxVType[b];
                }
            } else {
                String str = scanner.next();
                if (str.toCharArray()[0] == '1') {
                    Parallelepiped pp = readP(str, scanner);
                    volume = volume.add(pp.getVolume());
                    vs = str + " " + pp.getDes();
                } else {
                    Circ cc = readCir(str, scanner);
                    volume = volume.add(cc.getVolume());
                    vs = str + " " + cc.getDes();
                }
                if (!map.get(pos).containsKey(vs)) {
                    map.get(pos).put(vs, volume);
                    sumVolume[pos] = sumVolume[pos].add(volume);
                    if (volume.compareTo(maxVolume[pos]) >= 0) {
                        maxVolume[pos] = volume;
                        maxVType[pos] = vs;
                    }
                }
            }
        }
    }

    private static void init(BigDecimal[] maxVolume, BigDecimal[] sumVolume,
                             ArrayList<HashMap<String, BigDecimal>> map,
                             int n) {
        for (int i = 0; i < 200010; i++) {
            maxVolume[i] = new BigDecimal("0");
            sumVolume[i] = new BigDecimal("0");
        }
        for (int i = 0; i <= n; i++) {
            map.add(i, new HashMap<String, BigDecimal>());
        }
    }
}