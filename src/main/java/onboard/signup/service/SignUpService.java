package onboard.signup.service;

import onboard.signup.Service;
import onboard.signup.beans.Seller;
import onboard.signup.dao.SignUpDAO;

public class SignUpService implements Service<Seller>{

	SignUpDAO signUpDAO;
	
	public Boolean process(Seller seller) {
		try {
			//validate otp before adding seller
			signUpDAO.addSeller(seller);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}




}
