import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        ArrayList<DisciplinaCursada> disciplinasCursadas = new ArrayList<DisciplinaCursada>();
        ArrayList<Nota> notas = new ArrayList<Nota>();
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        Hashtable<String, String> dados = new Hashtable<String, String>();
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("\n1-Cadastrar Aluno\n2-Ver disciplinas do aluno\n3-Grupo das Disciplinas do aluno\n4-Atribuir nota\n5-Quadro geral de notas\n6-Finalizar Periodo\n7-Seu periodo\n8-Cadastra Sequencia Aconselhada para seguir\n9-Ver disciplinas cursadas");
            System.out.println("\nEscolha uma opcao:");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    //cadastrar Aluno
                    cadastrarAluno(alunos, disciplinas);
                    break;
                case 2:
                    //ver disciplina do aluno
                    verDisciplinas(alunos, disciplinas);
                    break;
                case 3:
                    //grupo das disciplinas do curso
                    grupoDisciplinas(disciplinas);
                    break;
                case 4:
                    //Atribuir nota as disciplinas, atribua a todas
                    atribuirNota(alunos, disciplinas, notas);
                    break;
                case 5:
                    //todas as notas atribuidas a disciplinas
                    quadroNotas(alunos, disciplinas, notas);
                    break;
                case 6:
                    //guarda as disciplinas ja cursadas com suas notas e limpa as atuais
                    finalizarPeriodo(alunos, disciplinas, disciplinasCursadas,notas);
                    disciplinas.clear();
                    break;
                case 7:
                    //quando conclui o periodo digite o seu proximo periodo
                    seuPeriodo(alunos,disciplinas,periodos);
                    break;
                case 8:
                    //cadastrar periodos e remove disciplinas
                    cadastrarPeriodos(alunos, disciplinas, periodos,disciplinasCursadas);
                    break;
                case 9:
                    //ver disciplinas ja cursadas
                    verDisciplinasCursadas(alunos, disciplinas, disciplinasCursadas,notas);
                    //verDisciplinasCursadas(alunos, disciplinas, disciplinasCursadas);
                    break;
                default:
                    System.out.println("Opcao incorreta");
                    break;
            }
        }
    }

    public static void cadastrarAluno(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas) {
        Scanner input = new Scanner(System.in);
        Hashtable<String, String> dados = new Hashtable<String, String>();

        System.out.println("Digite o nome do aluno: ");
        String nomeAluno = input.nextLine();
        System.out.println("Digite a matricula do aluno: ");
        String matricula = input.nextLine();
        System.out.println("Digite o area de interesse do aluno: ");
        String area = input.nextLine();
        if (alunos != null) {
            alunos.add(new Aluno(nomeAluno, matricula, area));
            int index = 0;
            for (int i = 0; i < alunos.size(); i++) {
                if (nomeAluno.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                    index = i;
                }

            }
            dados.put(nomeAluno, matricula);
            System.out.println("Cadastro realizado.\n");
            System.out.println("Matricula do Aluno - " + dados);

            disciplinas.add(new Disciplina("1", "algoritmos1", "seg2", "computacao", "sem", "obg"));
            disciplinas.add(new Disciplina("2", "calculo1", "seg3", "exatas", "sem", "obg"));
            disciplinas.add(new Disciplina("3", "calculovetorial", "seg4", "exatas", "sem", "obg"));
            disciplinas.add(new Disciplina("4", "etica", "seg5", "humanas", "sem", "obg"));
            disciplinas.add(new Disciplina("5", "iccp", "seg6", "computacao", "sem", "obg"));
            alunos.get(index).setDisciplinas(disciplinas);
            System.out.println("\nDisciplinas do primeiro cadastradas automaticamente");
        } else {
            System.out.println("Nao foi possivel adiciona-lo");
        }
    }

    public static void verDisciplinas(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas) {
        Scanner input = new Scanner(System.in);
        if (disciplinas.size() != 0) {
            System.out.print("Informacoes do aluno\nNome: ");
            String nome = input.nextLine();
            System.out.print("Matrícula: ");
            String matricula = input.nextLine();

            Aluno aluno = null;
            for (int i = 0; i < alunos.size(); i++) {
                if (nome.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                    aluno = alunos.get(i);
                }

            }
            if (aluno != null) {
                if (disciplinas.size() != 0) {
                    System.out.println("\nAs disciplinas sao: ");
                    for (int i = 0; i < aluno.getDisciplina().size(); i++) {
                        System.out.println(aluno.getDisciplina().get(i).getDisciplina());
                    }
                } else {
                    System.out.println("Ainda não disciplinas do aluno");
                }
            } else {
                System.out.println("Aluno não encontrado");
            }
        } else {
            System.out.println("Aluno nao foi cadastrado em disciplinas");
        }

    }

    public static void grupoDisciplinas(ArrayList<Disciplina> disciplinas) {
        Scanner input = new Scanner(System.in);
        if (disciplinas.size() != 0) {
            int escolha = -1;
            while (escolha != 0) {
                System.out.println("\n1-Para ver os tipos de disciplinas\n2-Para ver as areas das disciplinas\n0-Para voltar\n");
                escolha = input.nextInt();
                if (escolha == 1) {
                    for (int i = 0; i < disciplinas.size(); i++) {
                        String tipo = disciplinas.get(i).getTipo();

                        if (tipo.equals("obg")) {
                            System.out.println("Disciplina Obrigatoria: " + disciplinas.get(i).getDisciplina());
                        }
                        if (tipo.equals("etv1")) {
                            System.out.println("Disciplina Eletiva Grupo 1: " + disciplinas.get(i).getDisciplina());
                        }
                        if (tipo.equals("etv2")) {
                            System.out.println("Disciplina Eletiva Grupo 2: " + disciplinas.get(i).getDisciplina());
                        }
                    }
                }
                //humanas computacao programacao exatas
                if (escolha == 2) {

                    for (int i = 0; i < disciplinas.size(); i++) {
                        String area = disciplinas.get(i).getArea();

                        if (area.equals("humanas")) {
                            System.out.println("Humanas:" + disciplinas.get(i).getDisciplina());
                        }
                        if (area.equals("computacao")) {
                            System.out.println("Computacao: " + disciplinas.get(i).getDisciplina());
                        }
                        if (area.equals("programacao")) {
                            System.out.println("Programacao: " + disciplinas.get(i).getDisciplina());
                        }
                        if (area.equals("exatas")) {
                            System.out.println("Exatas: " + disciplinas.get(i).getDisciplina());
                        }
                    }
                }
                if (escolha == 0) {
                    break;
                }
            }
        } else {
            System.out.println("Disciplinas não cadastradas");
        }


    }


    public static void atribuirNota(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<Nota> notas) {
        if (disciplinas.size() != 0) {
            Scanner input = new Scanner(System.in);
            System.out.print("Informações do aluno\nNome: ");
            String nome = input.nextLine();
            System.out.print("Matrícula: ");
            String matricula = input.nextLine();

            int index = 0;
            Aluno aluno = null;
            for (int i = 0; i < alunos.size(); i++) {
                if (nome.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                    aluno = alunos.get(i);
                }
            }
            if (aluno != null) {
                if (disciplinas.size() != 0) {
                    System.out.println("As disciplinas sao: ");
                    for (int i = 0; i < aluno.getDisciplina().size(); i++) {
                        System.out.println(aluno.getDisciplina().get(i).getCodigo() + " - " + aluno.getDisciplina().get(i).getDisciplina());
                        index = i;
                    }
                }

                System.out.print("Digite o codigo da disciplina que deseja atribuir nota para disciplina\n");
                String codigo = input.nextLine();
                System.out.print("Nota: ");
                double nota = input.nextDouble();
                for (int i = 0; i < aluno.getDisciplina().size(); i++) {
                    if (codigo.equals(aluno.getDisciplina().get(i).getCodigo())) {
                        notas.add(new Nota(aluno.getDisciplina().get(i), aluno, nota));
                        System.out.println("nota atribuida");
                    }
                }

                //todas as notas armazenadas no sistema
                try {
                    BufferedWriter escrever =
                            new BufferedWriter(new FileWriter("notas.txt"));
                    for (int i = 0; i < alunos.size(); i++) {
                        escrever.write("Nome: " + alunos.get(i).getNome());
                        for (int k = 0; k < notas.size(); k++) {
                            for (int j = 0; j < alunos.get(i).getDisciplina().size(); j++) {
                                if (alunos.get(i).getDisciplina().get(j).getCodigo() == notas.get(k).getDisciplina()) {
                                    escrever.write("\nNotas: " + alunos.get(i).getDisciplina().get(j).getDisciplina() + " - " + notas.get(k).getNota());
                                }
                            }
                        }
                    }
                    escrever.close();
                } catch (IOException e) {
                    System.out.println("Não foi possível criar o arquivo");
                }


            } else {
                System.out.println("Aluno não encontrado");
            }
        }
        else {
            System.out.println("Aluno nao foi cadastrado em disciplinas");
        }

    }


    public static void quadroNotas(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<Nota> notas) {
        System.out.println("Informações do aluno");

        try {

            BufferedReader leitor =
                    new BufferedReader(new FileReader("notas.txt"));
            String linhas;
            while ((linhas = leitor.readLine()) != null) {
                System.out.println(linhas);
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo");
        }

        /*
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("Nome: " + alunos.get(i).getNome());
            for (int k = 0; k < notas.size(); k++) {
                for (int j = 0; j < alunos.get(i).getDisciplina().size(); j++) {
                    if (alunos.get(i).getDisciplina().get(j).getCodigo() == notas.get(k).getDisciplina()) {
                        System.out.println("Notas: " + alunos.get(i).getDisciplina().get(j).getDisciplina() + "-" + notas.get(k).getNota());
                    }
                }
            }
        }

         */

    }

    public static void finalizarPeriodo(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<DisciplinaCursada> disciplinasCursadas, ArrayList<Nota> notas) {
        Scanner input = new Scanner(System.in);
        if (disciplinas.size() != 0) {
            System.out.print("Informacoes do aluno\nNome: ");
            String nome = input.nextLine();
            System.out.print("Matrícula: ");
            String matricula = input.nextLine();

            Aluno aluno = null;
            for (int i = 0; i < alunos.size(); i++) {
                if (nome.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                    aluno = alunos.get(i);
                }

            }
            if (aluno != null) {
                if (notas.size()!=0) {
                    System.out.println("Informações do aluno");
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println("Nome: " + alunos.get(i).getNome());
                        for (int k = 0; k < notas.size(); k++) {
                            for (int j = 0; j < alunos.get(i).getDisciplina().size(); j++) {
                                if (alunos.get(i).getDisciplina().get(j).getCodigo() == notas.get(k).getDisciplina()) {
                                    //System.out.println("Notas: " + alunos.get(i).getDisciplina().get(j).getDisciplina() + "-" + notas.get(k).getNota());
                                    disciplinasCursadas.add(new DisciplinaCursada(alunos.get(i).getDisciplina().get(j).getDisciplina(),notas.get(k).getNota()));

                                }

                            }
                        }
                    }
                    try {
                        BufferedWriter escrever =
                                new BufferedWriter(new FileWriter("disciplinasCursadas.txt"));
                        for (int i = 0; i < disciplinasCursadas.size(); i++) {
                            escrever.write(disciplinasCursadas.get(i).getDisciplinaCursada()+"\t");
                        }
                        escrever.close();
                    } catch (IOException e) {
                        System.out.println("Não foi possível criar o arquivo");
                    }

                    System.out.println("Finalizado com sucesso");

                } else {
                    System.out.println("Voce nao botou nota nas disciplinas");
                }
            } else {
                System.out.println("Aluno não encontrado");
            }
        } else {
            System.out.println("Aluno nao foi cadastrado em disciplinas");
        }
    }



    public static void seuPeriodo(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<Periodo> periodos) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu periodo");
        int periodo = input.nextInt();
        periodos.add(new Periodo(periodo));
        System.out.println("Periodo adicionado");
        if (periodo==2){
            System.out.println("\nSequencia aconselhada para o periodo\n");
            System.out.println("2ºperiodo\ncodigo|disciplina\n6-Algebra Linear\n7-Calculo II\n8-Fisica I\n9-Linguagem de Programacao I\n10-Matematica Discreta\n");

        }
        if (periodo==3){
            System.out.println("\nSequencia aconselhada para o periodo\n");
            System.out.println("3ºperiodo\ncodigo|disciplina\n11-Arquitetura de Computadores\n12-Cálculo III\n13-Estrutura de Dados I\nFísica III\n15-Linguagem de Programação II\nxx-Uma eletiva\n");

        }
        if(periodo==4) {
            System.out.println("\nSequencia aconselhada para o periodo\n");
            System.out.println("4ºperiodo\ncodigo|disciplina\n17-Engenharia de Software\n18-Estatística e Probabilidade\n19-Estrutura de Dados II\n20-Linguagens Formais e Autômatos\n21-Redes de Computadores I\n22-Sistemas Operacionais I\nxx-Uma eletiva\n");
        }

/*
        try {
            BufferedWriter escrever =
                    new BufferedWriter(new FileWriter("disciplinasCursadas.txt"));
            for (int i = 0; i < alunos.size(); i++) {
                    for (int j = 0; j < alunos.get(i).getDisciplina().size(); j++) {
                        escrever.write(alunos.get(i).getDisciplina().get(j).getCodigo()+"\t"+alunos.get(i).getDisciplina().get(j).getDisciplina()+"\t");
                    }
            }
            escrever.close();
        } catch (IOException e) {
            System.out.println("Não foi possível criar o arquivo");
        }

 */


    }

    public static void cadastrarPeriodos(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<Periodo> periodos,ArrayList<DisciplinaCursada> disciplinasCursadas) {
        Scanner input = new Scanner(System.in);
        if (alunos.size() != 0) {
            System.out.print("Informações do aluno\nNome: ");
            String nomeAluno = input.nextLine();
            System.out.print("Matrícula: ");
            String matricula = input.nextLine();

            Aluno aluno = null;
            int index = 0;

            for (int i = 0; i < alunos.size(); i++) {
                if (nomeAluno.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                    aluno = alunos.get(i);
                    index = i;
                }

            }

            if (aluno != null) {
                int escolha = -1;
                int opPeriodo = -1;
                int op = -1;
                int opEletiva = -1;


                while (true) {
                    System.out.println("\n1-Acessar as disciplinas de cada periodo\n2-Remover Disciplinas\n0-Para voltar");
                    escolha = input.nextInt();
                    //acessar os periodos
                    int periodo = 0;
                    String preRequisito;

                    if (escolha == 1) {
                        System.out.println("\nEscolha seu proximo periodo");
                        for (int i = 0; i < periodos.size(); i++) {
                            periodo = periodos.get(i).getPeriodo();
                        }
                        System.out.println("Periodo para escolher é o " + periodo + " periodo");

                        System.out.println("\nDigite 2 para acessar 2periodo\nDigite 3 para acessar 3periodo\nDigite 4 para acessar 4periodo\nDigite 0 para voltar");
                        opPeriodo = input.nextInt();

                        if (periodo == opPeriodo) {

                            if (opPeriodo == 2) {

                                System.out.println("\nCom base na sequencia aconselhada escolha as disciplinas");
                                System.out.println("2ºperiodo\n1-Algebra Linear\n2-Calculo II\n3-Fisica I\n4-Linguagem de Programacao I\n5-Matematica Discreta\n");
                                op = input.nextInt();


                                if (op == 1) {
                                    preRequisito = "calculovetorial";

                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("6", "algebralinear", "35t45", "exatas", "calculovetorial", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }
                                }


                                if (op == 2) {
                                    preRequisito = "calculo1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("7", "calculo2", "24t56", "exatas", "calculo1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 3) {
                                    preRequisito = "calculo1";

                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("8", "fisica1", "24t34", "exatas", "calculo1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }


                                }

                                if (op == 4) {
                                    preRequisito = "algoritmos1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("9", "lp1", "24t12", "computacao", "algoritmos1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 5) {
                                    preRequisito = "iccp";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("10", "mdl", "35t12", "computacao", "iccp", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                            }
                        }
                        if (periodo == opPeriodo) {
                            if (opPeriodo == 3) {
                                System.out.println("\nCom base na sequencia aconselhada escolha as disciplinas");
                                System.out.println("3ºperiodo\n1-Arquitetura de Computadores\n2-Cálculo III\n3-Estrutura de Dados I\n4-Física III\n5-Linguagem de Programação II\n6-Eletiva\n\n");
                                op = input.nextInt();
                                if (op == 1) {
                                    preRequisito = "mdl";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("11", "arquitetura", "35t45", "exatas", "mdl", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 2) {
                                    preRequisito = "calculo2";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("12", "calculo3", "24t56", "exatas", "calculo2", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }


                                }

                                if (op == 3) {
                                    preRequisito = "lp1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("13", "ed1", "24t34", "exatas", "lp1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }


                                if (op == 4) {
                                    preRequisito = "fisica1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("14", "fisica3", "35t34", "computacao", "fisica1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 5) {
                                    preRequisito = "algoritmos1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("15", "lp2", "24t12", "computacao", "algoritmos1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 6) {
                                    System.out.println("Escolher apenas uma");
                                    System.out.println("Disciplinas Eletivas\n1-Indroducao a robotica\n2-Antropologia\n3-Sociologia\n\n");
                                    opEletiva = input.nextInt();
                                    if (opEletiva == 1) {
                                        preRequisito = "calculo2";
                                        for(int i = 0; i < disciplinasCursadas.size(); i++){
                                            if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                                disciplinas.add(new Disciplina("22", "introducaarobotica", "6t1234", "computacao", "calculo2", "obg"));
                                                alunos.get(index).setDisciplinas(disciplinas);
                                                System.out.println("\nCadastro das disciplinas realizado");
                                            }
                                        }


                                    }

                                    if (opEletiva == 2) {
                                        disciplinas.add(new Disciplina("23", "antropologia", "6t1234", "elv2", "sem", "obg"));
                                        alunos.get(index).setDisciplinas(disciplinas);
                                        System.out.println("\nCadastro das disciplinas realizado");
                                    }

                                    if (opEletiva == 3) {
                                        disciplinas.add(new Disciplina("24", "sociologia", "6t1234", "elv2", "sem", "obg"));
                                        alunos.get(index).setDisciplinas(disciplinas);
                                        System.out.println("\nCadastro das disciplinas realizado");
                                    }
                                    if (opEletiva == 0) {
                                        break;
                                    }
                                }
                            }
                        }


                        if (periodo == opPeriodo) {
                            if (opPeriodo == 4) {
                                System.out.println("\nCom base na sequencia aconselhada escolha as disciplinas");
                                System.out.println("4ºperiodo\n1-Engenharia de Software\n2-Estatística e Probabilidade\n3-Estrutura de Dados II\n4-Linguagens Formais e Autômatos\n5-Redes de Computadores I\n6-Sistemas Operacionais I\n7-Eletiva\n\n");

                                op = input.nextInt();
                                if (op == 1) {
                                    preRequisito = "lp2";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("16", "engsoftware", "24t12", "exatas", "lp2", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 2) {
                                    preRequisito = "calculo3";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("17", "etp", "24t34", "exatas", "calculo3", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 3) {
                                    preRequisito = "ed1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("18", "ed2", "35t12", "exatas", "ed1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 4) {
                                    preRequisito = "mdl";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("19", "lfa", "35t34", "computacao", "mdl", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }

                                if (op == 5) {
                                    preRequisito = "arquitetura";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("20", "redes1", "24t56", "computacao", "arquitetura", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }

                                }
                                if (op == 6) {
                                    preRequisito = "ed1";
                                    for(int i = 0; i < disciplinasCursadas.size(); i++){
                                        if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                            disciplinas.add(new Disciplina("21", "so1", "35t56", "computacao", "ed1", "obg"));
                                            alunos.get(index).setDisciplinas(disciplinas);
                                            System.out.println("\nCadastro das disciplinas realizado");
                                        }
                                    }


                                }

                                if (op == 7) {
                                    System.out.println("Escolher apenas uma");
                                    System.out.println("Disciplinas Eletivas\n1-Laboratorio de Programacoa\n2-Pesquisa Operacional\n3-Psicologia\n\n");
                                    opEletiva = input.nextInt();

                                    if (opEletiva == 1) {

                                        preRequisito = "lp2";
                                        for(int i = 0; i < disciplinasCursadas.size(); i++){
                                            if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                                disciplinas.add(new Disciplina("25", "labprogrmacao", "6t1234", "computacao", "lp2", "elt1"));
                                                alunos.get(index).setDisciplinas(disciplinas);
                                                System.out.println("\nCadastro das disciplinas realizado");
                                            }
                                        }

                                    }

                                    if (opEletiva == 2) {
                                        preRequisito = "ed1";
                                        for(int i = 0; i < disciplinasCursadas.size(); i++){
                                            if(preRequisito.equals(disciplinasCursadas.get(i).getDisciplinaCursada())){
                                                disciplinas.add(new Disciplina("26", "pesquisaoperacional", "6t1234", "computacao", "ed1", "elv2"));
                                                alunos.get(index).setDisciplinas(disciplinas);
                                                System.out.println("\nCadastro das disciplinas realizado");
                                            }
                                        }
                                    }

                                    if (opEletiva == 3) {
                                        disciplinas.add(new Disciplina("27", "psicologia", "6t1234", "humanas", "sem", "elv2"));
                                        alunos.get(index).setDisciplinas(disciplinas);
                                        System.out.println("\nCadastro das disciplinas realizado");
                                    }

                                    if (opEletiva == 0) {
                                        break;
                                    }
                                }
                            }

                            if (op == 0) {
                                break;
                            }

                        }

                        if (opPeriodo == 0) {
                            break;
                        }
                    }


                    //remover disciplina ja cadastrada para trocar por outra
                    if (escolha == 2) {
                        removerDisciplina(alunos, disciplinas);
                    }
                    if (escolha == 0) {
                        break;
                    }
                }

            } else {
                System.out.println("Aluno não encontrado");
            }
        } else {
            System.out.println("Falta cadastrar o aluno");
        }
    }




    public static void verDisciplinasCursadas(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<DisciplinaCursada> disciplinasCursadas,ArrayList<Nota> notas) {
        Scanner input = new Scanner(System.in);

            System.out.print("Informacoes do aluno\nNome: ");
            String nome = input.nextLine();
            System.out.print("Matrícula: ");
            String matricula = input.nextLine();

            Aluno aluno = null;
            for (int i = 0; i < alunos.size(); i++) {
                if (nome.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                    aluno = alunos.get(i);
                }

            }
            if (aluno != null) {

                System.out.println("\nAs disciplinas sao: ");
                for (int i = 0; i < disciplinasCursadas.size(); i++) {
                    System.out.println(disciplinasCursadas.get(i));
                    //System.out.println(disciplinasCursadas.get(i).getDisciplinaCursada()+" - "+disciplinasCursadas.get(i).getNota());
                }

            } else {
                System.out.println("Aluno não encontrado");
            }
    }

    public static void removerDisciplina(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas) {
        Scanner input = new Scanner(System.in);
        System.out.print("Informações do aluno\nNome: ");
        String nome = input.nextLine();
        System.out.print("Matrícula: ");
        String matricula = input.nextLine();

        int index = 0;
        Aluno aluno = null;
        for (int i = 0; i < alunos.size(); i++) {
            if (nome.equals(alunos.get(i).getNome()) && matricula.equals(alunos.get(i).getMatricula())) {
                aluno = alunos.get(i);
            }
        }
        if (aluno != null) {
            if (disciplinas.size() != 0) {
                System.out.println("As disciplinas sao: ");
                for (int i = 0; i < aluno.getDisciplina().size(); i++) {
                    System.out.println(aluno.getDisciplina().get(i).getCodigo() + " - " + aluno.getDisciplina().get(i).getDisciplina());
                    index = i;
                }
            }

            System.out.println("Digite o codigo da disciplina que deseja remover");
            String codigo = input.nextLine();
            for (int i = 0; i < aluno.getDisciplina().size(); i++) {
                if (codigo.equals(aluno.getDisciplina().get(i).getCodigo())) {
                    disciplinas.remove(aluno.getDisciplina().get(i));
                    System.out.println("disciplina removida");
                }
            }
        } else {
            System.out.println("Aluno não encontrado");
        }
    }


/*
    public static void verDisciplinasCursadas(ArrayList<Aluno> alunos, ArrayList<Disciplina> disciplinas, ArrayList<DisciplinaCursada> disciplinasCursadas) {

        try {
            BufferedReader leitor =
                    new BufferedReader(new FileReader("disciplinasCursadas.txt"));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo");
        }

        try {

            BufferedReader leitor =
                    new BufferedReader(new FileReader("disciplinasCursadas.txt"));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] separado = linha.split("\t");
                if (separado.length >=6) {
                    DisciplinaCursada d =
                            new DisciplinaCursada(separado[0], separado[1]);
                    disciplinasCursadas.add(d);

                }

            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo inexistente");
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo");
        }

        }
        */


}


















