package part9;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//https://www.e-olymp.com/ru/submissions/6295260

public class Task1 {

    private static ArrayList<ArrayList<Integer>> graph;
    private static ArrayList<Integer> top = new ArrayList<>();
    private static int[] used;
    private static int flag = 0;

    private static void solve(final FastScanner in, final PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new ArrayList<>();
        used = new int[n + 1];
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++)
        {
            int a = in.nextInt(), b = in.nextInt();
            graph.get(a).add(b);
        }

        for(int i = 1; i <= n; i++)
            if (used[i] == 0) dfs(i);

        if (flag == 1) out.println(-1);
        else
            for(int i = top.size() - 1; i >= 0; i--)
                out.print(top.get(i) + " ");
        out.println();
    }

    private static void dfs(int v) {
        used[v] = 1;
        for(int i = 0; i < graph.get(v).size(); i++) {
            int to = graph.get(v).get(i);
            if (used[to] == 1) flag = 1;
            if (used[to] == 0) dfs(to);
        }
        used[v] = 2;
        top.add(v);
    }

    private static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }

}
