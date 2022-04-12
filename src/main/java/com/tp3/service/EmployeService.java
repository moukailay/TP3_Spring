package com.tp3.service;

import com.tp3.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static Date CalculerDateRetour ( int nombreJour ) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar cal = Calendar.getInstance();
        cal.setTime( new Date() );
        cal.add( Calendar.DATE , nombreJour );

        return simpleDateFormat.parse( simpleDateFormat.format( cal.getTime() ) );
    }
}