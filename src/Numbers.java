import javafx.scene.paint.Color;

public class Numbers {

	
	public static double getJessKey() {
		return jessKey;
	}

	public static void setJessKey(double jessKey) {
		Numbers.jessKey = jessKey;
	}

	public static double getG() {
		return g;
	}

	public static void setG(double g) {
		Numbers.g = g;
	}

	public static double getP() {
		return p;
	}

	public static void setP(double p) {
		Numbers.p = p;
	}

	public static double getJessPrivate() {
		return jessPrivate;
	}

	public static void setJessPrivate(double jessPrivate) {
		Numbers.jessPrivate = jessPrivate;
	}

	public static double getLukePrivate() {
		return lukePrivate;
	}

	public static void setLukePrivate(double lukePrivate) {
		Numbers.lukePrivate = lukePrivate;
	}
	
	public double getLukeKey() {
		return lukeKey;
	}

	public void setLukeKey(double lukeKey) {
		this.lukeKey = lukeKey;
	}
	
	
	public static double getLukeSharedKey() {
		return lukeSharedKey;
	}

	public static void setLukeSharedKey(double lukeSharedKey) {
		Numbers.lukeSharedKey = lukeSharedKey;
	}

	public static double getJessSharedKey() {
		return jessSharedKey;
	}

	public static void setJessSharedKey(double jessSharedKey) {
		Numbers.jessSharedKey = jessSharedKey;
	}

	
	
	static double jessSharedKey;
	static double lukeSharedKey;
	
	

	static double jessKey;
	static double lukeKey;
	
	static double g;
	static double p;
	
	static double jessPrivate;
	static double lukePrivate;
	
	static double sharedKey;
	
	public static double getSharedKey() {
		return sharedKey;
	}

	public static void setSharedKey(double sharedKey) {
		Numbers.sharedKey = sharedKey;
	}



	public Color gColor = Color.GREEN;
	public Color pColor = Color.RED;
	public Color jessPrivateNumberColor = Color.HOTPINK;
	public Color lukePrivateNumberColor = Color.BLUE;
	public Color jessSharedKeyColor = Color.PURPLE;
	public Color lukeSharedKeyColor = Color.ORANGE;
	public Color sharedKeyColor = Color.BROWN;
	
	
	
	
}
