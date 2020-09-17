package com.test.hackerrant;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RestApiFootballWinner {
    /*
     * Complete the 'getWinnerTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING competition
     *  2. INTEGER year
     */

    public static int getWinnerTotalGoals(String competition, int year) {
        int totalWinnerGoals = 0;
        String winner = getWinner(competition, year);
        if(winner != null && !"".equals(winner)){
            totalWinnerGoals += getGoal(winner, year, 1, true);
            totalWinnerGoals += getGoal(winner, year, 1, false);
        }

        return totalWinnerGoals;
    }

    private static String getWinner(String competition, int year){
        int totalGoals = 0;
        try {
            URL url = new URL("https://jsonmock.hacckerank.com/api/football_matches");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(60000);
            con.setReadTimeout(60000);

            Map<String, String> parameters = new HashMap<>();
            parameters.put("competition", competition);
            parameters.put("year", String.valueOf(year));
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(getParamsString(parameters));
            out.flush();
            out.close();
            int respCode = con.getResponseCode();
            if(respCode==HttpURLConnection.HTTP_OK) {
                String line, resp = "";
                BufferedReader buf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = buf.readLine()) != null) {
                    resp += line;
                }
//                //parse json
//                JSONObject jObj = new JSONObject(resp);
//                return jObj.getString("winner");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private static int getGoal(String team, int year, int page, boolean isTeam1){
        int totalGoals = 0;
        try {
            URL url = new URL("https://jsonmock.hacckerank.com/api/football_matches");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(60000);
            con.setReadTimeout(60000);
            //OutputStream os = con.getOutputStream();
            //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            Map<String, String> parameters = new HashMap<>();
            if(isTeam1)
                parameters.put("team1", team);
            else
                parameters.put("team2", team);
            parameters.put("year", String.valueOf(year));
            parameters.put("page", String.valueOf(page));
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(getParamsString(parameters));
            out.flush();
            out.close();
            int respCode = con.getResponseCode();
            if(respCode==HttpURLConnection.HTTP_OK) {
                String line, resp = "";
                BufferedReader buf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = buf.readLine()) != null) {
                    resp += line;
                }
                //parse json
//                JSONObject jObj = new JSONObject(resp);
//                int current_page = jObj.getInt("page");
//                int total_page = jObj.getInt("total_pages");
//                JSONArray dataJsonArr = jObj.getJSONArray("data");
//                for (int i = 0; i < dataJsonArr.length(); i++) {
//
//                    JSONObject c = dataJsonArr.getJSONObject(i);
//                    // Storing each json item in variable
//                    String goal = c.getString(isTeam1 ? "team1goals": "team2goals");
//                    try {
//                        totalGoals = Integer.parseInt(goal);
//                    } catch(Exception e){
//
//                    }
//                }
//                if(current_page < total_page){
//                    totalGoals += getGoal(team, year, page, isTeam1);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return totalGoals;
    }

    public static String getParamsString(Map<String, String> params)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }
}
