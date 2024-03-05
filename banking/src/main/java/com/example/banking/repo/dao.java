package com.example.banking.repo;
import com.example.banking.modal.data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dao extends JpaRepository<data,Long> {
    data findByAcNo(String accountNo);
}
