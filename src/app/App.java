package app;

import java.sql.SQLException;
import java.util.Scanner;

import lists.ListFb;
import model.Feedback;
import repository.FeedbackDAO;

public class App {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);
        FeedbackDAO daoFb = new FeedbackDAO();

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("MENU");
            System.out.println("1 - Cadastrar feedback");
            System.out.println("2 - Ler Feedbacks");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    Feedback newFeedback = new Feedback();
                    System.out.println("Informe o motivo do feedback \nSugestão/Reclamação");
                    newFeedback.setMotivo(input.next());
                    System.out.println("Informe o assunto do feedback");
                    input.nextLine();
                    newFeedback.setAssunto(input.next());
                    System.out.println("Informe a mensagem do feedback");
                    input.nextLine();
                    newFeedback.setConteudo(input.nextLine());
                    newFeedback.setStatus("0");

                    daoFb.insert(newFeedback);
                    break;

                case 2:
                    ListFb fbList = daoFb.selectAll();
                    fbList.show();

                    break;

                default:
                    break;
            }

        }

        input.close();

    }
}
