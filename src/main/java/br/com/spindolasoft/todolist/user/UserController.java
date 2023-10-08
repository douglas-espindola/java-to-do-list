package br.com.spindolasoft.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/create/user")
    public ResponseEntity create(@RequestBody UserModel userModel) {

        if(this.userRepository.findByUsername(userModel.getUsername()) != null){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(this.userRepository.save(userModel));
    }
}
