/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input;
import static com.badlogic.gdx.math.MathUtils.atan2;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author aluno
 */
public class Chegar extends AlgoritmoMovimentacao {
    
    private static final char NOME = 'a';
    
    public Chegar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Chegar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        
        output.velocidade = new Vector3 (super.alvo.getObjetivo().x - agente.posicao.x, super.alvo.getObjetivo().y - agente.posicao.y, super.alvo.getObjetivo().z - agente.posicao.z);
        
        if(output.velocidade.len() < 10){
            output.velocidade = new Vector3();
            return output;
        }
        
        output.velocidade.scl((float) 0.5);
        
        if(output.velocidade.len() > super.maxVelocidade){
            output.velocidade.nor();
            output.velocidade.scl(super.maxVelocidade);
        }
        
        agente.orientacao = atan2(output.velocidade.y, output.velocidade.x);
        
        output.rotacao = 0;
        
        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Input.Keys.A;
    }
    
    
}
