package com.example.naochiennhom2;

public class CauHoi {
    private String CauHoi;
    private String CauTL1, CauTL2, CauTL3, CauTL4;
    private String DapAn;

    public CauHoi(String cauHoi, String cauTL1, String cauTL2, String cauTL3, String cauTL4, String dapAn) {
        CauHoi = cauHoi;
        CauTL1 = cauTL1;
        CauTL2 = cauTL2;
        CauTL3 = cauTL3;
        CauTL4 = cauTL4;
        DapAn = dapAn;
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(String cauHoi) {
        CauHoi = cauHoi;
    }

    public String getCauTL1() {
        return CauTL1;
    }

    public void setCauTL1(String cauTL1) {
        CauTL1 = cauTL1;
    }

    public String getCauTL2() {
        return CauTL2;
    }

    public void setCauTL2(String cauTL2) {
        CauTL2 = cauTL2;
    }

    public String getCauTL3() {
        return CauTL3;
    }

    public void setCauTL3(String cauTL3) {
        CauTL3 = cauTL3;
    }

    public String getCauTL4() {
        return CauTL4;
    }

    public void setCauTL4(String cauTL4) {
        CauTL4 = cauTL4;
    }

    public String getDapAn() {
        return DapAn;
    }

    public void setDapAn(String dapAn) {
        DapAn = dapAn;
    }
}
