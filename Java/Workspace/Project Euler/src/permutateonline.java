
public class permutateonline {

	public static void main(String[] args) {
		permutation("", "ABCD");
	}

	private static void permutation(String prefix, String str) {
		// n = 4 for ABCD
		int n = str.length();
		
		// N is not 0
		if (n == 0)
			System.out.println(prefix);
		else {
			// for four times
			for (int i = 0; i < n; i++)
				//
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1));
		}
	}

}
