
package com.pss.dadosclima.presenter.Panels;

import com.pss.enums.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.view.UltimaFrame;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JInternalFrame;

/**
 *
 * @author UFES
 */
public class UltimoPresenter implements Painel{
    private UltimaFrame view;
    private ArrayList<DadoClima> dados =new ArrayList<>();

    public UltimoPresenter() {
        view=new UltimaFrame();
        
        view.setVisible(true);
    }
    
    public void atualizar(DadoClima dado, Operacao op){
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        switch(op){
            case INCLUIR:
                dados.add(dado);
                break;
            case EXCLUIR:
                dados.remove(dado);
                break;
        }
        if(dados.isEmpty()){
        view.getDataField().setText("");
        view.getTemperaturaField().setText("");
        view.getUmidadeField().setText("");
        view.getPressaoField().setText("");
        }
        else{
        view.getDataField().setText(dados.get(dados.size()-1).getData().format(formatter));
        view.getTemperaturaField().setText(String.valueOf(dados.get(dados.size()-1).getTemperatura()));
        view.getUmidadeField().setText(String.valueOf(dados.get(dados.size()-1).getUmidade()));
        view.getPressaoField().setText(String.valueOf(dados.get(dados.size()-1).getPressao()));
        }
        view.repaint();
    }
     public JInternalFrame getFrame(){
        return view;
    }
}
