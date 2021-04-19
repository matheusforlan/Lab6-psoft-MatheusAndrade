package situacaoIndividuos;

import models.Individuo;

public class Vacinado extends SituacaoIndividuo{

    @Override
    public void trocarSituacaoDoIndividuo(Individuo individuo){
        System.out.println("O indivíduo já está vacinado.\n\n");
        
    }

    @Override
    public void tomarVacina(Individuo individuo) {
        System.out.println("O indivíduo já está vacinado.\n\n");
    }

    @Override
    public String toString(){
        return "Tomou as 2 doses da vacina e está vacinado.";
    }
    
}
