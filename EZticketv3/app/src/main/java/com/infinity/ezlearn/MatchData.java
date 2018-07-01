package com.infinity.ezlearn;

/**
 * Created by Nadzir on 12/14/2017.
 */

public class MatchData {
    public static String match[] = new String[14];;
    public static boolean bigmatch[] = new boolean[14];
    public static String competition[]= new String[14];
    public static String time[] = new String[14];

    public static void addMatchData(String m, boolean bm, String c, String t, int i){
        MatchData.match[i] = m;
        MatchData.bigmatch[i] = bm;
        MatchData.competition[i] = c;
        MatchData.time[i] = t;
    }
}

