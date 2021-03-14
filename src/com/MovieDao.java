package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import util.conProvider;
public class MovieDao {
	private static Connection con = conProvider.createCon();
	public static Boolean allAllMoviesInDb(List<Movie> movies) {
		Boolean done = false;
		String query = "insert into MovieSchema(id, movieName, movieType, language, releaseDate, casting, rating, tbd) values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			for(Movie m: movies) {
				pstmt.setInt(1, m.getMovieId());
				pstmt.setString(2, m.getMovieName());
				pstmt.setString(3, m.getCategory().toString());
				pstmt.setString(4, m.getLanguage().toString());
				pstmt.setDate(5, m.getReleaseDate());
				pstmt.setString(6, m.getCasting().toString());
				pstmt.setDouble(7, m.getRating());
				pstmt.setDouble(8, m.getTotalBusinessDone());
				pstmt.execute();
			}
			done = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return done;
	}
	
	public static List<Movie> getAllmovies() {
		String query = "Select * from MovieSchema;";
		List<Movie> allmovies = new ArrayList<Movie>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Movie m = new Movie(rs.getInt(1), rs.getString(2), Category.valueOf(rs.getString(3)), Language.valueOf(rs.getString(4)), rs.getDate(5), Arrays.asList(rs.getString(6)), rs.getDouble(7), rs.getDouble(8));
				allmovies.add(m);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return allmovies;		
	}
	
	public static void addMovie(Movie movie, List<Movie> movies) {
		String query = "insert into MovieSchema(id, movieName, movieType, language, releaseDate, casting, rating, tbd) values(?,?,?,?,?,?,?,?)";
		try {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, movie.getMovieId());
				pstmt.setString(2, movie.getMovieName());
				pstmt.setString(3, movie.getCategory().toString());
				pstmt.setString(4, movie.getLanguage().toString());
				pstmt.setDate(5, movie.getReleaseDate());
				pstmt.setString(6, movie.getCasting().toString());
				pstmt.setDouble(7, movie.getRating());
				pstmt.setDouble(8, movie.getTotalBusinessDone());
				pstmt.execute();
				movies.add(movie);
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
