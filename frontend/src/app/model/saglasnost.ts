
export class Saglasnost {

    public drzavljanstvo: string;
    public jmbg: string;
    public ime: string;
    public prezime: string;
    public imeRoditelja: string;
    public pol: string;
    public datumRodjenja: string;
    public mestoRodjenja: string;
    public adresa: string;
    public mesto: string;
    public mobilni: string;
    public fiksni: string;
    public eadresa: string;
    public radniStatus: string;
    public zanimanje: string;
    public socijalnaZastita: string;
    public saglasnost: string;
    public izabranaVakcina: string;
    public opstinaSocijale: string;
    public opstina: string;
    constructor(
        drzavljanstvo : string, 
        jmbg : string, 
        ime: string,
        prezime: string,
        imeRoditelja: string,
        pol: string,
        datumRodjenja: string,
        mestoRodjenja: string,
        adresa: string,
        mesto: string,
        mobilni: string,
        fiksni: string,
        eadresa: string,
        radniStatus: string,
        zanimanje: string,
        socijalnaZastita: string,
        saglasnost: string,
        izabranaVakcina: string,
        opstinaSocijale: string,
        opstina: string) {
        
        

            this.drzavljanstvo = drzavljanstvo;
            this.jmbg = jmbg;
            this.ime = ime;
            this.prezime = prezime;
            this.imeRoditelja = imeRoditelja;
            this.pol = pol;
            this.datumRodjenja = datumRodjenja;
            this.mestoRodjenja = mestoRodjenja;
            this.adresa = adresa;
            this.mesto = mesto;
            this.mobilni = mobilni;
            this.fiksni = fiksni;
            this.eadresa = eadresa;
            this.radniStatus = radniStatus;
            this.zanimanje = zanimanje;
            this.socijalnaZastita = socijalnaZastita;
            this.saglasnost = saglasnost;
            this.izabranaVakcina = izabranaVakcina;
            this.opstinaSocijale = opstinaSocijale;
            this.opstina = opstina
    }
}