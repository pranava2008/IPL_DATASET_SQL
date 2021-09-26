package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConstantValues {
   public  static String jdbcUrlforDatabase = "jdbc:postgresql://localhost:5434/Database_test";
    public static String username = "postgres",WINNER_COLUMN="winner",TOTAL_WINS="total_wins",BOWLING_TEAMS="bowling_team",EXTRA_RUNS="extra_runs";
    public static String password = "toor",SEASON_COLUMN="season",MATCH_PLAYED="match_played",MATCH_WIN="match_win",BOWLER_COLUMN="bowler",ECONOMICAL_RATE="economical_rate";
    public static Connection getConnection = null;
   public static Statement getStatement = null;
    public static ResultSet getResultSet = null;
    public static String curYear = "2016";
    public static String FIRST_QUERY= "select season, count(id) as match_played from matches group by season order by season",
    SECOND_QUERY="select winner, count(winner) as total_wins from matches  where winner is not null group by winner order by winner",
    THIRD_QUERY="select delivery.bowling_team, sum(cast(extra_runs as int) ) as extra_runs from delivery where match_id in (select matches.id from matches where season = '2016') group by bowling_team",
    FOURTH_QUERY="select matches.winner, sum(cast(matches.win_by_runs as int))as match_win from matches where season = '2016' group by winner order by winner;",
    FIFTH_QUERY="select  delivery.bowler, sum(cast(total_runs as int))/cast((count(delivery.bowler)/6)as float) as economical_rate from delivery inner join matches m on delivery.match_id = m.id and m.season='2015' group by bowler order by economical_rate;";
}
