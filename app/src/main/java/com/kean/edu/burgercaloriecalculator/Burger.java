package com.kean.edu.burgercaloriecalculator;

public class Burger {
    public static final int BEEF = 100;
    public static final int LAMB = 170;
    public static final int OSTRICH = 150;

    public static final int PROSCIUTTO = 115;

    public static  final int ASIAGO = 90;
    public static final int CREME_FRAICHE = 120;

    private int mPattyCal;
    private int mProsciuttoCal;
    private int mCheeseCal;
    private int mSauceCal;

    public Burger() {
        mPattyCal = 0;
        mProsciuttoCal = 0;
        mCheeseCal = 0;
        mSauceCal = 0;
    }

    public void setPattyCalories(int calories) {
        mPattyCal = calories;
    }

    public void setCheeseCalories(int calories) {
        mCheeseCal = calories;
    }

    public void setProsciuttoCalories(int calories) {
        mProsciuttoCal = calories;
    }

    public void clearProsciuttoCalories() {
        mProsciuttoCal = 0;
    }

    public void setSauceCalories(int calories) {
        mSauceCal = calories;
    }

    public int getTotalCalories() {
        int totalCalories = mPattyCal + mCheeseCal + mProsciuttoCal + mSauceCal;
        System.out.println("Patty: " + mPattyCal + ", Cheese: " + mCheeseCal +
                ", Prosciutto: " + mProsciuttoCal + ", Sauce: " + mSauceCal + ", Total: " + totalCalories);
        return totalCalories;
    }

}
