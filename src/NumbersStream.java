public class NumbersStream {
	private int start = 1;
	private int end = 0;
	private int step = 1;
	private boolean infinite = true; // set to false if "end" is set
	private int n = 1;

	NumbersStream()					{ }
	NumbersStream(int start)			{ Init(start); }
	NumbersStream(int start, int end)		{ Init(start,end); }
	NumbersStream(int start, int end, int step)	{ Init(start,end,step); }

	public void Init(int start) {
		this.start = start; n = start;
	}
	public void Init(int start, int end) {
		Init(start); this.end = end;
		infinite = false;
	}
	public void Init(int start, int end, int step) {
		Init(start, end); this.step = step;
	}
	public int next() {
		int next = n;
		n += step;
		return next;
	}
	public boolean isLast() {
		if (infinite) {
			return false;
		} else {
			// not infinite?? then "end" must be defined!
			if (step > 0) {
				return n > end;
			} else {
				return n < end;
			}
		}
	}
	public void check() {
		System.out.format("(%d, %d, %d)\n", start, end, step);
	}
}
