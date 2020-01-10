package com.globo.enums;

import java.util.NoSuchElementException;

public class IdentifiableEnum {

    public static <E extends Enum<E>> E findByName(String name, Class<E> eClass) throws NoSuchElementException{
        for (E e: eClass.getEnumConstants() ) {
            if( e.name().equalsIgnoreCase(name)){
                return e;
            }
        }
        throw new NoSuchElementException("Enum nao identificado");
    }
}