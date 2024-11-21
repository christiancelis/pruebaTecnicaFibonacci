package com.fibonachi.demo.serie.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibonachi.demo.serie.application.ISerie;
import com.fibonachi.demo.serie.domain.Serie;

@Service
public class implementSerie implements  ISerie{

    @Autowired
    private serieRepository sRepo;

    @Override
    public String generateSerie(String hora) {
        List<Integer> lista = new ArrayList<>();
        Serie serie = new Serie();
        String [] horasArray = hora.split(":");
        lista = calculofibo(horasArray);

        serie.setHora(hora);
        
        

        String resultado = lista.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(","));
                                
        serie.setSerieFibonachi(resultado);
        sRepo.save(serie);


        return resultado; 
    }


    public List<Integer> calculofibo(String[] horasArray) {
        
        List<Integer> list = new ArrayList<>();
        int minutoInt = Integer.parseInt(horasArray[1]);

        String[] numeroMinutos = String.valueOf(minutoInt).split("");

        int minutoInt1 = Integer.parseInt(numeroMinutos[0]);
        int minutoInt2 = Integer.parseInt(numeroMinutos[1]);

        int segundoInt = Integer.parseInt(horasArray[2]);
        String[] numeroSegundos = String.valueOf(segundoInt).split("");


        int segundoInt1 = Integer.parseInt(numeroSegundos[0]);
        int segundoInt2 = Integer.parseInt(numeroSegundos[1]);

        int cantidad = validarCantidadSegundo(String.valueOf(segundoInt1),String.valueOf(segundoInt2));

        if(minutoInt1>minutoInt2){
            list.add(0,minutoInt2);
            list.add(0,minutoInt1);
        }else{
            list.add(0,minutoInt1);
            list.add(0,minutoInt2);
        }

        for (int i = 0; i < cantidad; i++) {
            int numero = list.get(0) + list.get(1);
            list.add(0,numero);
        }
        return list;
    }


    public int validarCantidadSegundo(String num1, String num2){
        if(num1.equals("0")){
            return Integer.parseInt(num2);
        }else{
            String num = num1+num2;
            return Integer.parseInt(num);
        }
        
    }


    @Override
    public List<Serie> mostrarSeries() {
        return sRepo.findAll();
    }
}
