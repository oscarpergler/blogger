package com.service.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface UsersRepository extends JpaRepository<Users, Long> {}