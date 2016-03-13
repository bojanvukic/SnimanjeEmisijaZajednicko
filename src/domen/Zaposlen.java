/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bojan
 */
public class Zaposlen implements Serializable, OpstiDomenskiObjekat{
    private int zaposlenID;
    private String ime;
    private String prezime;
    private String jmbg;
    private Date datumZaposlenja;
    private String telefon;
    private String adresa;
    private Mesto mesto;
    private List<Zaduzenje> listaZaduzenja;

    public Zaposlen() {
        datumZaposlenja = new Date();
        mesto = new Mesto();
        listaZaduzenja = new ArrayList<>();
    }

    public Zaposlen(int zaposlenID, String ime, String prezime, String jmbg, Date datumZaposlenja, String telefon, String adresa, Mesto mesto) {
        this.zaposlenID = zaposlenID;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumZaposlenja = datumZaposlenja;
        this.telefon = telefon;
        this.adresa = adresa;
        this.mesto = mesto;
    }

    public Zaposlen(int zaposlenID, String ime, String prezime, String jmbg, Date datumZaposlenja, String telefon, String adresa, Mesto mesto, List<Zaduzenje> listaZaduzenja) {
        this.zaposlenID = zaposlenID;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.datumZaposlenja = datumZaposlenja;
        this.telefon = telefon;
        this.adresa = adresa;
        this.mesto = mesto;
        this.listaZaduzenja = listaZaduzenja;
    }

    public int getZaposlenID() {
        return zaposlenID;
    }

    public void setZaposlenID(int zaposlenID) {
        this.zaposlenID = zaposlenID;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(Date datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public List<Zaduzenje> getListaZaduzenja() {
        return listaZaduzenja;
    }

    public void setListaZaduzenja(List<Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiNazivTabele() throws Exception{
        return "Zaposlen";
    }

    @Override
    public String vratiInsert() throws Exception{
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return "VALUES ("+zaposlenID+",'"+ime+"','"+prezime+"','"+jmbg+"','"+df.format(datumZaposlenja)+"','"+telefon+"','"+adresa+"',"+mesto.getPtt()+")";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lz = new ArrayList<>();
        while (rs.next()) {
            Zaposlen z = new Zaposlen();
            z.setZaposlenID(rs.getInt("ZaposlenID"));
            z.setIme(rs.getString("Ime"));
            z.setPrezime(rs.getString("Prezime"));
            z.setJmbg(rs.getString("JMBG"));
            z.setDatumZaposlenja(rs.getDate("DatumZaposlenja"));
            z.setTelefon(rs.getString("Telefon"));
            z.setAdresa(rs.getString("Adresa"));
            z.getMesto().setPtt(rs.getInt(8));
            z.getMesto().setNaziv(rs.getString("Naziv"));
            lz.add(z);
        }
        return lz;
    }

    @Override
    public String vratiNazivKoloneID() throws Exception {
        return "ZaposlenID";
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
        return "WHERE Ime Like '" + ime + "%' OR Prezime Like '" + prezime + "%'";
    }

    @Override
    public String vratiSpajanje() throws Exception {
        return "Zaposlen INNER JOIN Mesto ON (Zaposlen.Ptt=Mesto.Ptt)";
    }

    @Override
    public String vratiUpdate() throws Exception {
        return "Ime = '"+ime+"', Prezime = '"+prezime+"', JMBG = '"+jmbg+"', Telefon = '"+telefon+"', Adresa = '"+adresa+"', Ptt = "+mesto.getPtt()+" WHERE ZaposlenID = "+zaposlenID;
    }

    @Override
    public String vratiDelete() throws Exception {
        return "ZaposlenID = " + zaposlenID;
    }

}
