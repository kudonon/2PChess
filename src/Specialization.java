
public class Specialization {

	public boolean pCheck(int y1, int x1, int y2, int x2, int count, boolean enemy) {
		if (enemy == true) {
			if (y1 - y2 == 1 && Math.abs(x2 - x1) == 1) {
				return true;
			}
		} else if (x1 == x2 && y1 - y2 == 1 && even(count)) {
			return true;
		} else {
			return false;
		}
	return false;
	}
	
	public boolean rCheck(int y1, int x1, int y2, int x2, int count) {
		if ((((x1 != x2) && (y1 == y2))||((x1 == x2) && (y1 != y2))) && even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean bCheck(int y1, int x1, int y2, int x2, int count) {
		if (Math.abs(y2 - y1) == Math.abs(x2 - x1) && even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean kCheck(int y1, int x1, int y2, int x2, int count) {
		if (((y2 - y1 == 2 && x2 - x1 == 1) || (y2 - y1 == -2 && x2 - x1 == 1) || (y2 - y1 == -2 && x2 - x1 == -1) || (y2 - y1 == 2 && x2 - x1 == -1)) && even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean qCheck(int y1, int x1, int y2, int x2, int count) {
		if ((((x1 != x2) && (y1 == y2))||((x1 == x2) && (y1 != y2)) || (Math.abs(y2 - y1) == Math.abs(x2 - x1))) && even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean xCheck(int y1, int x1, int y2, int x2, int count) {
		if ((((x1 != x2) && (y1 == y2))||((x1 == x2) && (y1 != y2)) || (Math.abs(y2 - y1) == Math.abs(x2 - x1))) && even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean p2Check(int y1, int x1, int y2, int x2, int count, boolean enemy) {
		if (enemy == true) {
			if (y2 - y1 == 1 && Math.abs(x2 - x1) == 1) {
				return true;
			}
		} else if (x1 == x2 && Math.abs(y1 - y2) == 1 && !even(count)) {
			return true;
		} else {
			return false;
		}
	return false;
	}
	
	public boolean r2Check(int y1, int x1, int y2, int x2, int count) {
		if ((((x1 != x2) && (y1 == y2))||((x1 == x2) && (y1 != y2))) && !even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean b2Check(int y1, int x1, int y2, int x2, int count) {
		if (Math.abs(y2 - y1) == Math.abs(x2 - x1) && !even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean k2Check(int y1, int x1, int y2, int x2, int count) {
		if (((y2 - y1 == 2 && x2 - x1 == 1) || (y2 - y1 == -2 && x2 - x1 == 1) || (y2 - y1 == -2 && x2 - x1 == -1) || (y2 - y1 == 2 && x2 - x1 == -1)) && !even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean q2Check(int y1, int x1, int y2, int x2, int count) {
		if ((((x1 != x2) && (y1 == y2))||((x1 == x2) && (y1 != y2)) || (Math.abs(y2 - y1) == Math.abs(x2 - x1))) && !even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean x2Check(int y1, int x1, int y2, int x2, int count) {
		if ((((x1 != x2) && (y1 == y2))||((x1 == x2) && (y1 != y2)) || (Math.abs(y2 - y1) == Math.abs(x2 - x1))) && !even(count)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String turn(String one, String two, int count) {
		if (count % 2 == 0) {
			return one;
		} else {
			return two;
		}
	}
	
	public boolean even(int count) {
		if (count % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
}



