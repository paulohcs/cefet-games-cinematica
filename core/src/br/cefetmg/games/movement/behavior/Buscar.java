package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import static com.badlogic.gdx.math.MathUtils.atan2;
import com.badlogic.gdx.math.Vector3;

/**
 * Guia o agente na direção do alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Buscar extends AlgoritmoMovimentacao {

    private static final char NOME = 's';

    public Buscar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Buscar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();

        // calcula que direção tomar (configura um objeto Direcionamento 
        // e o retorna)
        // ...
        // super.alvo já contém a posição do alvo
        // agente (parâmetro) é a pose do agente que estamos guiando
        // ...
        
        //output.velocidade = super.alvo.getObjetivo().add(agente.posicao.x * -1, agente.posicao.y * -1, agente.posicao.z * -1);
        
        output.velocidade = new Vector3 (super.alvo.getObjetivo().x - agente.posicao.x, super.alvo.getObjetivo().y - agente.posicao.y, super.alvo.getObjetivo().z - agente.posicao.z);
        
        output.velocidade.nor();
        output.velocidade.scl(super.maxVelocidade);
        
        agente.orientacao = atan2(output.velocidade.y, output.velocidade.x);
        
        output.rotacao = 0;
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.S;
    }
}
