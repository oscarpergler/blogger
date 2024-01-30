package com.service.posts;

import org.springframework.data.jpa.repository.JpaRepository;

interface PostsRepository extends JpaRepository<Posts, Long> {}