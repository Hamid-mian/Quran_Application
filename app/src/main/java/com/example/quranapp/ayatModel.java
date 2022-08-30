package com.example.quranapp;

public class ayatModel {
    int AyaID;
    int SuraID;
    int AyaNo;
    String Arabic_Text;
    String Fateh_Muhammad_Jalandhri;
    String Mehmood_ul_Hassan;
    String Dr_Mohsin_Khan;
    String Mufti_Taqi_Usmani;
    int RakuID;
    int PRakuID;
    int ParaID;

    public ayatModel(int ayaID, int suraID, int ayaNo, String arabic_Text, String fateh_Muhammad_Jalandhri, String mehmood_ul_Hassan, String dr_Mohsin_Khan, String mufti_Taqi_Usmani, int rakuID, int PRakuID, int paraID) {
        AyaID = ayaID;
        SuraID = suraID;
        AyaNo = ayaNo;
        Arabic_Text = arabic_Text;
        Fateh_Muhammad_Jalandhri = fateh_Muhammad_Jalandhri;
        Mehmood_ul_Hassan = mehmood_ul_Hassan;
        Dr_Mohsin_Khan = dr_Mohsin_Khan;
        Mufti_Taqi_Usmani = mufti_Taqi_Usmani;
        RakuID = rakuID;
        this.PRakuID = PRakuID;
        ParaID = paraID;
    }
}
