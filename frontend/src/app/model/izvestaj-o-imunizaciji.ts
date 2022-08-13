export class TDoza{
    public redniBrojDoze: number;
    public primljenaKolicina: number;

    constructor(redniBrojDoze: number, primljenaKolicina: number){
        this.redniBrojDoze = redniBrojDoze;
        this.primljenaKolicina = primljenaKolicina;
    }
}

export class TProizvodjac{
    public imeDoze: string;
    public primljenaKolicina: number;

    constructor(imeDoze: string, primljenaKolicina: number){
        this.imeDoze = imeDoze;
        this.primljenaKolicina = primljenaKolicina;
    }
}


export class IzvestajOImunizaciji {

    public datumOd: string;
    public datumDo : string;
    public podnetoInteresovanje : number;
    public podnetoZahtevaZaDigitalniSertifikat : number;
    public IzdatoZahtevaZaDigitalniSertifikat : number;
    public datoDozaVakcina : number;
    public doze : TDoza[];
    public proizvodjaci : TProizvodjac[];

    constructor(datumOd: string, datumDo: string, podnetoInteresovanje: number, podnetoZahtevaZaDigitalniSertifikat: number, IzdatoZahtevaZaDigitalniSertifikat: number, datoDozaVakcina: number, doze: TDoza[], proizvodjaci: TProizvodjac[]) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.podnetoInteresovanje = podnetoInteresovanje;
        this.podnetoZahtevaZaDigitalniSertifikat = podnetoZahtevaZaDigitalniSertifikat;
        this.IzdatoZahtevaZaDigitalniSertifikat = IzdatoZahtevaZaDigitalniSertifikat;
        this.datoDozaVakcina = datoDozaVakcina;
        this.doze = doze;
        this.proizvodjaci = proizvodjaci;
    }

}