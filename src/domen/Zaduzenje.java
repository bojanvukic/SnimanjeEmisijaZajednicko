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
public class Zaduzenje implements Serializable, OpstiDomenskiObjekat{
    private Zaposlen zaposlen;
    private int zaduzenjeID;
    private Date datumZaduzenja;
    private Date datumRazduzenja;
    private boolean vraceno;
    private Oprema oprema;
    private Emisija emisija;
    private Planer planerZaduzio;
    private Planer  planerRazduzio;

    public Zaduzenje() {
        zaposlen = new Zaposlen();
        oprema = new Oprema();
        emisija = new Emisija();
        planerZaduzio = new Planer();
        planerRazduzio = new Planer();
        vraceno = true;
    }

    public Zaduzenje(Zaposlen zaposlen, int zaduzenjeID, Date datumZaduzenja, Date datumRazduzenja, boolean vraceno, Oprema oprema, Emisija emisija, Planer planerZaduzio, Planer planerRazduzio) {
        this.zaposlen = zaposlen;
        this.zaduzenjeID = zaduzenjeID;
        this.datumZaduzenja = datumZaduzenja;
        this.datumRazduzenja = datumRazduzenja;
        this.vraceno = vraceno;
        this.oprema = oprema;
        this.emisija = emisija;
        this.planerZaduzio = planerZaduzio;
        this.planerRazduzio = planerRazduzio;
    }

    public Zaposlen getZaposlen() {
        return zaposlen;
    }

    public void setZaposlen(Zaposlen zaposlen) {
        this.zaposlen = zaposlen;
    }

    public int getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public Date getDatumZaduzenja() {
        return datumZaduzenja;
    }

    public void setDatumZaduzenja(Date datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }

    public Date getDatumRazduzenja() {
        return datumRazduzenja;
    }

    public void setDatumRazduzenja(Date datumRazduzenja) {
        this.datumRazduzenja = datumRazduzenja;
    }

    public boolean isVraceno() {
        return vraceno;
    }

    public void setVraceno(boolean vraceno) {
        this.vraceno = vraceno;
    }

    public Oprema getOprema() {
        return oprema;
    }

    public void setOprema(Oprema oprema) {
        this.oprema = oprema;
    }

    public Emisija getEmisija() {
        return emisija;
    }

    public void setEmisija(Emisija emisija) {
        this.emisija = emisija;
    }

    public Planer getPlanerZaduzio() {
        return planerZaduzio;
    }

    public void setPlanerZaduzio(Planer planerZaduzio) {
        this.planerZaduzio = planerZaduzio;
    }

    public Planer getPlanerRazduzio() {
        return planerRazduzio;
    }

    public void setPlanerRazduzio(Planer planerRazduzio) {
        this.planerRazduzio = planerRazduzio;
    }

    @Override
    public String toString() {
        return "Zaduzenje{" + "zaposlen=" + zaposlen + ", zaduzenjeID=" + zaduzenjeID + ", datumZaduzenja=" + datumZaduzenja + ", datumRazduzenja=" + datumRazduzenja + ", vraceno=" + vraceno + ", oprema=" + oprema + ", emisija=" + emisija + ", planerZaduzio=" + planerZaduzio + ", planerRazduzio=" + planerRazduzio + '}';
    }

    @Override
    public String vratiNazivTabele() throws Exception{
        return "Zaduzenje";
    }

    @Override
    public String vratiInsert() throws Exception{
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return "(ZaposlenID, ZaduzenjeID, DatumZaduzenja, Vraceno, OpremaID, EmisijaID, Zaduzio, Razduzio) VALUES ("+zaposlen.getZaposlenID()+", "+zaduzenjeID+", '"+df.format(datumZaduzenja)+"', "+vraceno+", "+oprema.getOpremaID()+", "+emisija.getEmisijaID()+", "+planerZaduzio.getPlanerID()+", 0)";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lz = new ArrayList<>();
        while (rs.next()) {
            Zaduzenje z = new Zaduzenje();
            z.setZaduzenjeID(rs.getInt("ZaduzenjeID"));
            z.setDatumZaduzenja(rs.getDate("DatumZaduzenja"));
            z.setDatumRazduzenja(rs.getDate("DatumRazduzenja"));
            z.setVraceno(rs.getBoolean("Vraceno"));
            z.getOprema().setOpremaID(rs.getInt(14));
            z.getOprema().setNazivOpreme(rs.getString("NazivOpreme"));
            z.getOprema().setTipOpreme(rs.getString("TipOpreme"));
            z.getEmisija().setEmisijaID(rs.getInt(17));
            z.getEmisija().setNazivEmisije(rs.getString("NazivEmisije"));
            z.getEmisija().setTipEmisije(rs.getString("TipEmisije"));
            z.getPlanerZaduzio().setPlanerID(rs.getInt("Zaduzio"));
            z.getPlanerZaduzio().setIme(rs.getString(10));
            z.getPlanerZaduzio().setPrezime(rs.getString(11));
            z.getPlanerRazduzio().setPlanerID(rs.getInt("Razduzio"));
            z.getPlanerRazduzio().setIme(rs.getString(30));
            z.getPlanerRazduzio().setPrezime(rs.getString(31));
            lz.add(z);
        }
        return lz;
    }

    @Override
    public String vratiNazivKoloneID() throws Exception {
        return "ZaduzenjeID";
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
        return "AND Zaduzenje.Vraceno=False";
    }

    @Override
    public String vratiSpajanje() throws Exception {
        return "Zaposlen INNER JOIN (Planer INNER JOIN (Oprema INNER JOIN (Emisija INNER JOIN (Zaduzenje INNER JOIN Planer AS Planer_1 ON Zaduzenje.Razduzio = Planer_1.PlanerID) ON Emisija.EmisijaID = Zaduzenje.EmisijaID) ON Oprema.OpremaID = Zaduzenje.OpremaID) ON Planer.PlanerID = Zaduzenje.Zaduzio) ON Zaposlen.ZaposlenID = Zaduzenje.ZaposlenID\n" +
                "WHERE Zaposlen.ZaposlenID="+zaposlen.getZaposlenID();
    }

    @Override
    public String vratiUpdate() throws Exception {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return "DatumRazduzenja = '"+df.format(datumRazduzenja)+"', Vraceno = "+vraceno+", Razduzio = "+planerRazduzio.getPlanerID()+" WHERE ZaduzenjeID = "+zaduzenjeID;
    }

    @Override
    public String vratiDelete() throws Exception {
        return "ZaposlenID = " + zaposlen.getZaposlenID() + " AND ZaduzenjeID = " + zaduzenjeID;
    }

    


    
}
