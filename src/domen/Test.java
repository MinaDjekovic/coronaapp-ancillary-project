/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mina
 */
public class Test implements IOpstiDomenskiObjekat {

    private int testID;
    private TipTesta tip;
    private Date datum;
    private boolean pozitivan;
    private StatusTesta status;
    private Korisnik korisnik;
    

    public Test() {
    }

    public Test(int testID, TipTesta tip, Date datum, boolean pozitivan, StatusTesta status, Korisnik korisnik) {
        this.testID = testID;
        this.tip = tip;
        this.datum = datum;
        this.pozitivan = pozitivan;
        this.status = status;
        this.korisnik = korisnik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public TipTesta getTip() {
        return tip;
    }

    public void setTip(TipTesta tip) {
        this.tip = tip;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public boolean isPozitivan() {
        return pozitivan;
    }

    public void setPozitivan(boolean pozitivan) {
        this.pozitivan = pozitivan;
    }

    public StatusTesta getStatus() {
        return status;
    }

    public void setStatus(StatusTesta status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Test other = (Test) obj;
        if (this.testID != other.testID) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " test ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " ";
    }

    @Override
    public String selectWhere() {
        if (testID != -1) {
            return " WHERE testID=" + testID + " ";
        }
        if (tip != null && korisnik == null) {
            return " WHERE tip='" + tip.toString() + " ";
        }
        if(tip == null && korisnik != null){
            return " WHERE korisnikID="+korisnik.getKorisnikID()+" ";                    
        }
        if(tip != null && korisnik != null){
            return " WHERE tip='" + tip.toString() + "' AND korisnikID="+korisnik.getKorisnikID()+(datum==null ?" ":" AND datum='"+new java.sql.Date(datum.getTime())+"' ");
        }
        return "";

    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> rez = new ArrayList<>();
        while(rs.next()){
            int testID = rs.getInt("testID");
            TipTesta tip = TipTesta.valueOf(rs.getString("tip"));
            Date datum = new java.util.Date(rs.getDate("datum").getTime());
            boolean pozitivan = rs.getBoolean("pozitivan");
            StatusTesta status = StatusTesta.valueOf(rs.getString("status"));
            Korisnik korisnik = null;
            Test test = new Test(testID, tip, datum, pozitivan, status, korisnik);
            rez.add(test);
        }
        return rez;
    }

    @Override
    public String koloneInsert() {
        return " (tip, datum, pozitivan, status, korisnikID) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " testID="+testID+" ";
    }

    @Override
    public String vrednostiInsert() {
        return " '"+tip.toString()+"','"+new java.sql.Date(datum.getTime())+"',"+pozitivan+",'"+status.toString()+"',"+korisnik.getKorisnikID()+" ";
    }

    @Override
    public String vrednostiUpdate() {
        return " tip='"+tip.toString()+"',datum='"+new java.sql.Date(datum.getTime())+"',pozitivan="+pozitivan+",status='"+status.toString()+"',korisnikID="+korisnik.getKorisnikID()+" ";
    }

    @Override
    public String vratiMax() {
        return "testID";
    }

}
