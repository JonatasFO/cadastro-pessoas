import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Aluno aluno = new Aluno();
        BancoDeDados bancoDeDados = new BancoDeDados();
        int opcao = 0;

        do {
            if (opcao != 1) {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opção: \n 1 - Cadastrar Aluno \n 2 - Listar Alunos \n 0 - Sair"));
            }

            switch (opcao) {
                case 1:
                    Aluno cadastarAluno = cadastrarAluno(aluno);
                    bancoDeDados.cadastrar(cadastarAluno);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Lista de Alunos: \n" + listarAlunos(bancoDeDados));
                    opcao = 0;
                    break;
            }

            if (opcao == 1) {
                int novoAluno = Integer.parseInt(JOptionPane.showInputDialog("Deseja Cadastrar um novo aluno? \n 1 - Sim \n 2 - Não \n"));

                if (novoAluno == 2) {
                    JOptionPane.showMessageDialog(null, "Lista de Alunos: \n" + listarAlunos(bancoDeDados));
                    opcao = 0;
                }
            }

        } while (opcao != 0);
    }
    private static Aluno cadastrarAluno(Aluno aluno) {
        aluno.setNome(JOptionPane.showInputDialog(null, "Qual o nome do aluno: "));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog(null, "Qual a sua idade do aluno: ")));
        aluno.setFaculdade(JOptionPane.showInputDialog(null, "Qual a faculadade do aluno: "));

        return aluno;
    }
    private static String listarAlunos(BancoDeDados bancoDeDados) {
        List<Aluno> alunos = bancoDeDados.listarAlunos();
        String listaDeAlunos = "";
        for (Aluno aluno : alunos) {
            listaDeAlunos += aluno.toString();
        }

        return listaDeAlunos;
    }
}