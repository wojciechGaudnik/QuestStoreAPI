package com.springzbuta.springboot.repositories;

import com.springzbuta.springboot.models.Palindrome;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public
interface PalindromeRepository extends CrudRepository<Palindrome, Long> {
}
