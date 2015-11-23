/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package senacairlines;

import com.jacksonf.dto.Aviao;
import com.jacksonf.rn.AviaoRN;
import java.util.List;

/**
 *
 * @author 631210442
 */
public class SenacAirlines {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Aviao aviaoA = new Aviao(0, "PT-111", "Aviao A");
        Aviao aviaoB = new Aviao(0, "PT-222", "Aviao A");
        Aviao aviaoC = new Aviao(0, "PT-333", "Aviao C");
        Aviao aviaoD = new Aviao(0, "PT-444", "Aviao D");
        
        AviaoRN aviaoRN = new AviaoRN();
        aviaoRN.salvar(aviaoA);
        aviaoRN.salvar(aviaoB);
        aviaoRN.salvar(aviaoC);
        aviaoRN.salvar(aviaoD);
        
        Aviao aviaoBanco = new Aviao();
        aviaoBanco.setId(1);
        aviaoBanco = aviaoRN.consultar(aviaoBanco);
        String nomeAviao1 = aviaoBanco.getNome();
        
        List<Aviao> avioes = aviaoRN.pesquisar(nomeAviao1);
        
        for (int i = 0; i < avioes.size(); i++) {
            System.err.println(String.format("%s - %s", avioes.get(i).getCodigo(), avioes.get(i).getNome()));
        }
    }
    
}
