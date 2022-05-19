package teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;

public class Grades
{
	private String periodID;
	private String studentID;
	private String subjectID;
	private double projects;
	private double finalTest;
	private double finalPeriodMark;
	private double finalGrade;

	public Grades(String periodID, String studentID, String subjectID, double projects,
				  double finalTest, double finalPeriodMark, double finalGrade)
	{
		this.periodID = periodID;
		this.studentID = studentID;
		this.subjectID = subjectID;
		this.projects = projects;
		this.finalTest = finalTest;
		this.finalPeriodMark = finalPeriodMark;
		this.finalGrade = finalGrade;
	}

	public String getPeriodID()
	{
		return periodID;
	}

	public void setPeriodID(String periodID)
	{
		this.periodID = periodID;
	}

	public String getStudentID()
	{
		return studentID;
	}

	public void setStudentID(String studentID)
	{
		this.studentID = studentID;
	}

	public String getSubjectID()
	{
		return subjectID;
	}

	public void setSubjectID(String subjectID)
	{
		this.subjectID = subjectID;
	}


	public double getProjects()
	{
		return projects;
	}

	public void setProjects(double projects)
	{
		this.projects = projects;
	}

	public double getFinalTest()
	{
		return finalTest;
	}

	public void setFinalTest(double finalTest)
	{
		this.finalTest = finalTest;
	}

	public double getFinalPeriodMark()
	{
		return finalPeriodMark;
	}

	public void setFinalPeriodMark(double finalPeriodMark)
	{
		this.finalPeriodMark = finalPeriodMark;
	}

public double getFinalGrade()
	{
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade)
	{
		this.finalGrade = finalGrade;
	}

	public static boolean addGrade(String periodID, String studentID, String subjectID,
								   double projects, double finalTest, double finalPeriodMark, double finalGrade)
	{
		String query = "INSERT INTO Grades(periodID, studentID, subjectID, "
				+ " projects, finalTest, finalPeriodMark, finalGrade) "
				+ "VALUES(?,?,?,?,?,?,?)";

		try
		{
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);

			preparedStatement.setString(1, periodID);
			preparedStatement.setString(2, studentID);
			preparedStatement.setString(3, subjectID);
			preparedStatement.setDouble(4, projects);
			preparedStatement.setDouble(5, finalTest);
			preparedStatement.setDouble(6, finalPeriodMark);
			preparedStatement.setDouble(7, finalGrade);

			return (preparedStatement.executeUpdate() > 0);
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

