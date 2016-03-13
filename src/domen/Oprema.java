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
public class Oprema implements Serializable, OpstiDomenskiObjekat{
    private int opremaID;
    private String nazivOpreme;
    private String tipOpreme;

    public Oprema() {
    }

    public Oprema(int opremaID, String nazivOpreme, String tipOpreme) {
        this.opremaID = opremaID;
        this.nazivOpreme = nazivOpreme;
        this.tipOpreme = tipOpreme;
    }

    public int getOpremaID() {
        return opremaID;
    }

    public void setOpremaID(int opremaID) {
        this.opremaID = opremaID;
    }

    public String getNazivOpreme() {
        return nazivOpreme;
    }

    public void setNazivOpreme(String nazivOpreme) {
        this.nazivOpreme = nazivOpreme;
    }

    public String getTipOpreme() {
        return tipOpreme;
    }

    public void setTipOpreme(String tipOpreme) {
        this.tipOpreme = tipOpreme;
    }

    @Override
    public String toString() {
        return nazivOpreme;
    }

    @Override
    public String vratiNazivTabele() throws Exception{
        return "Oprema";
    }

    @Override
    public String vratiInsert() throws Exception{
        return "VALUES ("+opremaID+",'"+nazivOpreme+"','"+tipOpreme+"')";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lo = new ArrayList<>();
            while (rs.next()) {
                Oprema o = new Oprema();
                o.setOpremaID(rs.getInt("OpremaID"));
                o.setNazivOpreme(rs.getString("NazivOpreme"));
                o.setTipOpreme(rs.getString("TipOpreme"));
                lo.add(o);
            }
        return lo;
    }

    @Override
    public String vratiNazivKoloneID() throws Exception {
        return "OpremaID";
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
        return "Oprema";
    }

    @Override
    public String vratiUpdate() throws Exception {
        return "NazivOpreme = '"+nazivOpreme+"', TipOpreme = '"+tipOpreme+"' WHERE OpremaID = " + opremaID;
    }

    @Override
    public String vratiDelete() throws Exception {
        return "OpremaID = " + opremaID;
    }
    
    
}
