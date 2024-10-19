package com.RViP.gateway.service;

import com.RViP.gateway.entity.Reader;
import com.RViP.gateway.jwt.JwtTokenProvider;
import com.RViP.gateway.repository.ReaderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String generateJwt(String username){
        Reader reader = readerRepository.findByName(username).orElseThrow(RuntimeException::new);
        reader.setJwt(jwtTokenProvider.generateToken(reader.getName(), reader.getId()));
        readerRepository.save(reader);
        return reader.getJwt();
    }

    public boolean verifyJwt(UUID id){
        readerRepository.findById(id).orElseThrow(RuntimeException::new);
        return true;
    }
}
