package com.reactive;


import dto.Consola;
import rx.Observable;
import rx.functions.Func2;
import rx.observables.MathObservable;

import java.util.ArrayList;
import java.util.List;

//Existe un listado de productos, para los cuales se conoce el nombre y precio inicialemente, dentro de la compañía, se desea determinar el promedio de precio de producto para:
//
//[ { ps4, 300}, { gamecube, 300}, { external disk, 200}, { laptop, 800}, {vr, 230} ]
//
//- Sumatoria de precio de producto
//- Precio máximo del listado de productos
public class Consolas {
    public static void main(String[] args) {

        List<Consola> consolas = new ArrayList<>();
        consolas.add(new Consola("ps4", 300));
        consolas.add(new Consola("gamecube", 300));
        consolas.add(new Consola("external disk", 200));
        consolas.add(new Consola("laptop", 800));
        consolas.add(new Consola("vr", 230));

        Observable<Consola> consolaObservable = Observable.from(consolas);

        System.out.println("-----Sumatoria------");

        MathObservable.from(consolaObservable).sumInteger(Consola::getPrice).subscribe((sum)->{
            System.out.println(sum);
        });

        System.out.println("------Precio Maximo------");


        Observable maxObs = Observable.from(consolas.toArray()).map((result) -> {
            Consola consola = (Consola) result;
            return consola.getPrice();
        }).reduce(
                new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer anterior, Integer actual) {
                return Math.max(anterior,actual);
            }
        });

        maxObs.subscribe((max)->{
            System.out.println(max);
        });
    }

}
