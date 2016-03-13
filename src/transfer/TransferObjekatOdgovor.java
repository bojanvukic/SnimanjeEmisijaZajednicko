/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package transfer;

import java.io.Serializable;

/**
 *
 * @author Bojan
 */
public class TransferObjekatOdgovor implements Serializable{
    private Object odgovor;
    private String rezultat;
    private Object izuzetak;

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Object getIzuzetak() {
        return izuzetak;
    }

    public void setIzuzetak(Object izuzetak) {
        this.izuzetak = izuzetak;
    }
    
    
}
