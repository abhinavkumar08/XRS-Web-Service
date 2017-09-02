package onboard.signup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.sf.cglib.transform.impl.AddDelegateTransformer;
import database.ConnectionFactory;
import onboard.signup.DAO;
import onboard.signup.DBConstants;
import onboard.signup.beans.Address;
import onboard.signup.beans.Seller;

public class SignUpDAO  extends DAO{

	
	private static final String COMMA=" , ";
	private static final String SPACE=" ";
	
	// to do : CRUD 
	
	public void addSeller(Seller seller)throws Exception{
		Connection con =ConnectionFactory.getDbConnection();;
		try{
			StringBuilder query=new StringBuilder();
			query.append("INSERT INTO").append(SPACE);
			query.append(DBConstants.USER_DETAILS.getName()).append(SPACE);
			query.append("VALUES ( ?, ?, ?)");
			PreparedStatement pStatement=con.prepareStatement(query.toString());	
			pStatement.setLong(1, seller.getPhoneNumber());
			pStatement.setString(2, seller.getName());
			pStatement.setString(3, seller.getEmailId());
			addAddress(seller.getAddress());
			
		}catch(Exception ex){
			// to do : handle this exception 
			
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	private void addAddress (Address address){
		
	}
	
	
	
	
	
}
