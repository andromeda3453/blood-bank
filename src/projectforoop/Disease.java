/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectforoop;

/**
 *
 * @author Lenovo
 */
public class Disease {
    String name;
    String symp;
    String treat;
    
    public Disease(String name, String symp, String treat)
    {
        this.name = name;
        this.symp = symp;
        this.treat = treat;
        
    }
      public void setName(String name) {
        this.name = name;
    }

    public void setSymp(String symp) {
        this.symp = symp;
    }

    public void setTreat(String treat) {
        this.treat = treat;
    }

    public String getName() {
        return name;
    }

    public String getSymp() {
        return symp;
    }

    public String getTreat() {
        return treat;
    }

    
}
