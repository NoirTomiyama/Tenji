package com.lifeistech.android.tenji;

public class Braille {

    private int weight;
    private String unVoiced;
    private String number;
    private String voiced;
    private String semiVoiced;
    private String contracted;
    private String contractedVoiced;
    private String contractedSemiVoiced;

    private int resId;
    private char japanese;

    Braille(){

    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public char getJapanese() {
        return japanese;
    }

    public void setJapanese(char japanese) {
        this.japanese = japanese;
    }

    Braille(int resId, char japanese){
        this.resId = resId;
        this.japanese = japanese;

    }

    Braille(int weight,String unVoiced) {
        this.weight = weight;
        this.unVoiced = unVoiced;
        this.number = "";
        this.voiced = "";
        this.semiVoiced = "";
        this.contracted = "";
        this.contractedVoiced = "";
        this.contractedSemiVoiced = "";
    }

//    Braille(int weight,String unVoiced,String number,String voiced,String semiVoiced,String contracted,String contractedVoiced,String contractedSemiVoiced) {
//        this.weight = weight;
//        this.unVoiced = unVoiced;
//        this.number = number;
//        this.voiced = voiced;
//        this.semiVoiced = semiVoiced;
//        this.contracted = contracted;
//        this.contractedVoiced = contractedVoiced;
//        this.contractedSemiVoiced = contractedSemiVoiced;
//    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getUnVoiced() {
        return unVoiced;
    }

    public void setUnVoiced(String unVoiced) {
        this.unVoiced = unVoiced;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVoiced() {
        return voiced;
    }

    public void setVoiced(String voiced) {
        this.voiced = voiced;
    }

    public String getSemiVoiced() {
        return semiVoiced;
    }

    public void setSemiVoiced(String semiVoiced) {
        this.semiVoiced = semiVoiced;
    }

    public String getContracted() {
        return contracted;
    }

    public void setContracted(String contracted) {
        this.contracted = contracted;
    }

    public String getContractedVoiced() {
        return contractedVoiced;
    }

    public void setContractedVoiced(String contractedVoiced) {
        this.contractedVoiced = contractedVoiced;
    }

    public String getContractedSemiVoiced() {
        return contractedSemiVoiced;
    }

    public void setContractedSemiVoiced(String contractedSemiVoiced) {
        this.contractedSemiVoiced = contractedSemiVoiced;
    }
}
