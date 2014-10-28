package topCoder.round637;

public class PathGameDiv2 {

	public int calc(String[] board) {
		int size = board[0].length();
		int W = 0;
		int B = 0;
		int flag = 3;
		for (int i = 0; i < size; i++) {
			if (board[0].charAt(i) == '.') {
				W++;
			} else {
				if (flag == 1) {
					B++;
					flag = 0;
				}
			}
			if (board[1].charAt(i) == '.') {
				W++;
			} else {
				if (flag == 0) {
					B++;
					flag = 1;
				}
			}
		}
		return W - size - B;

	}
}