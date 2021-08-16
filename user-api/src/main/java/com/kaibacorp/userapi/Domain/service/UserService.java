package com.kaibacorp.userapi.Domain.service;

import com.kaibacorp.userapi.Api.proxy.VaccineProxy;
import com.kaibacorp.userapi.Domain.exception.DontFoundEntityException;
import com.kaibacorp.userapi.Domain.exception.ServiceException;
import com.kaibacorp.userapi.Domain.model.User;
import com.kaibacorp.userapi.Domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VaccineProxy vaccineProxy;

    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public User searchUser(Long id){
        return userRepository.findById(id).
                orElseThrow(()-> new DontFoundEntityException("This user don't found in our database"));
    }

    public User addUser(User user){
        this.existsUser(user);
        return userRepository.save(user);
    }

    public User updateUser(Long id,User user){
        this.foundUser(id);
        var userNow = userRepository.findById(id).get();
        this.checkUpdateFields(userNow,user);
        return userRepository.save(user);
    }
    public void removeUser(Long id){
        this.foundUser(id);
        var user = userRepository.findById(id).get();
        vaccineProxy.deleteUserVac(id);
        userRepository.delete(user);
    }

    private void foundUser(Long id){
        if(!userRepository.existsById(id)) {
            throw new DontFoundEntityException("This user don't found in our database");
        }
    }

    private void existsUser(User user){
        User cpfUser = userRepository.findByCpf(user.getCpf());
        User emailUser = userRepository.findByEmail(user.getEmail());
        if(cpfUser!=null && !cpfUser.equals(user) && emailUser!=null && !emailUser.equals(user)){
            throw new ServiceException("This CPF and Email already in database");
        }

        if(cpfUser!=null && !cpfUser.equals(user)){
            throw new ServiceException("This CPF already in database");
        }
        if(emailUser!=null && !emailUser.equals(user)){
            throw new ServiceException("This email already in database");
        }
    }
    private void checkUpdateFields(User usernow, User user){
        this.existsUser(user);
        user.setId(usernow.getId());
        if(user.getEmail()==null){
            user.setEmail(usernow.getEmail());
        }
        if(user.getBornDate()==null){
            user.setBornDate(usernow.getBornDate());
        }
        if(user.getCpf()==null){
            user.setCpf(usernow.getCpf());
        }
        if(user.getName()==null){
            user.setName(usernow.getName());
        }
    }
}
