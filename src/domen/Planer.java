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
public class Planer implements Serializable, OpstiDomenskiObjekat{
    private int planerID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaSifra;

    public Planer() {
    }

    public Planer(int planerID, String ime, String prezime, String korisnickoIme, String korisnickaSifra) {
        this.planerID = planerID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public int getPlanerID() {
        return planerID;
    }

    public void setPlanerID(int planerID) {
        this.planerID = planerID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickoSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() throws Exception{
        return "Planer";
    }

    @Override
    public String vratiInsert() throws Exception{
        return "VALUES ("+planerID+",'"+ime+"','"+prezime+"','"+korisnickoIme+"',"+korisnickaSifra+"')";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lp = new ArrayList<>();
        while (rs.next()) {
            planerID = rs.getInt(1);
            ime = rs.getString(2);
            prezime = rs.getString(3);
            korisnickoIme = rs.getString(4);
            korisnickaSifra = rs.getString(5);
            Planer p = new Planer(planerID, ime, prezime, korisnickoIme, korisnickaSifra);
            lp.add(p);
        }
        return lp;
    }

    @Override
    public String vratiNazivKoloneID() throws Exception {
        return "PlanerID";
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
        return "WHERE KorisnickoIme='"+korisnickoIme+"' AND KorisnickaSifra='"+korisnickaSifra+"'";
    }

    @Override
    public String vratiSpajanje() throws Exception {
        return "Planer";
    }

    @Override
    public String vratiUpdate() throws Exception {
        return "PlanerID = "+planerID+", Ime = '"+ime+"', Prezime = '"+prezime+"', KorisnickoIme = '"+korisnickoIme+"', KorisnickaSifra = '"+korisnickaSifra+"' WHERE PlanerID = "+planerID;
    }

    @Override
    public String vratiDelete() throws Exception {
        return "PlanerID = " + planerID;
    }
    
    
}
