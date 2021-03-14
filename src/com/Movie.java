package com;

import java.sql.Date;
import java.util.List;

enum Category {
	  DRAMA, ACTION, SCI_FI, COMEDY, ROMANCE, HORROR;
	}

enum Language {
	  ENGLISH, HINDI, MALAYALAM, MARATHI, TAMIL, TELUGU, Korean;
	}
	
public class Movie {
	private int movieId;
	private String movieName;
	private Language language;
	private Category category;
	private Date releaseDate;
	private List<String> casting;
	private Double rating;
	private Double totalBusinessDone;

	Movie(int movieId, String movieName, Category c, Language lang, Date rd, List<String> casting, double rating, double tbd) {
		this.setMovieId(movieId);
		this.setMovieName(movieName);
		this.setCategory(c);
		this.setLanguage(lang);
		this.setReleaseDate(rd);
		this.setCasting(casting);
		this.setRating(rating);
		this.setTotalBusinessDone(tbd);
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<String> getCasting() {
		return casting;
	}

	public void setCasting(List<String> casting) {
		this.casting = casting;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getTotalBusinessDone() {
		return totalBusinessDone;
	}

	public void setTotalBusinessDone(Double totalBusinessDone) {
		this.totalBusinessDone = totalBusinessDone;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
