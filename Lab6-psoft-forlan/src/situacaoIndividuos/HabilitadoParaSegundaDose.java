package situacaoIndividuos;

import models.Individuo; 

public class HabilitadoParaSegundaDose extends SituacaoIndividuo{

    @Override
    public void trocarSituacaoDoIndividuo(Individuo individuo) {
        System.out.println(individuo.getNome() + " já confirmou que tomou a primeira dose há mais de 20 dias.\n\n");
        
    }

    @Override
    public void tomarVacina(Individuo individuo) {
        individuo.setSituacao(new Vacinado());
        System.out.println(individuo.getNome() + " tomou a segunda dose da vacina e está vacinado(a).\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitado(a) para a segunda dose da vacina.";
    }
    
}
