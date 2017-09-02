package onboard.signup.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import onboard.signup.InvalidInputException;
import onboard.signup.beans.Seller;
import onboard.signup.service.SignUpService;
import onboard.signup.validator.SignUpValidator;


@Path("/signup")
public class SignUpController {

	
	SignUpValidator signUpValidator=new SignUpValidator();
	SignUpService signUpService=new SignUpService();
	
	@POST
	public boolean signUp(Seller seller) throws InvalidInputException{
		if(!signUpValidator.isValid(seller))
			throw new InvalidInputException("Enter details are incorrect.");
		return signUpService.process(seller);
	}
	
	

}
