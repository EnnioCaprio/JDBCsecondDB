import java.sql.SQLException;

import controller.ConnessioneDatabase;
import model.Persone;
import model.Titolo;
import view.View;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Persone p = new Persone();
		
		Titolo t = new Titolo();
		
		View v = new View();
		
		v.view(p,t);

	}

}
