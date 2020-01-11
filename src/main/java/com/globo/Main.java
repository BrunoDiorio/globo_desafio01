package com.globo;

import com.globo.entity.Url;
import com.globo.factory.UrlFactory;

import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrada:");
            String rawUrl = sc.nextLine();

            Url url = UrlFactory.decode(rawUrl);
            System.out.println("Saida:");
            System.out.println(url);

        } catch (IllegalArgumentException | MalformedURLException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Exeção inesperada");
        }
    }
}
