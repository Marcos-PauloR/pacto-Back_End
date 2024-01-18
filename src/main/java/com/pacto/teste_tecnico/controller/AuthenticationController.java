package com.pacto.teste_tecnico.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pacto.teste_tecnico.domain.candidate.Candidate;
import com.pacto.teste_tecnico.domain.company.Company;
import com.pacto.teste_tecnico.domain.user.AuthenticationDTO;
import com.pacto.teste_tecnico.domain.user.RegisterDTO;
import com.pacto.teste_tecnico.domain.user.TokenDTO;
import com.pacto.teste_tecnico.domain.user.Users;
import com.pacto.teste_tecnico.exception.UserHasAccountExceptions;
import com.pacto.teste_tecnico.infra.security.TokenService;
import com.pacto.teste_tecnico.repository.CandidateRepository;
import com.pacto.teste_tecnico.repository.CompanyRepository;
import com.pacto.teste_tecnico.repository.UserRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        Users user = userRepository.findUserByEmail(data.email());
        if (user == null)
            throw new UserHasAccountExceptions("Email não possui cadastro!");
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(userNamePassword);
        return ResponseEntity.ok().body(
                new TokenDTO(tokenService.generateToken((Users) auth.getPrincipal()), user.getNome(), user.getRole()));
    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@Valid @RequestBody RegisterDTO data ) {
        if(userRepository.findByEmail(data.getEmail())!=null) throw new UserHasAccountExceptions("Email já possui cadastro!");

        if(data.getRole().getRole().equals("USER")){
            candidateRepository.save(new Candidate(data.getEmail(), new BCryptPasswordEncoder().encode(data.getPassword()), data.getNome(), data.getRole(),null,"",null));
        }else{
            companyRepository.save(new Company(data.getEmail(), new BCryptPasswordEncoder().encode(data.getPassword()), data.getNome(), data.getRole()));
        }
        return ResponseEntity.ok().build();
    }

}