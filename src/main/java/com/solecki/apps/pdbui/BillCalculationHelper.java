package com.solecki.apps.pdbui;

import lombok.experimental.UtilityClass;

import java.text.DecimalFormat;

@UtilityClass
public class BillCalculationHelper {

    public static double calculateBillForCustomer(double billAmount, double taxRate) {
        double finalBillAmount = billAmount * (1 + taxRate / 100);
        String result = new DecimalFormat("0.00").format(finalBillAmount);
        return Double.parseDouble(result);
    }

}
