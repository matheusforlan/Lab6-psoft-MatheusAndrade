package situacaoIndividuos;

import models.Individuo;

public class TomouPrimeiraDose extends SituacaoIndividuo{
    @Override
    public void trocarSituacaoDoIndividuo(Individuo individuo) {
        individuo.setSituacao(new HabilitadoParaSegundaDose());
        System.out.print(individuo.getNome() + " está habilitado(a) para tomar a segunda dose da vacina.\n\n");
    }

    @Override
    public void tomarVacina(Individuo individuo) {
        System.out.println(individuo.getNome() + " só pode tomar a segunda dose da vacina depois de 20 dias após a primeira dose.\n\n");    
    }

    @Override
    public String toString(){
        return "Tomou a primeira dose e está na fase de espera de 20 dias para tomar a segunda dose da vacina.";
    }
}
