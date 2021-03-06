package Transactions;

//We need to import the java.sql package to use JDBC
import java.sql.*;
import java.util.*;
//for reading from the command line
//import java.io.*;
import java.sql.Connection;

import Objects.*;



public class Transactions {
	
	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	boolean connected = false;
	
	public Transactions(){
		if (connected == false){
			connect();
		}
	}
	
	public boolean connect()
 {
   String connectURL =  "jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug"; 

   try 
   {
	// Load the Oracle JDBC driver
	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
   }
   catch (SQLException ex)
   {
	System.out.println("Message: " + ex.getMessage());
	System.exit(-1);
   }
   
   try 
   {
	connection = DriverManager.getConnection(connectURL,"ora_e6i7","a22749097");

	System.out.println("\nConnected to Oracle!");
	connected = true;
	return true;
   }
   catch (SQLException ex)
   {
	System.out.println("Message: " + ex.getMessage());
	return false;
   }
 }
	
	public boolean insertHasSubject(String callNumber, String subject){
		
		
		try
		{
		  ps = connection.prepareStatement("INSERT INTO hasSubject VALUES (?,?)");
		  ps.setString(1, callNumber);
		  ps.setString(2, subject);

		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into hasSubject");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }
	
	public boolean insertHasAuthor(String callNumber, String author){
		
		
		try
		{
		  ps = connection.prepareStatement("INSERT INTO hasAuthor VALUES (?,?)");
		  ps.setString(1, callNumber);
		  ps.setString(2, author);

		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into hasAuthor");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }
	
	public void insertBorrowerType(String type, String time){
		
		
		try
		{
		  ps = connection.prepareStatement("INSERT INTO borrowerType VALUES (?,?)");
		  ps.setString(1, type);
		  ps.setString(2, time);

		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into borrowerType");
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
		    }
		}
	    }
		
	public boolean insertBorrower(String password, String name, String address, String phone, String email, String sin, String exp, String type){
		//TODO make date an int?
		
		try
		{
			String query = String.format("INSERT INTO borrower VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')","bid_counter.nextval",password, name, address, phone, email, sin, exp, type);
		  ps = connection.prepareStatement(query);
		  ps.executeUpdate();
		  // commit work 
		  connection.commit();
		  ps.close();
		  System.out.println("Inserted into borrower");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }
	
	public boolean insertBook(String callnum, int isbn, String title, String mainAuthor, String publisher, int year ){
		
		
		try
		{
		  ps = connection.prepareStatement("INSERT INTO book VALUES (?,?,?,?,?,?)");
		  ps.setString(1, callnum);
		  ps.setInt(2, isbn);
		  ps.setString(3, title);
		  ps.setString(4, mainAuthor);
		  ps.setString(5, publisher);
		  ps.setInt(6, year);

		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into book");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }
	
	public boolean insertBookCopy(String callnum, int copynum, String status){
		
		
		try
		{
		  ps = connection.prepareStatement("INSERT INTO bookCopy VALUES (?,?,?)");
		  ps.setString(1, callnum);
		  ps.setInt(2, copynum);
		  ps.setString(3, status);


		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 

		  connection.commit();

		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into bookCopy");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			 return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			 return false;
		    }
		}
	    }
	
	public ArrayList<Borrower> getAllBorrowers()
 {
		
		//TODO
		//loop through columns and add variables to a Srting[]
		//take out the prints
		//add functionality to select a certain attribute
		//return one long String[] for now
		//divide up the string by the number of parameters and make a matrix?
	ArrayList<Borrower> returnQuery = new ArrayList<Borrower>();
	Statement  stmt;
	ResultSet  rs;
	
	   
	try
	{
	  stmt = connection.createStatement();
	  rs = stmt.executeQuery("SELECT * FROM borrower");
	  // get info on ResultSet
	  ResultSetMetaData rsmd = rs.getMetaData();
	  // get number of columns
	  int numCols = rsmd.getColumnCount();
	  //System.out.println(" ");
	  // display column names;
	  for (int i = 0; i < numCols; i++)
	  {
	      // get column name and print it
	     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
	  }
	  //System.out.println(" ");
	  while(rs.next())
	  {
		    Borrower b = new Borrower ();
	      	b.setBid(rs.getInt("BID"));
	  		b.setPassword(rs.getString("PASSWORD"));
	  		b.setName(rs.getString("NAME"));
	  		b.setAddress(rs.getString("ADDRESS"));
	  		b.setPhone(rs.getString("PHONE"));
	  		b.setEmailAddress(rs.getString("EMAILADDRESS"));
	  		b.setSinOrStNo(rs.getString("SINORSTNO"));
	  		b.setExpiryDate(rs.getString("EXPIRYDATE"));
	  		b.setType(rs.getString("TYPE"));
	  		
	  		
	  		returnQuery.add(b);
	  }

	  // close the statement; 
	  // the ResultSet will also be closed
	  stmt.close();
	  return returnQuery;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    return null;
	}	
 }
 
	//set default input to null	
	//returns callnumber, title, status, outdate, indate
	public ArrayList<CheckedOutBook> getCheckedOutBooks(String subject)
 {

	ArrayList<CheckedOutBook> returnQuery = new ArrayList<CheckedOutBook>();
	Statement  stmt;
	ResultSet  rs;
	
	   
	try
	{
		
	  stmt = connection.createStatement();
	  
	  if (subject != null){
		  String query = String.format("SELECT * FROM bookCopy, borrowing, book, hasSubject WHERE status = 'out' and hasSubject.callnumber = book.callnumber and bookcopy.callnumber = borrowing.callnumber and bookcopy.copyno = borrowing.copyno and bookcopy.callnumber = book.callnumber and subject = '%s'",subject);
		  rs = stmt.executeQuery(query);
	  }
	  else{
		  rs = stmt.executeQuery("SELECT * FROM bookCopy, borrowing, book WHERE status = 'out' and bookcopy.callnumber = borrowing.callnumber and bookcopy.copyno = borrowing.copyno and bookcopy.callnumber = book.callnumber");
	  }
	  
	  // get info on ResultSet
	  ResultSetMetaData rsmd = rs.getMetaData();
	  // get number of columns
	  int numCols = rsmd.getColumnCount();
	  //System.out.println(" ");
	  // display column names;
	  for (int i = 0; i < numCols; i++)
	  {
	      // get column name and print it
	     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
	  }
	  //System.out.println(" ");
	  while(rs.next())
	  {
	        CheckedOutBook c = new CheckedOutBook();
	      	c.callNumber = rs.getString("CALLNUMBER");
	      	c.title = rs.getString("TITLE");
	      	c.status = rs.getString("STATUS");
	  		c.outDate = rs.getString("OUTDATE");
	  		c.inDate = rs.getString("INDATE");

	  		returnQuery.add(c);
	  }

	  // close the statement; 
	  // the ResultSet will also be closed
	  stmt.close();
	  return returnQuery;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    return null;
	}	
 }
 
	//input null by default eg. showBookSearch(null,null,"adventure") to search for adventure books
	//returns: callnumber, title, author, subject status
	public ArrayList<BookCopy> showBookSearch(String titlein, String authorin, String subjectin)
	 {
		ArrayList<BookCopy> returnQuery = new ArrayList<BookCopy>();
		Statement  stmt;
		ResultSet  rs;
		
		String titleString = "";
		String authorString = "";
		String subjectString = "";
		
		if (titlein.length() > 0){
			titleString = String.format("and title = '%s'", titlein);
		}
		if(authorin.length() > 0){
			authorString = String.format("and name = '%s'", authorin);
		}
		if(subjectin.length() > 0){
			subjectString = String.format("and subject = '%s'", subjectin);			
		}
		
		
		String inputString = titleString + authorString + subjectString;
		String queryString = String.format("Select *  FROM book, hasSubject, bookCopy, hasAuthor WHERE book.callNumber = bookCopy.callNumber and book.callnumber = hasSubject.callnumber and book.callnumber = hasAuthor.callNumber %s", inputString);
		System.out.println(queryString);

		try
		{
		  stmt = connection.createStatement();
		  rs = stmt.executeQuery(queryString);
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
		        BookCopy b = new BookCopy();
		      	b.callNumber = rs.getString("CALLNUMBER");
		  		b.title = rs.getString("TITLE");
		  		b.mainAuthor = rs.getString("NAME");
		  		b.subject = rs.getString("SUBJECT");
		  		b.status = rs.getString("STATUS");
		  		b.isbn= rs.getString("ISBN");
		  		b.year = rs.getString("YEAR");
		  		b.publisher = rs.getString("PUBLISHER");
		  		returnQuery.add(b);
		  }
		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }
	 
	public ArrayList<BookCopy> getAllBookCopies()
	 {
		ArrayList<BookCopy> returnQuery = new ArrayList<BookCopy>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
		  stmt = connection.createStatement();
		  rs = stmt.executeQuery("SELECT * FROM bookcopy");
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
		        BookCopy bc = new BookCopy();
		      	bc.callNumber = rs.getString("CALLNUMBER");
		  		bc.copyNum = rs.getInt("COPYNO");
		  		bc.status = rs.getString("STATUS");

		  		
		  		returnQuery.add(bc);


		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }

	public int showBorrowersTimeLimit(int bidin)
	 {
			
			//TODO
			
			String     timeLimit="";

		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			
		  stmt = connection.createStatement();
		  

			  String query = String.format("SELECT booktimelimit FROM borrower, borrowerType WHERE borrower.type = borrowerType.type and borrower.bid = %d",bidin);
			  System.out.println(query);
			  rs = stmt.executeQuery(query);

		  
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
		      	timeLimit = rs.getString("BOOKTIMELIMIT");
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return Integer.parseInt( timeLimit );
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return 0;
		}	
	 }
	
	public ArrayList<Book> getAllBorrowedBooks()
	 {
			
			//TODO
			
		String     callnum;
		String     title;

		ArrayList<Book> returnQuery = new ArrayList<Book>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			
		  stmt = connection.createStatement();
		  

			  String query = String.format("SELECT book.callnumber, book.title FROM book, borrowing WHERE book.callnumber = borrowing.callnumber");
			  System.out.println(query);
			  rs = stmt.executeQuery(query);

		  
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
			  Book b = new Book();
		      	b.callNumber = rs.getString("CALLNUMBER");
		      	b.title = rs.getString("TITLE");
		  		returnQuery.add(b);
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }
	
	//return status, bid, inDate
	public ArrayList<String> processReturn(int callnum, int copynum)
	 {
			
			//TODO
			
		String     status;
		String     bid;
		String     indate;

		ArrayList<String> returnQuery = new ArrayList<String>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			
		  stmt = connection.createStatement();
		  

			  String query = String.format("SELECT bookCopy.status, borrowing.bid, borrowing.indate FROM bookCopy, borrowing WHERE bookCopy.callNumber = borrowing.callNumber and bookCopy.callNumber = %d and bookCopy.copyNo = %d ", callnum, copynum);
			  System.out.println(query);
			  rs = stmt.executeQuery(query);

		  
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
		      	status = rs.getString("STATUS");
		      	bid = rs.getString("BID");
		      	indate = rs.getString("INDATE");
		  		returnQuery.add(status);
		  		returnQuery.add(bid);
		  		returnQuery.add(indate);
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }
		
	public boolean updateBookCopyStatus(String callnum, int copynum, String status){
		
		
		try
		{
			String query = String.format("UPDATE bookCopy SET status = '%s' WHERE callnumber = '%s' and copyno = %d",status, callnum, copynum);
			System.out.println(query);
			ps = connection.prepareStatement(query);
		  ps.executeUpdate();
		  connection.commit();
		  ps.close();
		  System.out.println("Updated bookCopy");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
		    }
		    return false;
		}
	    }
	
	public boolean payFine(int fid, int amount, String paidDate){
		
		
		try
		{
			String query = String.format("UPDATE Fine SET paidDate = '%s' WHERE fid = %d and amount = %d",paidDate, fid, amount);
			System.out.println(query);
			ps = connection.prepareStatement(query);
		  ps.executeUpdate();
		  connection.commit();
		  ps.close();
		  System.out.println("Paid Fine");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
		    }
		    return false;
		}
	    }

	public ArrayList<BookCopy> showCopiesOfGivenBook(String callnum)
	 {
		ArrayList<BookCopy> returnQuery = new ArrayList<BookCopy>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			String query = String.format("SELECT * FROM bookCopy WHERE callNumber = '%s'", callnum);
		  stmt = connection.createStatement();
		  rs = stmt.executeQuery(query);
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
		        BookCopy bc = new BookCopy();
		      	bc.callNumber = rs.getString("CALLNUMBER");
		  		bc.copyNum = rs.getInt("COPYNO");
		  		bc.status = rs.getString("STATUS");

		  		
		  		returnQuery.add(bc);


		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }
	
public boolean updateBorrowingInDate(int borid, String inDate){
		
		
		try
		{
			String query = String.format("UPDATE borrowing SET inDate = '%s' WHERE borid = %d",inDate, borid);
			System.out.println(query);
			ps = connection.prepareStatement(query);
		  ps.executeUpdate();
		  connection.commit();
		  ps.close();
		  System.out.println("BorrowingUpdated");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
		    }
		    return false;
		}
	    }

public boolean updateHoldRequestIssuedDate(int hid, String issuedDate){
	
	
	try
	{
		String query = String.format("UPDATE holdRequest SET issuedDate = '%s' WHERE hid = %d",issuedDate, hid);
		System.out.println(query);
		ps = connection.prepareStatement(query);
	  ps.executeUpdate();
	  connection.commit();
	  ps.close();
	  System.out.println("hold updated");
	  return true;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    try 
	    {
		// undo the insert
		connection.rollback();	
	    }
	    catch (SQLException ex2)
	    {
		System.out.println("Message: " + ex2.getMessage());
		System.exit(-1);
	    }
	    return false;
	}
    }
	public boolean insertBorrowing(String callnum,int copynum,int bid, String outDate, String inDate){
		
		
		try
		{
			String query = String.format("INSERT INTO borrowing VALUES (%s, '%s', %d, %d, '%s', '%s')","borid_counter.nextval",callnum, copynum,bid, outDate, inDate);
			  ps = connection.prepareStatement(query);

		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into borrowing");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }

	public boolean insertFine(int amount, String issueDate, String paidDate, int borid){
		
		try
		{
			
			String query = String.format("INSERT INTO fine VALUES (%s, %d, '%s', '%s', %d)","fid_counter.nextval",amount, issueDate, paidDate, borid);
			  ps = connection.prepareStatement(query);


		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into fine");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }

public boolean insertHoldRequest(String callNum, int bid, String issueDate){
		
		try
		{
			String query = String.format("INSERT INTO holdRequest VALUES (%s, '%s', %d, '%s')","hid_counter.nextval",callNum, bid, issueDate);
			  ps = connection.prepareStatement(query);
		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Inserted into holdRequest");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }
	public Borrower showBorrowerById(int bid)
{
		
		//TODO
		
	ArrayList<Borrower> returnQuery = new ArrayList<Borrower>();
	Statement  stmt;
	ResultSet  rs;
	
	   
	try
	{
		String query = String.format("SELECT * FROM borrower WHERE bid = %d", bid);
	  stmt = connection.createStatement();
	  rs = stmt.executeQuery(query);
	  // get info on ResultSet
	  ResultSetMetaData rsmd = rs.getMetaData();
	  // get number of columns
	  int numCols = rsmd.getColumnCount();
	  //System.out.println(" ");
	  // display column names;
	  for (int i = 0; i < numCols; i++)
	  {
	      // get column name and print it
	     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
	  }
	  //System.out.println(" ");
	  Borrower b = new Borrower ();
	  while(rs.next())
	  {
		    
	      	b.setBid(rs.getInt("BID"));
	  		b.setPassword(rs.getString("PASSWORD"));
	  		b.setName(rs.getString("NAME"));
	  		b.setAddress(rs.getString("ADDRESS"));
	  		b.setPhone(rs.getString("PHONE"));
	  		b.setEmailAddress(rs.getString("EMAILADDRESS"));
	  		b.setSinOrStNo(rs.getString("SINORSTNO"));
	  		b.setExpiryDate(rs.getString("EXPIRYDATE"));
	  		b.setType(rs.getString("TYPE"));
	  		
	  		
	  		returnQuery.add(b);
	  }

	  // close the statement; 
	  // the ResultSet will also be closed
	  stmt.close();
	  return b;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    return null;
	}	
}

	public ArrayList<Borrowing> showBorrowingById(int bid)
{
		
	ArrayList<Borrowing> returnQuery = new ArrayList<Borrowing>();
	Statement  stmt;
	ResultSet  rs;
	
	   
	try
	{
		String query = String.format("SELECT * FROM borrowing WHERE bid = %d", bid);
	  stmt = connection.createStatement();
	  rs = stmt.executeQuery(query);
	  // get info on ResultSet
	  ResultSetMetaData rsmd = rs.getMetaData();
	  // get number of columns
	  int numCols = rsmd.getColumnCount();
	  //System.out.println(" ");
	  // display column names;
	  for (int i = 0; i < numCols; i++)
	  {
	      // get column name and print it
	     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
	  }
	  //System.out.println(" ");
	  while(rs.next())
	  {
		    Borrowing b = new Borrowing ();
	      	b.setBorid(rs.getInt("BORID"));
	  		b.setCallNumber(rs.getString("CALLNUMBER"));
	  		b.setCopyNo(rs.getInt("COPYNO"));
	  		b.setBid(rs.getInt("BID"));
	  		b.setOutDate(rs.getString("OUTDATE"));
	  		b.setInDate(rs.getString("INDATE"));

	  		
	  		
	  		returnQuery.add(b);
	  }

	  // close the statement; 
	  // the ResultSet will also be closed
	  stmt.close();
	  return returnQuery;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    return null;
	}	
}
	
	public ArrayList<HoldRequest> getNonIssuedHoldRequestsByCallNumber(String callNumber)
	{
			
		ArrayList<HoldRequest> returnQuery = new ArrayList<HoldRequest>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			String query = String.format("SELECT * FROM holdRequest WHERE callNumber = '%s' and issuedDate = 'null'", callNumber);
		  stmt = connection.createStatement();
		  rs = stmt.executeQuery(query);
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  while(rs.next())
		  {
				HoldRequest hr  = new HoldRequest();
		      	hr.hid = rs.getInt("HID");
		      	hr.callNumber = rs.getString("CALLNUMBER");
		      	hr.bid = rs.getInt("BID");
		      	hr.issuedDate = rs.getString("ISSUEDDATE");
		  		returnQuery.add(hr);

		  		
		  		
		  		returnQuery.add(hr);
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	}

	public ArrayList<HoldRequest> showHoldRequestById(int bidin)
	 {
	
			
		String     hid;
		String     callnum;
		String     bid;
		String     issueDate;

		ArrayList<HoldRequest> returnQuery = new ArrayList<HoldRequest>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			
		  stmt = connection.createStatement();
		  

			  String query = String.format("SELECT * FROM holdRequest WHERE bid = %d", bidin);
			  System.out.println(query);
			  rs = stmt.executeQuery(query);

		  
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  
		  while(rs.next())
		  {
			  	HoldRequest hr  = new HoldRequest();
		      	hr.hid = rs.getInt("HID");
		      	hr.callNumber = rs.getString("CALLNUMBER");
		      	hr.bid = rs.getInt("BID");
		      	hr.issuedDate = rs.getString("ISSUEDDATE");
		  		returnQuery.add(hr);
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return returnQuery;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }

	public Fine showFineById(int boridin)
	 {
			
		String     fid;
		String     amount;
		String     paidDate;
		String     issueDate;
		String     borid;

		ArrayList<Fine> returnQuery = new ArrayList<Fine>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			
		  stmt = connection.createStatement();
		  

			  String query = String.format("SELECT * FROM fine WHERE borid = %d", boridin);
			  System.out.println(query);
			  rs = stmt.executeQuery(query);

		  
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  Fine f = new Fine();
		  while(rs.next())
		  {
			  	
			  	f.fid = rs.getInt("FID");
			  	f.amount = rs.getInt("AMOUNT");
			  	f.paidDate = rs.getString("PAIDDATE");
			  	f.issuedDate = rs.getString("ISSUEDDATE");
			  	f.borid = rs.getInt("BORID");
		  		returnQuery.add(f);
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return f;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }

	public BookCopy showCopyOfGivenBook(String callnum, int copynum)
	 {
		ArrayList<BookCopy> returnQuery = new ArrayList<BookCopy>();
		Statement  stmt;
		ResultSet  rs;
		
		   
		try
		{
			String query = String.format("SELECT * FROM bookCopy WHERE callNumber = '%s' and copyNo = %d", callnum, copynum);
		  stmt = connection.createStatement();
		  rs = stmt.executeQuery(query);
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  BookCopy bc = new BookCopy();
		  while(rs.next())
		  {
		        
		      	bc.callNumber = rs.getString("CALLNUMBER");
		  		bc.copyNum = rs.getInt("COPYNO");
		  		bc.status = rs.getString("STATUS");

		  		


		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return bc;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return null;
		}	
	 }
	
	public ArrayList<Borrowing> showCheckedOutBorrowing()
{
		
		//TODO: make a borrowing class
	ArrayList<Borrowing> returnQuery = new ArrayList<Borrowing>();
	Statement  stmt;
	ResultSet  rs;
	
	   
	try
	{
		String query = ("SELECT * FROM borrowing WHERE inDate = 'null' ORDER BY callNumber");
	  stmt = connection.createStatement();
	  rs = stmt.executeQuery(query);
	  // get info on ResultSet
	  ResultSetMetaData rsmd = rs.getMetaData();
	  // get number of columns
	  int numCols = rsmd.getColumnCount();
	  //System.out.println(" ");
	  // display column names;
	  for (int i = 0; i < numCols; i++)
	  {
	      // get column name and print it
	     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
	  }
	  //System.out.println(" ");
	  while(rs.next())
	  {
		    Borrowing b = new Borrowing ();
	      	b.setBorid(rs.getInt("BORID"));
	  		b.setCallNumber(rs.getString("CALLNUMBER"));
	  		b.setCopyNo(rs.getInt("COPYNO"));
	  		b.setBid(rs.getInt("BID"));
	  		b.setOutDate(rs.getString("OUTDATE"));
	  		b.setInDate(rs.getString("INDATE"));

	  		
	  		
	  		returnQuery.add(b);
	  }

	  // close the statement; 
	  // the ResultSet will also be closed
	  stmt.close();
	  return returnQuery;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    return null;
	}	
}


	public ArrayList<Borrowing> showAllBorrowing()
{
		
		//TODO: make a borrowing class
	ArrayList<Borrowing> returnQuery = new ArrayList<Borrowing>();
	Statement  stmt;
	ResultSet  rs;
	
	   
	try
	{
		String query = ("SELECT * FROM borrowing");
	  stmt = connection.createStatement();
	  rs = stmt.executeQuery(query);
	  // get info on ResultSet
	  ResultSetMetaData rsmd = rs.getMetaData();
	  // get number of columns
	  int numCols = rsmd.getColumnCount();
	  //System.out.println(" ");
	  // display column names;
	  for (int i = 0; i < numCols; i++)
	  {
	      // get column name and print it
	     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
	  }
	  //System.out.println(" ");
	  while(rs.next())
	  {
		    Borrowing b = new Borrowing ();
	      	b.setBorid(rs.getInt("BORID"));
	  		b.setCallNumber(rs.getString("CALLNUMBER"));
	  		b.setCopyNo(rs.getInt("COPYNO"));
	  		b.setBid(rs.getInt("BID"));
	  		b.setOutDate(rs.getString("OUTDATE"));
	  		b.setInDate(rs.getString("INDATE"));

	  		
	  		
	  		returnQuery.add(b);
	  }

	  // close the statement; 
	  // the ResultSet will also be closed
	  stmt.close();
	  return returnQuery;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    return null;
	}	
}

	

	
	public int showMostRecentBorrower()
	{
			
		ArrayList<Borrower> returnQuery = new ArrayList<Borrower>();
		Statement  stmt;
		ResultSet  rs;
		int bid =0;
		
		   
		try
		{
			String query = String.format("SELECT MAX(bid) FROM borrower");
		  stmt = connection.createStatement();
		  rs = stmt.executeQuery(query);
		  // get info on ResultSet
		  ResultSetMetaData rsmd = rs.getMetaData();
		  // get number of columns
		  int numCols = rsmd.getColumnCount();
		  //System.out.println(" ");
		  // display column names;
		  for (int i = 0; i < numCols; i++)
		  {
		      // get column name and print it
		     // System.out.printf("%-15s", rsmd.getColumnName(i+1));    
		  }
		  //System.out.println(" ");
		  Borrower b = new Borrower ();
		  while(rs.next())
		  {
			    
		      	bid = rs.getInt("MAX(BID)");
		  	/*	b.setPassword(rs.getString("PASSWORD"));
		  		b.setName(rs.getString("NAME"));
		  		b.setAddress(rs.getString("ADDRESS"));
		  		b.setPhone(rs.getString("PHONE"));
		  		b.setEmailAddress(rs.getString("EMAILADDRESS"));
		  		b.setSinOrStNo(rs.getString("SINORSTNO"));
		  		b.setExpiryDate(rs.getString("EXPIRYDATE"));
		  		b.setType(rs.getString("TYPE"));
		  		
		  		*/
		  		returnQuery.add(b);
		  }

		  // close the statement; 
		  // the ResultSet will also be closed
		  stmt.close();
		  return bid;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    return 0;
		}	
	}
	
public boolean deleteHoldREquest(int hid){
		
		try
		{
			String query = String.format("DELETE holdRequest WHERE hid = %d", hid);
			  ps = connection.prepareStatement(query);
		  //System.out.println("all added");
		  ps.executeUpdate();
		  //System.out.println("executed");
		  // commit work 
		  connection.commit();
		  //System.out.println("committed");
		  ps.close();
		  System.out.println("Deleted  holdRequest");
		  return true;
		}
		catch (SQLException ex)
		{
		    System.out.println("Message: " + ex.getMessage());
		    try 
		    {
			// undo the insert
			connection.rollback();	
			return false;
		    }
		    catch (SQLException ex2)
		    {
			System.out.println("Message: " + ex2.getMessage());
			System.exit(-1);
			return false;
		    }
		}
	    }
public boolean testInsertHasSubject(String callNumber, String subject){
    
    
    try
    {
      ps = connection.prepareStatement("INSERT INTO hasSubject VALUES (?,?)");
      ps.setString(1, callNumber);
      ps.setString(2, subject);

      //System.out.println("all added");
      ps.executeUpdate();
      //System.out.println("executed");
      // commit work
      connection.commit();
      //System.out.println("committed");
      ps.close();
      System.out.println("Inserted into hasSubject");
      return true;
    }
    catch (SQLException ex)
    {
        System.out.println("Message: " + ex.getMessage());
        try
        {
        // undo the insert
        connection.rollback();    
        return false;
        }
        catch (SQLException ex2)
        {
        System.out.println("Message: " + ex2.getMessage());
        System.exit(-1);
        return false;
        }
    }
    }

public boolean testInsertHasAuthor(String callNumber, String author){
    
    
    try
    {
      ps = connection.prepareStatement("INSERT INTO hasAuthor VALUES (?,?)");
      ps.setString(1, callNumber);
      ps.setString(2, author);

      //System.out.println("all added");
      ps.executeUpdate();
      //System.out.println("executed");
      // commit work
      connection.commit();
      //System.out.println("committed");
      ps.close();
      System.out.println("Inserted into hasAuthor");
      return true;
    }
    catch (SQLException ex)
    {
        System.out.println("Message: " + ex.getMessage());
        try
        {
        // undo the insert
        connection.rollback();    
        return false;
        }
        catch (SQLException ex2)
        {
        System.out.println("Message: " + ex2.getMessage());
        System.exit(-1);
        return false;
        }
    }
    }

public void testInsertBorrowerType(String type, String time){
    
    
    try
    {
      ps = connection.prepareStatement("INSERT INTO borrowerType VALUES (?,?)");
      ps.setString(1, type);
      ps.setString(2, time);

      //System.out.println("all added");
      ps.executeUpdate();
      //System.out.println("executed");
      // commit work
      connection.commit();
      //System.out.println("committed");
      ps.close();
      System.out.println("Inserted into borrowerType");
    }
    catch (SQLException ex)
    {
        System.out.println("Message: " + ex.getMessage());
        try
        {
        // undo the insert
        connection.rollback();    
        }
        catch (SQLException ex2)
        {
        System.out.println("Message: " + ex2.getMessage());
        System.exit(-1);
        }
    }
    }

public boolean insertBorrowingForTestData(int borid, int bid, String callnum,int copynum, String outDate, String inDate){
	   
	   
	   try
	   {
	       String query = String.format("INSERT INTO borrowing VALUES (%d, '%s', %d, %d, '%s', '%s')", borid, callnum, copynum, bid, outDate, inDate);
	         ps = connection.prepareStatement(query);

	     //System.out.println("all added");
	     ps.executeUpdate();
	     //System.out.println("executed");
	     // commit work
	     connection.commit();
	     //System.out.println("committed");
	     ps.close();
	     System.out.println("Inserted into borrowing");
	     return true;
	   }
	   catch (SQLException ex)
	   {
	       System.out.println("Message: " + ex.getMessage());
	       try
	       {
	       // undo the insert
	       connection.rollback();    
	       return false;
	       }
	       catch (SQLException ex2)
	       {
	       System.out.println("Message: " + ex2.getMessage());
	       System.exit(-1);
	       return false;
	       }
	   }
	    }
	
public boolean insertBorrowerForTestData(int bid, String password, String name, String address, String phone, String email, String sin, String exp, String type){
    //TODO make date an int?
    
    try
    {
        String query = String.format("INSERT INTO borrower VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",bid ,password, name, address, phone, email, sin, exp, type);
      ps = connection.prepareStatement(query);
      ps.executeUpdate();
      // commit work
      connection.commit();
      ps.close();
      System.out.println("Inserted into borrower");
      return true;
    }
    catch (SQLException ex)
    {
        System.out.println("Message: " + ex.getMessage());
        try
        {
        // undo the insert
        connection.rollback();    
        return false;
        }
        catch (SQLException ex2)
        {
        System.out.println("Message: " + ex2.getMessage());
        System.exit(-1);
        return false;
        }
    }
    }

public boolean insertHoldReqForTestData(int hid, String callNum, int bid, String issueDate){
	
	try
	{
		String query = String.format("INSERT INTO holdRequest VALUES (%d, '%s', %d, '%s')",hid,callNum, bid, issueDate);
		  ps = connection.prepareStatement(query);
	  //System.out.println("all added");
	  ps.executeUpdate();
	  //System.out.println("executed");
	  // commit work 
	  connection.commit();
	  //System.out.println("committed");
	  ps.close();
	  System.out.println("Inserted into holdRequest");
	  return true;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    try 
	    {
		// undo the insert
		connection.rollback();	
		return false;
	    }
	    catch (SQLException ex2)
	    {
		System.out.println("Message: " + ex2.getMessage());
		System.exit(-1);
		return false;
	    }
	}
    }

public boolean insertFineForTestData(int fid, int amount, String issueDate, String paidDate, int borid){
	
	try
	{
		
		String query = String.format("INSERT INTO fine VALUES (%d, %d, '%s', '%s', %d)",fid,amount, issueDate, paidDate, borid);
		ps = connection.prepareStatement(query);


	  //System.out.println("all added");
	  ps.executeUpdate();
	  //System.out.println("executed");
	  // commit work 
	  connection.commit();
	  //System.out.println("committed");
	  ps.close();
	  System.out.println("Inserted into fine");
	  return true;
	}
	catch (SQLException ex)
	{
	    System.out.println("Message: " + ex.getMessage());
	    try 
	    {
		// undo the insert
		connection.rollback();	
		return false;
	    }
	    catch (SQLException ex2)
	    {
		System.out.println("Message: " + ex2.getMessage());
		System.exit(-1);
		return false;
	    }
	}
    }

}


	

