/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Statistika implements  IOpstiDomenskiObjekat{
    private int brojTestiranja;
    private int brojPozitivnih;
    private int brojNegativnih;
    private int brojPodNadzorom;

    public Statistika() {
    }

    public Statistika(int brojTestiranja, int brojPozitivnih, int brojNegativnih, int brojPodNadzorom) {
        this.brojTestiranja = brojTestiranja;
        this.brojPozitivnih = brojPozitivnih;
        this.brojNegativnih = brojNegativnih;
        this.brojPodNadzorom = brojPodNadzorom;
    }

    /**
     * @return the brojTestiranja
     */
    public int getBrojTestiranja() {
        return brojTestiranja;
    }

    /**
     * @param brojTestiranja the brojTestiranja to set
     */
    public void setBrojTestiranja(int brojTestiranja) {
        this.brojTestiranja = brojTestiranja;
    }

    /**
     * @return the brojPozitivnih
     */
    public int getBrojPozitivnih() {
        return brojPozitivnih;
    }

    /**
     * @param brojPozitivnih the brojPozitivnih to set
     */
    public void setBrojPozitivnih(int brojPozitivnih) {
        this.brojPozitivnih = brojPozitivnih;
    }

    /**
     * @return the brojNegativnih
     */
    public int getBrojNegativnih() {
        return brojNegativnih;
    }

    /**
     * @param brojNegativnih the brojNegativnih to set
     */
    public void setBrojNegativnih(int brojNegativnih) {
        this.brojNegativnih = brojNegativnih;
    }

    /**
     * @return the brojPodNadzorom
     */
    public int getBrojPodNadzorom() {
        return brojPodNadzorom;
    }

    /**
     * @param brojPodNadzorom the brojPodNadzorom to set
     */
    public void setBrojPodNadzorom(int brojPodNadzorom) {
        this.brojPodNadzorom = brojPodNadzorom;
    }

    @Override
    public String nazivTabele() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String alijas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String join() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String selectWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String koloneInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostPrimarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vrednostiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
}
