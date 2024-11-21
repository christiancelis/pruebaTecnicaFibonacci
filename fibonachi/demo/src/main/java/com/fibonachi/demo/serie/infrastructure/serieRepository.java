package com.fibonachi.demo.serie.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fibonachi.demo.serie.domain.Serie;

@Repository
public interface serieRepository extends JpaRepository<Serie, Long>{

}
