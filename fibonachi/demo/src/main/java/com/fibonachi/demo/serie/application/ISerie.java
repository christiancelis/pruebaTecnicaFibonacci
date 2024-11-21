package com.fibonachi.demo.serie.application;

import java.util.List;

import com.fibonachi.demo.serie.domain.Serie;

public interface ISerie {
    String generateSerie(String time);
    List<Serie> mostrarSeries();
}
