import controllers.UserController;

public class main {

	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			UserController userC = new UserController();
			userC.openLoginView();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
