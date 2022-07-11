
export class ZahtevZaZeleniSertifikat {

    public jmbg: string;
    public ime: string;
    public prezime: string;
    public pol: string;
    public datumRodjenja: string;
    public mesto: string;
    public razlog: string;
    public brojPasossa: string;
    constructor(
        jmbg : string, 
        ime: string,
        prezime: string,
        pol: string,
        datumRodjenja: string,
        mesto: string,
        razlog: string,
        brojPasosa: string) {
        
        

            this.jmbg = jmbg;
            this.ime = ime;
            this.prezime = prezime;
            this.pol = pol;
            this.datumRodjenja = datumRodjenja;
            this.mesto = mesto;
            this.razlog = razlog;
            this.brojPasossa = brojPasosa;
    }
}