/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL_Loader;

import java.util.ArrayList;

/**
 *
 * Generic class to create YearData object for further analysis
 * Used in LineGraph
 * @author Michal Dioszegi
 * w1703164
 */
public class YearData implements Comparable<YearData>
{
    private String yearName;
    private double january;
    private double february;
    private double march;
    private double april;
    private double may;
    private double june;
    private double july;
    private double august;
    private double september;
    private double october;
    private double november;
    private double december;
    private double[] yrArr;

    public YearData(String yearName, double january, double february, double march, double april, double may, double june, double july, double august, double september, double october, double november, double december) {
        this.yearName = yearName;
        this.january = january;
        this.february = february;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.october = october;
        this.november = november;
        this.december = december;
        
        yrArr = new double[12];
        for(int i = 0; i < 12; i++)
        {
            yrArr[i] = 0.0;
        }
    }

    /**
     * Loading information into an array to simplify iteration and analysis
     */
    public void loadINtoArray()
    {
        yrArr[0] = getJanuary();
        yrArr[1] = getFebruary();
        yrArr[2] = getMarch();
        yrArr[3] = getApril();
        yrArr[4] = getMay();
        yrArr[5] = getJune();
        yrArr[6] = getJuly();
        yrArr[7] = getAugust();
        yrArr[8] = getOctober();
        yrArr[9] = getNovember();
        yrArr[10] = getOctober();
        yrArr[11] = getDecember();
    }
    
    public double[] getArray()
    {
        return yrArr;
    }
    
    
    public double getJanuary() {
        return january;
    }

    public double getFebruary() {
        return february;
    }

    public double getMarch() {
        return march;
    }

    public double getApril() {
        return april;
    }

    public double getMay() {
        return may;
    }

    public double getJune() {
        return june;
    }

    public double getJuly() {
        return july;
    }

    public double getAugust() {
        return august;
    }

    public double getSeptember() {
        return september;
    }

    public double getOctober() {
        return october;
    }

    public double getNovember() {
        return november;
    }

    public double getDecember() {
        return december;
    }

    public String getYearName() {
        return yearName;
    }

    public void setYearName(String yearName) {
        this.yearName = yearName;
    }

    public void setJanuary(double january) {
        this.january = january;
    }

    public void setFebruary(double february) {
        this.february = february;
    }

    public void setMarch(double march) {
        this.march = march;
    }

    public void setApril(double april) {
        this.april = april;
    }

    public void setMay(double may) {
        this.may = may;
    }

    public void setJune(double june) {
        this.june = june;
    }

    public void setJuly(double july) {
        this.july = july;
    }

    public void setAugust(double august) {
        this.august = august;
    }

    public void setSeptember(double september) {
        this.september = september;
    }

    public void setOctober(double october) {
        this.october = october;
    }

    public void setNovember(double november) {
        this.november = november;
    }

    public void setDecember(double december) {
        this.december = december;
    }

    @Override
    public String toString() {
        return "YearData{ YearName: " + yearName + ", january=" + january + ", february=" + february + ", march=" + march + ", april=" + april + ", may=" + may + ", june=" + june + ", july=" + july + ", august=" + august + ", september=" + september + ", october=" + october + ", november=" + november + ", december=" + december + '}';
    }

    @Override
    public int compareTo(YearData o) 
    {
        int comparison = this.getYearName().compareTo(o.getYearName());
        
        return comparison;
    }
}
