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
public class Korisnik implements IOpstiDomenskiObjekat {

    private int korisnikID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private Pol pol;
    private String email;
    private Stanje stanje;
    private Date poslednjaPrijava;
    private boolean admin;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, String korisnickoIme, String lozinka, Pol pol, String email, Stanje stanje, Date poslednjaPrijava, boolean admin) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.pol = pol;
        this.email = email;
        this.stanje = stanje;
        this.poslednjaPrijava = poslednjaPrijava;
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Stanje getStanje() {
        return stanje;
    }

    public void setStanje(Stanje stanje) {
        this.stanje = stanje;
    }

    public Date getPoslednjaPrijava() {
        return poslednjaPrijava;
    }

    public void setPoslednjaPrijava(Date poslednjaPrijava) {
        this.poslednjaPrijava = poslednjaPrijava;
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
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikID != other.korisnikID) {
            return false;
        }
        return true;
    }

    @Override
    public String nazivTabele() {
        return " korisnik ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " ";
    }

    @Override
    public String selectWhere() {
        if (korisnikID != -1) {
            return " WHERE korisnikID=" + korisnikID + " ";
        }
        if (korisnickoIme != null && lozinka == null) {
            return " WHERE korisnickoIme='" + korisnickoIme + "' ";
        }
        if (korisnickoIme != null && lozinka != null) {
            return " WHERE korisnickoIme='" + korisnickoIme + "' AND lozinka='" + lozinka + "' ";
        }
        if (stanje != null) {
            return " WHERE stanje='" + stanje.toString() + "' ";
        }
        return " ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> rez = new ArrayList<>();
        while(rs.next()){
            int korisnikID = rs.getInt("korisnikID");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String korisnickoIme = rs.getString("korisnickoIme");
            String lozinka = rs.getString("lozinka");
            Pol pol = Pol.valueOf(rs.getString("pol"));
            String email = rs.getString("email");
            Stanje stanje = Stanje.valueOf(rs.getString("stanje"));
            Date poslednjaPrijava = new java.util.Date(rs.getDate("poslednjaPrijava").getTime());
            boolean admin = rs.getBoolean("admin");
            Korisnik korisnik = new Korisnik(korisnikID, ime, prezime, korisnickoIme, lozinka, pol, email, stanje, poslednjaPrijava, admin);
            rez.add(korisnik);
        }
        return rez;
    }

    @Override
    public String koloneInsert() {
        return "(ime, prezime, korisnickoIme, lozinka, pol, email, stanje, poslednjaPrijava, admin) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " korisnikID="+korisnikID+" ";
    }

    @Override
    public String vrednostiInsert() {
        return " '"+ime+"','"+prezime+"','"+korisnickoIme+"','"+lozinka+"','"+pol.toString()+"','"+email+"','"+stanje.toString()+"','"+new java.sql.Date(poslednjaPrijava.getTime())+"',"+admin+" ";
    }

    @Override
    public String vrednostiUpdate() {
        return " ime='"+ime+"',prezime='"+prezime+"',korisnickoIme='"+korisnickoIme+"',lozinka='"+lozinka+"', pol='"+pol.toString()+"',email='"+email+"',stanje='"+stanje.toString()+"',poslednjaPrijava='"+new java.sql.Date(poslednjaPrijava.getTime())+"',admin="+admin+" ";
    }

    @Override
    public String vratiMax() {
        return "korisnikID";
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }
    
    

}
