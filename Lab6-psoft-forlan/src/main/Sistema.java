package main;

import java.util.Scanner;

import models.VacinApp;


public class Sistema {
    

    public static void main(String[] args){
    	
        VacinApp vacinApp = new VacinApp();
        
        
        String menu =  "\n\nBem-vindo ao VacinApp!\n\n" +
        "Selecione uma das seguintes operações: \n" + 
        "1 - Cadastrar indivíduo: \n" +
        "2 - Detalhar idade mínima, comorbidades e profissões habilitadas para vacinação: \n" + 
        "3 - Atualizar idade mínima para vacinação: \n" + 
        "4 - Adicionar comorbidade habilitada para vacinação: \n" +  
        "5 - Adicionar profissão habilitada para vacinação:  \n" + 
        "6 - Vacinar indivíduo:  \n" +  
        "7 - Confirmar que o indivíduo tomou a primeira dose há mais de 20 dias: \n" +
        "8 - Alterar comorbidades de um indivíduo: \n" + 
        "9 - Alterar profissão de um indivíduo: \n" +  
        "10 - Detalhar situação de um indivíduo: \n" +  
        "11 - Listar indivíduos que  não estão habilitados a tomar a primeira dose no momento:  \n" +   
        "12 - Listar indivíduos habilitadas a tomar a primeira dose:  \n" + 
        "13 - Listar indivíduos habilitadas a tomar a segunda dose (que tomaram a primeira dose há mais de 20 dias): \n" +
        "14 - Listar indivíduos que tomaram a primeira dose: \n" +
        "15 - Listar indivíduos que foram vacinados: \n" + 
        "0 -  Para sair";
        
        Scanner sc = new Scanner(System.in);
        int operacao;
        
        while(true){
        	
            System.out.println(menu);
            System.out.println("Digite a operação: ");
            operacao = sc.nextInt();
            sc.nextLine();
            String cpf;
            String profissao;
            String comorbidades;
           
            
            switch(operacao){
                case(1):
                    cadastrarIndividuo(sc, vacinApp);
                    break;
                case(2):
                    vacinApp.detalhesVacinacao();
                    break;
                case(3):
                    System.out.println("Informe a nova idade mínima para vacinação: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    vacinApp.setIdadeMinimaHabilitada(idade);
                    break;
                case(4):
                    System.out.println("Informe a comorbidade que será habilitada: ");
                    comorbidades = sc.nextLine();
                    vacinApp.adicionaComorbidadeHabilitada(comorbidades);
                    break;
                case(5):
                    System.out.println("Informe a profissão que será habilitada: ");
                    profissao = sc.nextLine();
                    vacinApp.adicionaProfissaoHabilitada(profissao);
                    break;
                case(6):
                    System.out.println("Informe o cpf do indivíduo: ");
                    cpf = sc.nextLine();
                    vacinApp.vacinarIndividuo(cpf);
                    break;
                case(7):
                    System.out.println("Informe o cpf do indivíduo: ");
                    cpf = sc.nextLine();
                    vacinApp.avancarEtapa(cpf);
                    break;
                case(8):
                    System.out.println("Informe o cpf do indivíduo: ");
                    cpf = sc.nextLine();
                    System.out.println("Informe as comorbidades do indivíduo (separadas por espaço): ");
                    comorbidades = sc.nextLine();
                    vacinApp.setComorbidadesIndividuo(cpf, comorbidades);
                    break;
                case(9):
                    System.out.println("Informe o cpf do indivíduo: ");
                    cpf = sc.nextLine();
                    System.out.println("Informe a profissão do indivíduo: ");
                    profissao = sc.nextLine();
                    vacinApp.setProfissaoIndividuo(cpf, profissao);
                    break;
                case(10):
                    System.out.println("Informe o cpf do indivíduo: ");
                    cpf = sc.nextLine();
                    vacinApp.informarSituacaoIndividuo(cpf);
                    break;
                case(11):
                    vacinApp.listarIndividuosNaoHabilitados();
                    break;
                case(12):
                    vacinApp.listarIndividuosHabilitadosParaPrimeiraDose();
                    break;
                case(13):
                    vacinApp.listarIndividuosHabilitadosParaSegundaDose();
                    break;
                case(14):
                    vacinApp.listarIndividuosQueTomaramPrimeiraDose();
                    break;
                case(15):
                    vacinApp.listarIndividuosVacinados();
                    break;
                case(0):
                    break;
                default: 
                    System.out.println("Opção inválida! \n\n\n");
            }
        
            if (operacao == 0){
                System.out.println("Fechando o VacinApp...");
                break;
            }
        }

   
    
    
    }
    
    public static void cadastrarIndividuo(Scanner sc, VacinApp vacinApp){
        
        String nome;
        String endereco;
        String cartaoSUS;
        String email;
        String cpf;
        int idade;
        String telefone;
        String profissao;
        String comorbidades;

        System.out.println("Cadastre o nome do indivíduo: ");
        nome = sc.nextLine();

        System.out.println("Cadastre o cpf do indivíduo: ");
        cpf = sc.nextLine();
        
        System.out.println("Cadastre o número do cartão do SUS do indivíduo: ");
        cartaoSUS = sc.nextLine();

        System.out.println("Cadastre a idade do indivíduo: ");
        idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Cadastre o endereço do indivíduo: ");
        endereco = sc.nextLine();

        System.out.println("Cadastre o e-mail do indivíduo: ");
        email = sc.nextLine();

        System.out.println("Cadastre o telefone do indivíduo: ");
        telefone = sc.nextLine();

        System.out.println("Cadastre a profissão do indivíduo: ");
        profissao = sc.nextLine();

        System.out.println("Cadastre as  comorbidades do indivíduo (separadas por espaço), se não tiver, deixe em branco: ");
        comorbidades = sc.nextLine();

        vacinApp.adicionarIndividuo(nome, cpf, idade, endereco, cartaoSUS, email, telefone, profissao, comorbidades);

    }
}
