package com.service.user;

import org.springframework.data.jpa.repository.JpaRepository;

@CrossOrigin
interface UsersRepository extends JpaRepository<Users, Long> {}