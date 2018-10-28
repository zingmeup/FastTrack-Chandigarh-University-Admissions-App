package com.example.deepakyadav.fasttrack.Phase1.DataModels;

public class ProgramModel {
    private String programCode;
    private String getProgramname;

    public ProgramModel(String programCode, String getProgramname) {
        this.programCode = programCode;
        this.getProgramname = getProgramname;
    }

    public String getProgramCode() {
        return programCode;
    }

    public String getGetProgramname() {
        return getProgramname;
    }

    @Override
    public String toString() {
        return this.getGetProgramname();
    }
}
