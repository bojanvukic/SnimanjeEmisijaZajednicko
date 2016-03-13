/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Bojan
 */
public interface OpstiDomenskiObjekat {

    public String vratiNazivTabele() throws Exception;

    public String vratiInsert() throws Exception;

    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;
    
    public String vratiNazivKoloneID() throws Exception;

    public String vratiID(ResultSet rs) throws Exception;
    
    public String vratiKriterijum() throws Exception;
    
    public String vratiSpajanje() throws Exception;
    
    public String vratiUpdate() throws Exception;
    
    public String vratiDelete() throws Exception;
        
}
