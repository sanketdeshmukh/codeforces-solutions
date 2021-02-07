import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;



public class A {


	static int count = 0;
	public static void main(String[]args)throws IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int p = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<Integer>());

		while (p-- > 0)
			addEdge(sc.nextInt(), sc.nextInt(), graph);

		int ans = 0;
		boolean[] visited = new boolean[n + 1];
		Arrays.fill(visited, false);
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph.get(i).size() > 0) {
				if (dfs(i, -1, graph, visited) && count % 2 == 1)
					ans++;
				count = 0;
			}
		}

		out.println(((n - ans) % 2 == 1) ? ans + 1 : ans);
		out.close();

	}

	public static void addEdge(int u, int v, ArrayList<ArrayList<Integer>>graph) {
		graph.get(u).add(v);
		graph.get(v).add(u);
	}

	public static boolean dfs(int u, int p, ArrayList<ArrayList<Integer>>graph, boolean[] visited) {
		visited[u] = true;
		count++;
		ArrayList<Integer>g = graph.get(u);
		for (int i : g) {
			if (!visited[i]) {
				if (dfs(i, u, graph, visited))
					return true;
			}

			else if (i != p)
				return true;
		}

		return false;
	}




class FastReader {

	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException  e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	int [] nextIntArray(int n) {
		int [] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextInt();

		return arr;

	}


	long nextLong() {
		return Long.parseLong(next());
	}

	long [] nextLongArray(int n) {
		long [] arr = new long[n];
		for (int i = 0; i < n; i++)
			arr[i] = nextLong();

		return arr;

	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}

}
