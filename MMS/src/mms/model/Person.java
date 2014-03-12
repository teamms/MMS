package mms.model;

import mms.model.util.Date;

public class Person {
	private String name,userID,password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Preferences getPreferences() {
		return preferences;
	}
	public void setPreferences(Preferences preferences) {
		this.preferences = preferences;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Misc getMoreDetails() {
		return moreDetails;
	}
	public void setMoreDetails(Misc moreDetails) {
		this.moreDetails = moreDetails;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	private Preferences preferences;
	private Location location;
	private int id;
	private Education education;
	private Job job;
	private Misc moreDetails;
	private String about;
	private String religion;

}
