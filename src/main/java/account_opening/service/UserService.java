package account_opening.service;

import account_opening.DemoApplication;
import account_opening.model.BankUser;
import account_opening.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository repository;
    private static final Logger logger= LoggerFactory.getLogger(DemoApplication.class);

    private static final String PAN_CARD_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
    private static final String NAME_REGEX = "^[A-Za-z ]+$";
    private static final String DOB_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String MOBILE_NUMBER_REGEX= "^[0-9]{10}$";

    public boolean validateName(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public boolean validateDOB(String DOB){

        return DOB !=null && DOB.matches(DOB_REGEX);
    }

    public boolean validatePanCard(String pan_number) {
        return pan_number != null && pan_number.matches(PAN_CARD_REGEX);
    }


    public boolean validateEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    public boolean validateMobileNumber(String mobile_number){
        return mobile_number !=null && mobile_number.matches(MOBILE_NUMBER_REGEX);
    }


    public BankUser addUser(@RequestBody BankUser bankUser){
        if (!validateName(bankUser.getName())) {
            logger.warn("Invalid Name");
            throw new IllegalArgumentException("Invalid name. Name should not contain numbers");
        }
        if(!validateDOB(bankUser.getDob())){
            logger.warn("Invalid DOB");
            throw new IllegalArgumentException("Invalid DOB, Please enter in sequence DD/MM/YY ");
        }
        if (!validatePanCard(bankUser.getPan_number())) {
            logger.warn("Invalid pan_number");
            throw new IllegalArgumentException("Invalid pan_number. please type in the correct order");
        }
        if (!validateEmail(bankUser.getEmail())) {
            logger.warn("Invalid Email");
            throw new IllegalArgumentException("Invalid email. Please type correct email");
        }
        if(!validateMobileNumber(bankUser.getMobile_number())){
            logger.warn("Invalid Mobile_Number");
            throw new IllegalArgumentException("Invalid Mobile_number,Please enter valid mobile_number");
        }
        logger.info("User Added");

        return repository.save(bankUser);
    }

    public List<BankUser> getAllUser(){
        logger.info("Reading all user data");
       return repository.findAll();
    }

    public String updateUser(String dob,long id){
        BankUser bankUser=repository.getById(id);
        if(bankUser.getDob()==null || bankUser.getDob()!=null){
            bankUser.setDob(dob);
        }
        logger.info("User updated:");
        repository.save(bankUser);
        return "user updated";
    }

    public String deleteUser(long id){
         repository.deleteById(id);
         logger.info("User Deleted");
         return "User Deleted:";
    }


}
