package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class CourseBrowserModel {
    String programCode, shortNamr, programName,eligibility,discipline,searchtext,duration, feePerSemRS, feePerSemUSD;

    public CourseBrowserModel(String programCode, String shortNamr, String programName, String eligibility, String discipline, String duration, String feePerSemRS, String feePerSemUSD) {
        this.programCode = programCode;
        this.shortNamr = shortNamr;
        this.programName = programName;
        this.eligibility = eligibility;
        this.discipline = discipline;
        this.duration = duration;
        this.feePerSemRS = feePerSemRS;
        this.feePerSemUSD = feePerSemUSD;
        this.searchtext=programName.replace("(", " ").replace(")", " ")+" "+shortNamr.replace(".","")+" "+shortNamr;
    }

    public String getSearchtext() {
        return searchtext;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getShortNamr() {
        return shortNamr;
    }

    public void setShortNamr(String shortNamr) {
        this.shortNamr = shortNamr;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFeePerSemRS() {
        return feePerSemRS;
    }

    public void setFeePerSemRS(String feePerSemRS) {
        this.feePerSemRS = feePerSemRS;
    }

    public String getFeePerSemUSD() {
        return feePerSemUSD;
    }

    public void setFeePerSemUSD(String feePerSemUSD) {
        this.feePerSemUSD = feePerSemUSD;
    }

    public void setFeePerSemUSD(double feePerSemUSD) {
        feePerSemUSD = feePerSemUSD;
    }
}
