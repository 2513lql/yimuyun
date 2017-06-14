package com.project.common.utils;

/**
 * Created by LQL on 2017/4/10.
 */
public class ScoreUtil {

    public static int getWalkRecordScore(double safeScore,double streetScore,double envirScore){

        double score = (safeScore + streetScore + envirScore) / 3.0;
        double res = (score - 3) * ConfigUtil.getWalkRecordScore();
        return (int)res;

    }

    public static void main(String[] args) {
        System.out.println(getWalkRecordScore(3,2,3));
    }
}
