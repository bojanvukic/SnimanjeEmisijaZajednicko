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
public class Emisija implements Serializable, OpstiDomenskiObjekat{
    private int emisijaID;
    private String nazivEmisije;
    private String tipEmisije;

    public Emisija() {
    }

    public Emisija(int emisijaID, String nazivEmisije, String tipEmisije) {
        this.emisijaID = emisijaID;
        this.nazivEmisije = nazivEmisije;
        this.tipEmisije = tipEmisije;
    }

    public int getEmisijaID() {
        return emisijaID;
    }

    public void setEmisijaID(int emisijaID) {
        this.emisijaID = emisijaID;
    }

    public String getNazivEmisije() {
        return nazivEmisije;
    }

    public void setNazivEmisije(String nazivEmisije) {
        this.nazivEmisije = nazivEmisije;
    }

    public String getTipEmisije() {
        return tipEmisije;
    }

    public void setTipEmisije(String tipEmisije) {
        this.tipEmisije = tipEmisije;
    }

    @Override
    public String toString() {
        return nazivEmisije;
    }

    @Override
    public String vratiNazivTabele() throws Exception{
        return "Emisija";
    }

    @Override
    public String vratiInsert() throws Exception{
        return "VALUES ("+emisijaID+",'"+nazivEmisije+"','"+tipEmisije+"')";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> le = new ArrayList<>();
            while (rs.next()) {
                Emisija e = new Emisija();
                e.setEmisijaID(rs.getInt("EmisijaID"));
                e.setNazivEmisije(rs.getString("NazivEmisije"));
                e.setTipEmisije(rs.getString("TipEmisije"));
                le.add(e);
            }
        return le;
    }

    @Override
    public String vratiNazivKoloneID() throws Exception {
        return "EmisijaID";
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
        return "WHERE NazivEmisije Like '" + nazivEmisije +"%' OR TipEmisije Like '" + tipEmisije +"%'";
    }

    @Override
    public String vratiSpajanje() throws Exception {
        return "Emisija";
    }

    @Override
    public String vratiUpdate() throws Exception {
        return "NazivEmisije = '"+nazivEmisije+"', TipEmisije = '"+tipEmisije+"' WHERE EmisijaID = "+emisijaID;
    }

    @Override
    public String vratiDelete() throws Exception {
        return "EmisijaID = " + emisijaID;
    }
    
}
