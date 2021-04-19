package situacaoIndividuos;

import models.Individuo;

public class NaoHabilitadoParaVacinar extends SituacaoIndividuo{
    @Override
    public void trocarSituacaoDoIndividuo(Individuo individuo) {
        individuo.setSituacao(new HabilitadoParaPrimeiraDose());
        System.out.println(individuo.getNome() + " está habilitado(a) para tomar a primeira dose da vacina. \n\n");
    }

    @Override
    public void tomarVacina(Individuo individuo) {
        System.out.println(individuo.getNome()+ " ainda não está habilitado(a) para tomar a primeira dose da vacina.\n\n");
        
    }
    @Override
    public String toString() {
        return "Não habilitado(a) para tomar a primeira dose da vacina";
    }
}
