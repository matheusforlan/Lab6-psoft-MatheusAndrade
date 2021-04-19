package situacaoIndividuos;

import models.Individuo;

public class HabilitadoParaPrimeiraDose extends SituacaoIndividuo{

    @Override
    public void trocarSituacaoDoIndividuo(Individuo individuo) {
        System.out.println(individuo.getNome() + " não pode passar para a próxima fase  de vacinação sem ter tomado a primeira dose da vacina.\n\n");
        
    }

    @Override
    public void tomarVacina(Individuo individuo) {
        individuo.setSituacao(new TomouPrimeiraDose());
        System.out.println(individuo.getNome() + " tomou a primeira dose da vacina e está em fase de espera para a segunda dose daqui a 20 dias.\n\n");
        
    }

    @Override
    public String toString(){
        return "Habilitado(a) para a primiera dose da vacina.;";
    }
    
}
