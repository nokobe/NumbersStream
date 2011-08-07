import java.util.ArrayList;

public class Numbers {
	int start = 1;
	int end = 0;
	int step = 1;

	public static void main(String[] arguments) {
		int start = 0;
		int end = 0;
		int step = 0;

		if (arguments.length > 3) { usage(); }

		ArrayList<Integer> array = new ArrayList<Integer>();
		for (String f : arguments ) {
			try {
				array.add(Integer.parseInt(f));
			} catch (NumberFormatException e) {
				System.out.format("ERROR: \"%s\" is not an integer\n", f);
				usage();
			}
		}
		NumbersStream ns = new NumbersStream();
		if (arguments.length == 1) { ns.Init(array.get(0)); }
		if (arguments.length == 2) { ns.Init(array.get(0), array.get(1)); }
		if (arguments.length == 3) { ns.Init(array.get(0), array.get(1), array.get(2)); }
		while (! ns.isLast()) {
			System.out.println(ns.next());
		}
	}
	private static void usage() {
		System.out.println("Numbers [start [end [step]]]");
		System.exit(0);
	}
}
