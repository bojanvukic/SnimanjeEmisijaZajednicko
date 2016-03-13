/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bojan
 */
public class Mesto implements Serializable, OpstiDomenskiObjekat{
    private int ptt;
    private String naziv;

    public Mesto() {
    }

    public Mesto(int ptt, String naziv) {
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return ptt + " - " + naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Mesto)) {
            return false;
        }
        Mesto m = (Mesto)o;
        if (m.getPtt() == this.ptt) {
            return true;
        }
        return false;
    }

    @Override
    public String vratiNazivTabele() throws Exception{
        return "Mesto";
    }

    @Override
    public String vratiInsert() throws Exception{
        return "VALUES ("+ptt+",'"+naziv+"')";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lm = new ArrayList<>();
        while (rs.next()) {
            Mesto m = new Mesto();
            m.setPtt(rs.getInt("Ptt"));
            m.setNaziv(rs.getString("Naziv"));
            lm.add(m);
        }
        return lm;
    }

    @Override
    public String vratiNazivKoloneID() throws Exception {
        return "Ptt";
    }

    @Override
    public String vratiID(ResultSet rs) throws Exception {
        int ID = 0;
        if (rs.next()) {
            ID = rs.getInt("Sifra");
        }
        ID++;
        return Integer.toString(ID);
    }

    @Override
    public String vratiKriterijum() throws Exception {
        return " ";
    }

    @Override
    public String vratiSpajanje() throws Exception {
        return "Mesto";
    }

    @Override
    public String vratiUpdate() throws Exception {
        return "Naziv = '"+naziv+"' WHERE Ptt = " + ptt;
    }

    @Override
    public String vratiDelete() throws Exception {
        return "Ptt = " + ptt;
    }
    
    
}
