/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval.model;

import java.text.ParseException;
import java.util.Calendar;

/**
 *
 * @author hcadavid
 */
public class AutomatedLoanEvaluator {

    public double getScore(ApplicationDetails ap) {
        String purp = ap.getLoan_Purpose();
        double p;

        double loaninc_ratio = (ap.getLoan_Amount()) / (ap.getAnn_Sal());

        int des = 0;

        if (purp.equalsIgnoreCase("Car Loan")) {
            p = 0.838;
        } else if (purp.equalsIgnoreCase("Credit Card")) {
            p = 0.877;
        } else if (purp.equalsIgnoreCase("Debt Consolidation")) {
            p = 0.831;
        } else if (purp.equalsIgnoreCase("Educational Loan")) {
            p = 0.810;
        } else if (purp.equalsIgnoreCase("Home Improvement Loan")) {
            p = 0.850;
        } else if (purp.equalsIgnoreCase("House Loan")) {
            p = 0.819;
        } else {
            p = 0.815;
        }

        double x = -0.30720295 - (2.42709152 * loaninc_ratio) - (1.61109691 * 0.01 * ap.getWork_Ex_Year())+p*0.212 ;
        double probability = 1 / (1 + Math.exp(-1 * x));
        double score = probability * 666.67;
        return score;
    }

    public boolean isApplicationDeclined(ApplicationDetails application,String[] outcome) throws ParseException {
        int curYear = Calendar.getInstance().get(Calendar.YEAR);
        String dobYear = application.getDob();
        int age = curYear - Integer.parseInt(dobYear.substring(0, 4));

        if (age > 65 || age < 18) {
            outcome[0]="Too young or too old";
            return true;
        }

        int WorkExp = application.getWork_Ex_Year() * 12 + application.getWork_Ex_Mon();

        if (WorkExp < 6) {
            outcome[0]="Too little working experience";
            return true;
        }

        if (application.getAnn_Sal() < 10000) {
            outcome[0]="Too little income";
            return true;
        }

        return false;
    }

}
