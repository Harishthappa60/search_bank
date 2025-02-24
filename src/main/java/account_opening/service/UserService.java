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
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public boolean validateName(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public boolean validatePanCard(String pan_number) {
        return pan_number != null && pan_number.matches(PAN_CARD_REGEX);
    }


    public boolean validateEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }


    public BankUser addUser(@RequestBody BankUser bankUser){
        if (!validateName(bankUser.getName())) {
            logger.warn("Invalid Name");
            throw new IllegalArgumentException("Invalid name. Name should not contain numbers");
        }
        if (!validatePanCard(bankUser.getPan_number())) {
            logger.warn("Invalid pan_number");
            throw new IllegalArgumentException("Invalid pan_number. please type in the correct order");
        }
        if (!validateEmail(bankUser.getEmail())) {
            logger.warn("Invalid Email");
            throw new IllegalArgumentException("Invalid email. Please type correct email");
        }
        logger.info("User Added");

        return repository.save(bankUser);
    }

    public List<BankUser> getAllUser(){
        logger.info("Reading all user data");
       return repository.findAll();
    }

    public String updateUser(String PAN_number ,long id){
        BankUser bankUser =repository.getById(id);
        bankUser.setPan_number(PAN_number);
        repository.save(bankUser);
        logger.info("User updated");

        return "PAN_number updated";
    }

    public String deleteUser(long id){
         repository.deleteById(id);
         logger.info("User Deleted");
         return "User Deleted:";
    }
}
