package com.example.demo.schedulingtasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XMLResource;

import com.example.demo.db.ExistManager;
import com.example.demo.jaxb.JaxB;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje;
import com.example.demo.model.interesovanje.InteresovanjeZaVakcinisanje.Vakcine.IzabraneVakcine;
import com.example.demo.model.korisnik.Korisnik;
import com.example.demo.model.vakcina.Vaccine;
import com.example.demo.model.vakcina.Vaccines;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.MailSender;
import com.example.demo.service.VaccineService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private VaccineService vaccineService;

	@Autowired
	private ExistManager existManager;

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JaxB jaxB;

	@Autowired
	private KorisnikService korisnikService;

	@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {

		try {
			ResourceSet xmlRequests = existManager.retrieve("/db/dokumenti/zahtevZaSaglasnost", "/*");
			ResourceIterator i = xmlRequests.getIterator();
			XMLResource res;
			while (i.hasMoreResources()) {
				try {
					res = (XMLResource) i.nextResource();
					System.out.println(res.getId());
					if(res.getId().split("\\.")[1].equals("html")){
						continue;
					}
					JAXBContext jaxbContext = JAXBContext.newInstance(InteresovanjeZaVakcinisanje.class);
					InteresovanjeZaVakcinisanje one = (InteresovanjeZaVakcinisanje) jaxbContext.createUnmarshaller()
							.unmarshal(res.getContentAsDOM());

					if (one.getNadjenTermin() == null || !one.getNadjenTermin()) {
						Boolean biloSta = one.getVakcine().getBiloSta().isIzabran();
						IzabraneVakcine izabraneVakcine = one.getVakcine().getIzabraneVakcine();
						Vaccines vacciness = vaccineService.findAll();
						for (Vaccine vaccine : vacciness.getVaccine()) {
							if (vaccine.getQuantity() <= 0) {
								continue;
							}

							if (biloSta) {
								if(this.napraviTermin(one, vaccine)){
									break;
								}
							}
							if (izabraneVakcine.getVakcina().getAstraZeneca() != null && izabraneVakcine.getVakcina().getAstraZeneca().equals(vaccine.getManufacturer())) {
								if(this.napraviTermin(one, vaccine)){
									break;
								}
							}
							if (izabraneVakcine.getVakcina().getModerna() != null && izabraneVakcine.getVakcina().getModerna().equals(vaccine.getManufacturer())) {
								if(this.napraviTermin(one, vaccine)){
									break;
								}
							}
							if (izabraneVakcine.getVakcina().getPfizer() != null && izabraneVakcine.getVakcina().getPfizer().equals(vaccine.getManufacturer())) {
								if(this.napraviTermin(one, vaccine)){
									break;
								}
								
							}

							if (izabraneVakcine.getVakcina().getSinopharm() != null && izabraneVakcine.getVakcina().getSinopharm().equals(vaccine.getManufacturer())) {
								if(this.napraviTermin(one, vaccine)){
									break;
								}
							}
							if (izabraneVakcine.getVakcina().getSputnik() != null && izabraneVakcine.getVakcina().getSputnik().equals(vaccine.getManufacturer())) {
								if(this.napraviTermin(one, vaccine)){
									break;
								}
							}

						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("Provera da li postoji slobodan termin, trenutno vreme je: {}", dateFormat.format(new Date()));

	}

	private int maxTerminaZaVakcinu(Vaccine vaccine) {
		switch (vaccine.getManufacturer()) {
			case "Astra Zeneca":
				return 4;
			case "Moderna":
				return 3;
			case "Pfizer":
				return 6;
			case "Sinopharm":
				return 7;
			case "Sputnik":
				return 2;
		}
		return 5;
	}

	private boolean proveriTermine(Vaccine vaccine) {

		int getMaxTermina = this.maxTerminaZaVakcinu(vaccine);
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date terminDate = null;
		for (int brojDana = 1; brojDana < 8; brojDana++) {
			terminDate = new Date(today.getTime() + (brojDana * 24 * 60 * 60 * 1000));
			if (vaccine.getTermini().get(formatter.format(terminDate)) == null || vaccine.getTermini().get(formatter.format(terminDate)) < getMaxTermina) {
				Long termini = vaccine.getTermini().get(formatter.format(terminDate));
				if(termini == null) {
					termini = 0L;
				}
				vaccine.getTermini().put(formatter.format(terminDate), termini + 1);
				log.info("Nadjen slobodan termin za: {}", formatter.format(terminDate));
				return true;
			}
		}
		return false;

	}

	private boolean napraviTermin(InteresovanjeZaVakcinisanje interesovanjeZaVakcinisanje, Vaccine vaccine) {
		boolean slobodanTermin = this.proveriTermine(vaccine);
		if (!slobodanTermin) {
			return false;
		}
		interesovanjeZaVakcinisanje.setNadjenTermin(true);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		vaccine.setQuantity(vaccine.getQuantity() - 1);
		log.info("Nadjen slobodan termin za: {} {}", vaccine.getManufacturer(), interesovanjeZaVakcinisanje.getOsoba().getJmbg());
		this.vaccineService.save(vaccine);
		String interesovanjeString = "";
		try {
            interesovanjeString = this.jaxB.marshall(InteresovanjeZaVakcinisanje.class, interesovanjeZaVakcinisanje);
            System.out.println(interesovanjeString);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
                    Korisnik korisnik = this.korisnikService.getOne(interesovanjeZaVakcinisanje.getOsoba().getEAdresa());
                    this.existManager.storeFromText("/db/dokumenti/zahtevZaSaglasnost", korisnik.getJmbg() + ".xml",
                    interesovanjeString);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		mailSender.sendEmail(interesovanjeZaVakcinisanje.getOsoba().getEAdresa(), ("Zakazan vam je termin za vakcinu: " +
				"Zakazan vam je termin za vakcinu: " + vaccine.getManufacturer() + " na datum: " + formatter.format(new Date()) ).getBytes() );

		return true;

	}
}