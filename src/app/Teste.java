package app;

import java.sql.SQLException;

import model.Feedback;
import repository.FeedbackDAO;

public class Teste {

	public static void main(String[] args) throws SQLException {
		
		
		FeedbackDAO dao = new FeedbackDAO();
		Feedback teste = new Feedback();
		
		teste.setConteudo("TESTANDO UPDATE VIA JAVA");
		teste.setId(1);
		dao.update(teste);
		
		

	}

}
