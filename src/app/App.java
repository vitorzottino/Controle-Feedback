package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Feedback;
import model.User;
import repository.FeedbackDAO;
import repository.UserDAO;

public class App {

    public static void main(String[] args) throws SQLException {

        Scanner input = new Scanner(System.in);
        FeedbackDAO daoFb = new FeedbackDAO();
        UserDAO daoUser = new UserDAO();

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("MENU");
            System.out.println("1 - Cadastrar feedback");
            System.out.println("2 - Ler Feedbacks");
            System.out.println("3 - Criar Usuario");
            System.out.println("4 - Listar Usuarios");
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
                    List<Feedback> fbList = daoFb.selectAll();
                    for (Feedback feedback : fbList) {
                    	System.out.println("ID: " + feedback.getId());
                    	System.out.println("Motivo: " + feedback.getMotivo());
                    	System.out.println("Assunto: " + feedback.getAssunto());
                    	System.out.println("Mensagem: " + feedback.getConteudo());
                    	System.out.println("Data Entrada: " + feedback.getDataEntrada());
						
					}

                    break;

                case 3:
                    User user = new User();
                    System.out.print("Informe o Nome: ");
                    input.nextLine();
                    user.setNome(input.next());
                    System.out.print("Informe a senha: ");
                    input.nextLine();
                    user.setSenha(input.next());
                    System.out.println("ADMIN? Y- sim / N - nao");
                    user.setAdmin(input.next());
                    daoUser.insert(user);
                    break;

                case 4:
                    List<User> userList = daoUser.selectAll();
                    for (User user2 : userList) {
                        System.out.println("ID: " + user2.getId());
                        System.out.println("Nome: " + user2.getNome());
                        System.out.println("Senha: " + user2.getSenha());
                    }

                    break;

                default:
                    break;
            }

        }

        input.close();

    }
}
