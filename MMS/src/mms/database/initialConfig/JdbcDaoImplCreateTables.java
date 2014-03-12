package mms.database.initialConfig;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import mms.model.Education;
import mms.model.Job;
import mms.model.Location;
import mms.model.Misc;
import mms.model.Person;
import mms.model.Preferences;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.test.jdbc.JdbcTestUtils;

@SuppressWarnings("deprecation")
public class JdbcDaoImplCreateTables extends SimpleJdbcDaoSupport{
	
	public void addEducationEntry(int personId,Education education){
		//String sql="create table triangle (id integer,name varchar(50))";
		String sql="insert into Education (Education_Person_Mapping_ID,TenthBoard,TwelfthBoard,GraduationArea,DegreeName,CollegeName) values (?,?,?,?,?,?)";
		//SqlParameterSource namedParameters=new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		getSimpleJdbcTemplate().update(sql,new Object[] {personId,education.getTenthBoard(),education.getTwelfthBoard(),education.getGraduationArea(),education.getDegreeName(),education.getCollegeName()});
		//getSimpleJdbcTemplate().update(sql, namedParameters);
	}
	
	public void addPersonEntry(Person person){
		String sql="insert into Person (userid,password,about,religion) values (?,?,?,?)";
		//getSimpleJdbcTemplate().update(sql, new Object[] {"jaseel","12345","this is test","muslim"});
		getSimpleJdbcTemplate().update(sql, new Object[] {person.getUserID(),person.getPassword(),person.getAbout(),person.getReligion()});
	
	}
	
	public void addLocationionEntry(int personId,Location location){
		String sql="insert into Location (Location_Person_Mapping_ID,CurrentCity,CurrentState,NativeCity,NativeState) values (?,?,?,?,?)";
		getSimpleJdbcTemplate().update(sql, new Object[] {personId,location.getCurrentCity(),location.getCurrentState(),location.getNativeCity(),location.getNativeState()});
		
	}
	public void addMiscEntry(int personId,Misc misc){
		String sql="insert into Misc (Misc_Person_Mapping_ID,Smoking,Diet,Drinking,Day,Month,Year,Height,Weight,Complexion,Additional) values (?,?,?,?,?,?,?,?,?,?,?)";
		getSimpleJdbcTemplate().update(sql, new Object[] {personId,misc.getSmoking(),misc.getDiet(),misc.getDrinking(),misc.getDay(),misc.getMonth(),misc.getYear(),misc.getHeight(),misc.getWeight(),misc.getComplexion(),misc.getAdditionalDetails(),});
		
	}
	
	public void addJobEntry(int personId,Job job){
		String sql="insert into Job (Job_Person_Mapping_ID,JobTitle,Field,CompanyName,Salary,Location) values (?,?,?,?,?,?)";
		getSimpleJdbcTemplate().update(sql, new Object[] {personId,job.getJobTitle(),job.getField(),job.getCompanyName(),job.getSalary(),job.getLocation()});
		
	}
	
	public void addPreferencesEntry(int personId,Preferences preferences){
		String sql="insert into Preferences (Preferences_Person_Mapping_ID,PreferredLocation,PreferredReligion,PreferredEducation,PreferredComplexion,PreferredIncome) values (?,?,?,?,?,?)";
		getSimpleJdbcTemplate().update(sql, new Object[] {personId,preferences.getPreferredLocation(),preferences.getPreferredReligion(),preferences.getPreferredEducation(),preferences.getPreferredComplexion(),preferences.getPreferredIncome()});
		
	}
	
	
	public void createPersonTable(){
		String sql="create table persontest2 (id int not null,name varchar(50),primary key (id))";
		
		getSimpleJdbcTemplate().update(sql);
	}
	public void runScriptFile() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("script.sql"));
		LineNumberReader fileReader = new LineNumberReader(in);
		String query = JdbcTestUtils.readScript(fileReader);
		//String sql="create table persontest2 (id int not null,name varchar(50),primary key (id))";
		
		//getSimpleJdbcTemplate().update(sql);
	}
	
	public static final class LocationMapper implements RowMapper<Location>{

		@Override
		public Location mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Location location=new Location();
			location.setCurrentCity(resultSet.getString("currentcity"));
			location.setCurrentState(resultSet.getString("currentstate"));
			location.setNativeCity(resultSet.getString("nativecity"));
			location.setNativeState(resultSet.getString("nativestate"));
			return location;
			
		}

		
		
	}
	public static final class EducationMapper implements RowMapper<Education>{

		@Override
		public Education mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Education education=new Education();
			education.setTenthBoard(resultSet.getString("tenthBoard"));
			education.setTwelfthBoard(resultSet.getString("TwelfthBoard"));
			education.setGraduationArea(resultSet.getString("GraduationArea"));
			education.setDegreeName(resultSet.getString("DegreeName"));
			education.setCollegeName(resultSet.getString("CollegeName"));
			education.setPostGraduation(resultSet.getString("PostGraduation"));
			return education;
			
		}

		
		
	}
	
	public static final class JobMapper implements RowMapper<Job>{

		@Override
		public Job mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Job job=new Job();
			job.setJobTitle(resultSet.getString("JobTitle"));
			job.setField(resultSet.getString("Field"));
			job.setCompanyName(resultSet.getString("CompanyName"));
			job.setLocation(resultSet.getString("Location"));
			job.setSalary(resultSet.getInt("Salary"));
			return job;
			
		}

		
		
	}
	
	public static final class MiscMapper implements RowMapper<Misc>{

		@Override
		public Misc mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Misc misc=new Misc();
			misc.setDiet(resultSet.getString("Diet"));
			misc.setDrinking(resultSet.getString("Drinking"));
			misc.setSmoking(resultSet.getString("Smoking"));
			misc.setComplexion(resultSet.getString("Complexion"));
			misc.setAdditionalDetails(resultSet.getString("AdditionalDetails"));
			misc.setYear(resultSet.getInt("Year"));
			misc.setDay(resultSet.getInt("Day"));
			misc.setMonth(resultSet.getInt("Month"));
			misc.setHeight(resultSet.getFloat("Height"));
			misc.setWeight(resultSet.getInt("Weight"));
			return misc;
			
		}	
		
	}
	
	public static final class PersonMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Person person=new Person();
			person.setName(resultSet.getString("Name"));
			person.setId(resultSet.getInt("person_id"));
			person.setReligion(resultSet.getString("religion"));
			person.setAbout(resultSet.getString("About"));
			return person;
			
		}

		
		
	}
	public static final class PreferencesMapper implements RowMapper<Preferences>{

		@Override
		public Preferences mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Preferences preferences=new Preferences();
			preferences.setPreferredLocation(resultSet.getString("PreferredLocation"));
			preferences.setPreferredReligion(resultSet.getString("PreferredReligion"));
			preferences.setPreferredEducation(resultSet.getString("PreferredEducation"));
			preferences.setPreferredComplexion(resultSet.getString("PreferredComplexion"));
			preferences.setPreferredIncome(resultSet.getInt("PreferredIncome"));
			return preferences;
			
		}

		
		
	}
	

}
