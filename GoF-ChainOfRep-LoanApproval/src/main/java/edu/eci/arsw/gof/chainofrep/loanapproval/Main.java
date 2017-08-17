/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval;

import edu.eci.arsw.gof.chainofrep.loanapproval.model.ApplicationDetails;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.AutomatedLoanEvaluator;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String args[]) throws ParseException {
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("John", "", "Connor", "1980-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        
        if (ale.isApplicationDeclined(ad,outcome)){
            LOG.log(Level.INFO, "Application cannot be considered:{0}", outcome[0]);
        }
        else{            
            LOG.log(Level.INFO, "Application score:{0}", ale.getScore(ad));
        }
        
    }
    
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

}
