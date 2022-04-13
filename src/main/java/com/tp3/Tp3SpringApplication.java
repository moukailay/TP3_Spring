package com.tp3;

import com.tp3.execeptions.DocumentNotFoundException;
import com.tp3.service.EmployeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Tp3SpringApplication implements CommandLineRunner {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

    private final EmployeService employeService;

    @Autowired
    public Tp3SpringApplication ( EmployeService employeService ) {
        this.employeService = employeService;
    }

    public static void main ( String[] args ) {
        SpringApplication.run( Tp3SpringApplication.class , args );
    }

    @SneakyThrows
    @Override
    public void run ( String... args ) {
        employeService.enregistrerClient( "YAHAYA" ,
                "MOUKAILA" ,
                "QUEBEC" );
        employeService.enregistrerClient( "HASSAN" ,
                "BEN" ,
                "CHICOUTIMI" );

        //Enregistrement des documents
        employeService.enregistrerLivre(
                "penser avec donna hathaway" ,
                "Williams" ,
                "puf" ,
                1 ,
                simpleDateFormat.parse( "2012-06-22" ) ,
                "roman" ,
                21 ,
                250 );
        employeService.enregistrerLivre( "un piège sans fin" ,
                "Olympe" ,
                "toundra" ,
                4 ,
                simpleDateFormat.parse( "1960-10-12" ) ,
                "fiction" ,
                21 ,
                50 );
        employeService.enregistrerLivre( "une fois" ,
                "YAHAYA" ,
                "MK" ,
                0 ,
                simpleDateFormat.parse( "1960-10-12" ) ,
                "fiction" ,
                21 ,
                50 );
        employeService.enregistrerCd( "harry potter" ,
                "rowling" ,
                "John" ,
                3 ,
                simpleDateFormat.parse( "2016-10-12" ) ,
                "fantasy littéraire" ,
                14 ,
                120 );
        employeService.enregistrerCd( "anglais" ,
                "pascal" ,
                "woo" ,
                4 ,
                simpleDateFormat.parse( "2020-01-12" ) ,
                "littéraire" ,
                14 ,
                120 );
        employeService.enregistrerDvd( "mathématique" ,
                "Robert john" ,
                "freeMath" ,
                16 ,
                simpleDateFormat.parse( "2013-11-10" ) ,
                "science" ,
                7 ,
                120 );
        employeService.enregistrerDvd( "physique" ,
                "pascal" ,
                "woo" ,
                8 ,
                simpleDateFormat.parse( "2020-01-12" ) ,
                "science" ,
                7 ,
                120 );

        //Recherche document par titre
        System.out.println( "Document par titre" );
        try {
            System.out.println( employeService.findByTitreDocument( "h" ) );
        } catch (DocumentNotFoundException ignored) {}
        System.out.println();

        //Recherche document par auteur
        System.out.println( "Document par auteur" );
        try {
            System.out.println( employeService.findByAuteurDocument( "pascal" ) );
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();


        //Recherche document par catégorie
        System.out.println( "Document par catégorie" );
        try {
            System.out.println( employeService.findByCategorieDocument( "science" ) );
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();

        //Recherche document par an de publication
        System.out.println( "Document par année de publication" );
        try {
            System.out.println( employeService.findByAnneeDocument( 2020 ) );
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();

        //ENREGISTREMENT DES PRETS DE DOCUMENTS<<<<<<<<<<<<<<<<<<<<<< cas normaux
        employeService.enregistrerPret( new Date() ,
                employeService.getClient( 1 ) ,
                employeService.getDocument( 3 ) ,
                "non retourné" );

        employeService.enregistrerPret( new Date() ,
                employeService.getClient( 2 ) ,
                employeService.getDocument( 4 ) ,
                "non retourné" );

        employeService.enregistrerPret( new Date() ,
                employeService.getClient( 1 ) ,
                employeService.getDocument( 6 ) ,
                "non retourné" );

        //Affichage des documents empruntés par le client ID=1
        try {
            employeService.findAllPretDocumentClient( employeService.getClient( 1 ) );
        } catch (DocumentNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

        //ENREGISTREMENT pret DOCUMENTS (document avec zéro exemplaire)<<<<<<<<<<<<<
        //échec d'emprunt

        employeService.enregistrerPret( new Date() ,
                employeService.getClient( 2 ) ,
                employeService.getDocument( 3 ) ,
                "non retourné" );
    }
}
