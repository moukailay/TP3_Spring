package com.tp3.service;

import com.tp3.execeptions.ClientNotFoundException;
import com.tp3.execeptions.DocumentNotFoundException;
import com.tp3.model.*;
import com.tp3.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private ClientRepository clientRepository;
    private LivreRepository livreRepository;
    private DvdRepository dvdRepository;
    private CdRepository cdRepository;
    private AmendeRepository amendeRepository;
    private PretDocumentRepository pretDocumentRepository;
    private DocumentRepository documentRepository;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

    @Autowired
    public EmployeService ( ClientRepository clientRepository ,
                            LivreRepository livreRepository ,
                            DvdRepository dvdRepository ,
                            CdRepository cdRepository ,
                            AmendeRepository amendeRepository ,
                            PretDocumentRepository pretDocumentRepository ,
                            DocumentRepository documentRepository ) {
        this.clientRepository = clientRepository;
        this.livreRepository = livreRepository;
        this.dvdRepository = dvdRepository;
        this.cdRepository = cdRepository;
        this.amendeRepository = amendeRepository;
        this.pretDocumentRepository = pretDocumentRepository;
        this.documentRepository = documentRepository;
    }

    public static Date calculerDateRetour ( int nombreJour ) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar cal = Calendar.getInstance();
        cal.setTime( new Date() );
        cal.add( Calendar.DATE , nombreJour );

        return simpleDateFormat.parse( simpleDateFormat.format( cal.getTime() ) );
    }

    public List<Client> listeClient () {
        return clientRepository.findAll();
    }

    public List<Livre> listeLivre () {
        return livreRepository.findAll();
    }

    public List<Document> listeDocument () {
        return documentRepository.findAll();
    }

    public void enregistrerLivre ( String titre ,
                                   String auteur ,
                                   String editeur ,
                                   int nbExemplaire ,
                                   Date datePub ,
                                   String genre ,
                                   int dureeMaxPret ,
                                   int nbPages ) {
        Livre livre = Livre.builder()
                .titre( titre )
                .auteur( auteur )
                .editeur( editeur )
                .datePub( datePub )
                .genre( genre )
                .nbExemplaire( nbExemplaire )
                .dureeMaxPret( dureeMaxPret )
                .nbPages( nbPages )
                .build();
        livreRepository.save( livre );
    }

    public void enregistrerCd ( String titre ,
                                String auteur ,
                                String editeur ,
                                int nbExemplaire ,
                                Date datePub ,
                                String genre ,
                                int dureeMaxPret ,
                                int duree ) {
        Cd cd = Cd.builder()
                .titre( titre )
                .auteur( auteur )
                .editeur( editeur )
                .datePub( datePub )
                .genre( genre )
                .nbExemplaire( nbExemplaire )
                .dureeMaxPret( dureeMaxPret )
                .duree( duree )
                .build();
        cdRepository.save( cd );
    }

    public void enregistrerDvd ( String titre ,
                                 String auteur ,
                                 String editeur ,
                                 int nbExemplaire ,
                                 Date datePub ,
                                 String genre ,
                                 int dureeMaxPret ,
                                 int duree ) {
        Dvd dvd = Dvd.builder()
                .titre( titre )
                .auteur( auteur )
                .editeur( editeur )
                .datePub( datePub )
                .genre( genre )
                .nbExemplaire( nbExemplaire )
                .dureeMaxPret( dureeMaxPret )
                .duree( duree )
                .build();
        dvdRepository.save( dvd );
    }

    public void enregistrerClient ( String nom , String prenom , String adresse ) {
        Client client = Client.builder()
                .nom( nom )
                .prenom( prenom )
                .adresse( adresse )
                .build();
        clientRepository.save( client );
    }

    public Client getClient ( long id ) throws ClientNotFoundException {
        Optional<Client> client = clientRepository.findById( id );
        if ( client.isPresent() ) {
            return client.get();
        }
        throw new ClientNotFoundException( "Pas de client enregistré avec l'ID" + id );
    }

    public void supprimerClient ( Long id ) throws ClientNotFoundException {
        Long count = clientRepository.countByIdUser( id );
        if ( count == null || count == 0 ) {
            throw new ClientNotFoundException( "Pas de client enregistré avec l'ID" + id );
        }
        clientRepository.deleteById( id );
    }

    public void enregistrerDocument ( Document document ) {
        documentRepository.save( document );
    }

    public List<Document> findByTitreDocument ( String titre ) throws DocumentNotFoundException {
        List<Document> doc = documentRepository.findByTitreContains( titre );
        if ( doc.isEmpty() ) {
            throw new DocumentNotFoundException( "Pas de document" );
        }
        return doc;
    }

    public List<Document> findByCategorieDocument ( String genre ) throws DocumentNotFoundException {
        List<Document> doc = documentRepository.findByGenre( genre );
        if ( doc.isEmpty() ) {
            throw new DocumentNotFoundException( "Pas de document" );
        }
        return doc;
    }

    public List<Document> findByAnneeDocument ( int annee ) throws DocumentNotFoundException {
        List<Document> doc = documentRepository.findByAnnePub( annee );
        if ( doc.isEmpty() ) {
            throw new DocumentNotFoundException( "Pas de document" );
        }
        return doc;
    }

    public List<Document> findByAuteurDocument ( String auteur ) throws DocumentNotFoundException {
        List<Document> doc = documentRepository.findByAuteur( auteur );
        if ( doc.isEmpty() ) {
            throw new DocumentNotFoundException( "Pas de document" );
        }
        return doc;
    }

    public void findAllPretDocumentClient ( Client client ) throws DocumentNotFoundException {
        List<PretDocument> pretDoc = pretDocumentRepository.findAll();
        if ( pretDoc.isEmpty() ) {
            throw new DocumentNotFoundException( "Pas de document" );
        }
        System.out.println( "Liste des livres empruntés par le client " + client.getNom() + " " + client.getPrenom() );
        System.out.println( "TITRE             AUTEUR            DATE RETOUR" );
        for ( PretDocument pret : pretDoc ) {
            if ( pret.getClient().getIdUser() == client.getIdUser() ) {
                System.out.println( pret.getDocument().getTitre() + "             " + pret.getDocument().getAuteur() + "         " + simpleDateFormat.format( pret.getDateRetour() ) );
            }
        }
    }

    public List<PretDocument> findAllPretDocumentEnCours () {
        List<PretDocument> pretDoc = pretDocumentRepository.findByStatutRetour( "non retourné" );
        return pretDoc;
    }

    public void enregistrerPret ( Date datePret ,
                                  Client client ,
                                  Document document ,
                                  String statutRetour )
            throws ParseException {
        if ( document.getNbExemplaire() > 0 ) {
            PretDocument pret = PretDocument.builder()
                    .datePret( datePret )
                    .dateRetour( calculerDateRetour( document.getDureeMaxPret() ) )
                    .client( client )
                    .document( document )
                    .statutRetour( statutRetour )
                    .build();
            pretDocumentRepository.save( pret );
            document.setNbExemplaire( document.getNbExemplaire() - 1 );
            documentRepository.save( document );
        } else {
            System.out.println( "le Document " + document.getTitre() + " n'est pas disponible" );
        }
    }
}