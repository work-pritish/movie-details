package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovieService {
	public static List<Movie> populateMovies(File file) {
		List<Movie> allMovies = new ArrayList<Movie>();
		Scanner reader;
		try {
			reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String data[] = reader.nextLine().split(",");
				String cast[] = data[5].split("/");
				List<String> casting = Arrays.asList(cast);
				Movie m = new Movie(Integer.parseInt(data[0]), data[1], Category.valueOf(data[2].toUpperCase()), Language.valueOf(data[3].toUpperCase()), Date.valueOf(data[4]), casting, Double.parseDouble(data[6]), Double.parseDouble(data[7]));
				allMovies.add(m);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return allMovies;
	}
	public static void displayMovies(List<Movie> movies) {
		for(Movie m: movies) {
			System.out.println("movie id:" + m.getMovieId());
			System.out.println("movie name: " + m.getMovieName());
			System.out.println("movie type: " + m.getCategory());
			System.out.println("movie language: " + m.getLanguage());
			System.out.println("release date: " + m.getReleaseDate());
			System.out.println("cast: " + m.getCasting());
			System.out.println("rating: " + m.getRating());
			System.out.println("total business: " + m.getTotalBusinessDone());
		}
	}
	
	public static List<Movie> getMoviesRealeasedInYear(int year) {
		List<Movie> allMovies = MovieDao.getAllmovies();
		List<Movie> result = new ArrayList<Movie>();
		for(Movie m: allMovies) {
			Date d = m.getReleaseDate();
			String sd = d.toString().substring(0, 4);
			if( Integer.parseInt(sd) == year)
				result.add(m);
		}
		return result;
	}
	List<Movie> getMoviesByActor(String actorName) {
		List<Movie> allMovies = MovieDao.getAllmovies();
		List<Movie> result = new ArrayList<Movie>();
		for(Movie m: allMovies) {
			String cast_str = m.getCasting().get(0);
			String cast[] = cast_str.substring(0, cast_str.length() - 1).split(",");
			for(int i = 0; i < cast.length; i++) {
				if(actorName.equals(cast[i]))
					result.add(m);
			}
		}
		return result;
	}
	
	public static void updateRatings(Movie movie, double rating ,List<Movie> movies) {
		for(Movie m: movies) {
			if(movie.getMovieId() == m.getMovieId()) {
				m.setRating(rating);
				break;
			}
		}
	}
	
	public static void updateBusiness(Movie movie, double amount,List<Movie> movies) {
		for(Movie m: movies) {
			if(movie.getMovieId() == m.getMovieId()) {
				m.setTotalBusinessDone(amount);;
				break;
			}
		}
	}
	
	public static List<Movie> businessDone(double amount) {
		List<Movie> allMovies = MovieDao.getAllmovies();
		List<Movie> result = new ArrayList<Movie>();
		for(Movie m: allMovies) {
			if(m.getTotalBusinessDone() > amount) {
				result.add(m);
			}
		}
		return result;
	}
	
	//for testing all function | here is main function
	public static void main(String []args) {
//		File f = new File("C:\\Users\\lenovo\\Desktop\\Persistent docs\\learnings\\java\\ELTP_Assignments\\ass9\\Ass09_Pritish_Patel\\src\\com\\movieDetails.txt");
//		List<Movie> allMovies = populateMovies(f);
//		if(MovieDao.allAllMoviesInDb(allMovies))
//			System.out.println("inserted success !!");
//		else
//			System.out.println("problem occured !!");
		
//		List<Movie> allMovies = MovieDao.getAllmovies();
//		displayMovies(allMovies);
		

	}
}
