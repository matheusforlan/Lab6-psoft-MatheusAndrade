package models;

import java.util.*;

import situacaoIndividuos.*;


public class Individuo {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String cartaoSUS;
    private String email;
    private int idade;
    private String telefone;
    private String profissao;
    private Set<String> comorbidades; 
    private SituacaoIndividuo situacao;

    public Individuo(String nome, String cpf, int idade, String endereco, String cartaoSUS, String email, String telefone, String profissao, String comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
        this.profissao = profissao;
        this.situacao = new NaoHabilitadoParaVacinar();
        setComorbidades(comorbidades);
        this.cartaoSUS = cartaoSUS;
        this.email = email;
        this.telefone = telefone;
       
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getProfissao() {
        return this.profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Set<String> getComorbidades() {
        return this.comorbidades;
    }

    public void adicionaComorbidade(String comorbidade) {
        this.comorbidades.add(comorbidade);
    }

    public void setComorbidades(String comorbidades){
        Set<String> aux = new TreeSet<String>();
        for (String comorbidade : comorbidades.split(" ")){
            aux.add(comorbidade);
        }
        this.comorbidades = aux;
    }
    
    public String getCartaoSUS() {
        return this.cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }


    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public void avancarEtapa(){
        this.situacao.trocarSituacaoDoIndividuo(this);
    }
    public void tomarVacina(){
        this.situacao.tomarVacina(this);
    }

    public void setSituacao(SituacaoIndividuo situacao){
        this.situacao = situacao;
    }
    public String getSituacaoTextual(){
        return "O indivíduo " + this.nome + "se encontra na situação: " + this.situacao.toString() + "\n\n";
    }
    public SituacaoIndividuo getSituacao(){
        return this.situacao;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade =idade;
    }

    @Override
    public String toString(){
        return "nome: " + this.nome + "\n" +
        "cpf: " + this.cpf + "\n" +
        "situacao: " + this.situacao.toString() + "\n";
    }
}
