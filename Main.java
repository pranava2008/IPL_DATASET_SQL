package com.company;

import java.sql.DriverManager;
import java.sql.SQLException;

import static com.company.ConstantValues.*;

public class Main {
    public static void main(String[] args) {


        try {
            getConnection = DriverManager.getConnection(jdbcUrlforDatabase, username, password);
            getStatement = getConnection.createStatement();
            querySolver(FIRST_QUERY, SEASON_COLUMN, MATCH_PLAYED, SECOND_QUERY, TOTAL_WINS);
            querySolver(THIRD_QUERY, BOWLING_TEAMS, EXTRA_RUNS, FOURTH_QUERY, MATCH_WIN);
            getResultSet = getStatement.executeQuery(ConstantValues.FIFTH_QUERY);
            while (getResultSet.next()) {
                String bowler = getResultSet.getString(BOWLER_COLUMN);
                Float economicalRate = Float.parseFloat(getResultSet.getString(ECONOMICAL_RATE));
                System.out.printf("%-30s %.2f\n" ,bowler,economicalRate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (getStatement != null) {
                    getStatement.close();
                }
                if (getResultSet != null) {
                    getResultSet.close();
                }
                if (getConnection != null) {
                    getConnection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static void querySolver(String firstQuery, String seasonColumn, String matchPlayed2, String secondQuery, String totalWins2) throws SQLException {
        query1(firstQuery, matchPlayed2, seasonColumn);
        query1(secondQuery, totalWins2, WINNER_COLUMN);
    }

    private static void query1(String secondQuery, String totalWins2, String winnerColumn) throws SQLException {
        getResultSet = getStatement.executeQuery(secondQuery);
        while (getResultSet.next()) {
            String winner = getResultSet.getString(winnerColumn);
            String totalWins = getResultSet.getString(totalWins2);
            System.out.printf("%-30s %s\n" ,winner, totalWins);
        }
        System.out.println("\n\n");
    }
}
