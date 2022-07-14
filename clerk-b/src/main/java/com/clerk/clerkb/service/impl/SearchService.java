package com.clerk.clerkb.service.impl;

import com.clerk.clerkb.dto.SearchDocuments;
import com.clerk.clerkb.repository.DigitalCertificateRepository;
import com.clerk.clerkb.repository.PotvrdaOVakcinacijiRepository;
import com.clerk.clerkb.repository.SaglasnostRepository;
import com.clerk.clerkb.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SearchService implements ISearchService {

    @Autowired
    private DigitalCertificateRepository digitalCertificateRepository;

    @Autowired
    private PotvrdaOVakcinacijiRepository potvrdaOVakcinacijiRepository;

    @Autowired
    private SaglasnostRepository saglasnostRepository;

    @Override
    public SearchDocuments simpleSearch(String content) {
        SearchDocuments sd = new SearchDocuments();

        sd.setPotvrda(
                potvrdaOVakcinacijiRepository.findAll()
                .stream().filter(p -> p.getPacijent().getIme().equals(content)
                        || p.getPacijent().getPrezime().equals(content)
                        || p.getPacijent().getJmbg().equals(content)
                        || p.getVakcina().getSputnik().equals(content)
                        || p.getVakcina().getSinopharm().equals(content)
                        || p.getVakcina().getModerna().equals(content)
                        || p.getVakcina().getAstraZeneca().equals(content)
                        || p.getVakcina().getPfizer().equals(content)
                        || p.getUstanova().getNaziv().equals(content)
                        || p.getUstanova().getGrad().equals(content)
                        || p.getSerija().equals(content)).collect(Collectors.toList()));

        sd.setSertifikat(
                digitalCertificateRepository.findAll()
                .stream().filter(ds -> ds.getPacijent().getIme().equals(content)
                        || ds.getPacijent().getPrezime().equals(content)
                        || ds.getPacijent().getJmbg().equals(content)).collect(Collectors.toList()));

        sd.setSaglasnost(saglasnostRepository.findAll()
                        .stream().filter(s -> s.getSaglasnostZaSprovodjenjeImunizacije().getOsoba().getJmbg().equals(content)
                        || s.getSaglasnostZaSprovodjenjeImunizacije().getOsoba().getIme().equals(content)
                        || s.getSaglasnostZaSprovodjenjeImunizacije().getOsoba().getPrezime().equals(content)
                        || s.getSaglasnostZaSprovodjenjeImunizacije().getPotpis().equals(content)
                        || s.getEvidencijaOVakcinaciji().getZdravstvenaUstanova().equals(content)
                        || s.getEvidencijaOVakcinaciji().getVakcinacijskiPunkt().equals(content)
                        || s.getEvidencijaOVakcinaciji().getImePrezimeFaksimilBrtel().getPrezime().equals(content)
                        || s.getEvidencijaOVakcinaciji().getImePrezimeFaksimilBrtel().getIme().equals(content))
                .collect(Collectors.toList()));

        return sd;
    }

}
