package models;

import java.util.*;

import situacaoIndividuos.*;

public class VacinApp {
    private Map<String, Individuo> individuosCadastrados;
    
    private Set<String> profissoesHabilitadas;

    private int idadeMinimaHabilitada;

    private Set<String> comorbidadesHabilitadas;



    public VacinApp(){
        this.individuosCadastrados = new HashMap<String, Individuo>();
        this.idadeMinimaHabilitada = 85;
        this.comorbidadesHabilitadas = new TreeSet<String>();
        this.profissoesHabilitadas = new TreeSet<String>();       
    }
    
    public Map<String, Individuo> getPessoasCadastradas() {
        return this.individuosCadastrados;
    }

    public void setPessoasCadastradas(Map<String, Individuo> individuoCadastrados) {
        this.individuosCadastrados = individuoCadastrados;
    }

    public Set<String> getComorbidades() {
        return this.comorbidadesHabilitadas;
    }

    public void setComorbidades(Set<String> comorbidades) {
        this.comorbidadesHabilitadas = comorbidades;
    }

    public Set<String> getProfissoes() {
        return this.profissoesHabilitadas;
    }

    public void setProfissoes(Set<String> profissoes) {
        this.profissoesHabilitadas = profissoes;
    }

    public int getIdadeMinima() {
        return this.idadeMinimaHabilitada;
    }

    public void adicionarIndividuo(String nome, String cpf, int idade,String endereco,
    String cartaoSUS, String email, String telefone, String profissao, String comorbidades){
    	
        if(individuosCadastrados.containsKey(cpf)){
            System.out.println("Indivíduo com o cpf " + cpf + " já está cadastrado no sistema.\n\n");
        }
        else{
            
            Individuo individuo = new Individuo(nome, cpf, idade, endereco, cartaoSUS,  email,  telefone,  profissao, comorbidades);
            atualizaSituacaoIndividuo(individuo);
            individuosCadastrados.put(cpf, individuo);
        }
    }

    public void adicionaComorbidadeHabilitada(String comorbidade){
        this.comorbidadesHabilitadas.add(comorbidade);
        atualizaSituacoes();
    }
    
    public void adicionaProfissaoHabilitada(String profissao){
        this.profissoesHabilitadas.add(profissao);
        atualizaSituacoes();
    }
    
    public void setIdadeMinimaHabilitada(int idade){
        this.idadeMinimaHabilitada = idade;
        atualizaSituacoes();
    }

    public void setComorbidadesIndividuo(String cpf, String comorbidades){
        this.individuosCadastrados.get(cpf).setComorbidades(comorbidades);
    }

    public void setProfissaoIndividuo(String cpf, String profissao){
        this.individuosCadastrados.get(cpf).setProfissao(profissao);
    }
    
    public void avancarEtapa(String cpf){
        if(!this.individuosCadastrados.containsKey(cpf)){
            System.out.println("Indivíduo com cpf: " + cpf +" não está cadastrado no sistema.");
        }else if(verificaHabilitado(this.individuosCadastrados.get(cpf))){
            this.individuosCadastrados.get(cpf).avancarEtapa();
        }else{
            System.out.println("O indivíduo não se encontra habilitado para tomar a vacina.");
        }
    }
    
    public void vacinarIndividuo(String cpf){
        if(!this.individuosCadastrados.containsKey(cpf)){
            System.out.println("Indivíduo com cpf: " + cpf +" não está cadastrado no sistema.");
        }else{
            this.individuosCadastrados.get(cpf).tomarVacina();
        }
    }

    public void listarIndividuosHabilitadosParaPrimeiraDose(){
        String retorno = "";
        for(Individuo pessoa : individuosCadastrados.values()){
            if(pessoa.getSituacao() instanceof HabilitadoParaPrimeiraDose)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }

    public void listarIndividuosHabilitadosParaSegundaDose(){
        String retorno = "";
        for(Individuo pessoa : individuosCadastrados.values()){
            if(pessoa.getSituacao() instanceof HabilitadoParaSegundaDose)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }

    public void listarIndividuosNaoHabilitados(){
        String retorno = "";
        for(Individuo pessoa : individuosCadastrados.values()){
            if(pessoa.getSituacao() instanceof NaoHabilitadoParaVacinar)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }
    
    public void listarIndividuosQueTomaramPrimeiraDose(){
        String retorno = "";
        for(Individuo pessoa : individuosCadastrados.values()){
            if(pessoa.getSituacao() instanceof TomouPrimeiraDose)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }
    
    public void listarIndividuosVacinados(){
        String retorno = "";
        for(Individuo pessoa : individuosCadastrados.values()){
            if(pessoa.getSituacao() instanceof Vacinado)retorno += pessoa.toString();
        }
        System.out.print(retorno);
    }

    public void informarSituacaoIndividuo(String cpf) {
        if(!this.individuosCadastrados.containsKey(cpf)){
            System.out.println("Indivíduo não cadastrado no sistema.\n\n");
        }else{
            System.out.println(this.individuosCadastrados.get(cpf).toString() + " \n\n");
        }
    }

    public void listarComorbidadesHabiltiadas(){
        String retorno = "Lista de comorbidades que possibilitam o indivíduo tomar a vacina: \n";
        for(String comorbidade : this.comorbidadesHabilitadas){
            retorno += comorbidade + "\n";
        }
        System.out.print(retorno);
    }

    public void listarProfissoesHabiltiadas(){
        String retorno = "Lista de  profissões de indivíduos que podem receber a vacina: \n";
        for(String profissao : this.profissoesHabilitadas){
            retorno += profissao + "\n";
        }
        System.out.print(retorno);
    }

    public void getIdadeMinimaVacinacao(){
        System.out.println("A idade mínima para vacinação é " + this.idadeMinimaHabilitada + " anos de idade.");
    }

    public void detalhesVacinacao(){
        listarComorbidadesHabiltiadas();
        listarProfissoesHabiltiadas();
        getIdadeMinimaVacinacao();
    }

    private void atualizaSituacoes() {
        for (Individuo individuo : this.individuosCadastrados.values()){
            atualizaSituacaoIndividuo(individuo);
        }
    }
    
    private void atualizaSituacaoIndividuo(Individuo individuo) {
        if (individuo.getSituacao() instanceof NaoHabilitadoParaVacinar && verificaHabilitado(individuo)){
            individuo.getSituacao().trocarSituacaoDoIndividuo(individuo);
        }
    }
    
    private boolean verificaHabilitado(Individuo individuo) {
        if (individuo.getIdade() >= idadeMinimaHabilitada) return true;
        if ( this.profissoesHabilitadas.contains(individuo.getProfissao()))return true;
        for(String comorbidade : individuo.getComorbidades()){
            if(comorbidadesHabilitadas.contains(comorbidade))return true;
        }
        return false;
        
    }
    
}
