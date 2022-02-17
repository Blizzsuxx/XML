
export class Drzavljanstvo{
    public drzavljanstvoRepublikeSrbije: string;
    public straniSaBroravkom: string;
    public straniBezBoravka: string;
}
export class TIzbor{
    public izabran : boolean;
}
export class TOsoba{
    public jmbg: string;
    public ime: string;
    public prezime: string;
    public eAdresa: string;
    public mobilni: string;
    public fiksni: string;
}

export class Vakcine{
    public izabraneVakcine : IzabraneVakcine;
    public biloSta : TIzbor;
}

export class IzabraneVakcine extends TIzbor{
    public vakcina : TVakcina
}

export class TVakcina{
    public pfizer: string;
    public sinopharm: string;
    public moderna: string;
    public sputnik: string;
    public astraZeneca: string;
    
}



export class Interesovanje{
    public drzavljanstvo : Drzavljanstvo
    public osoba : TOsoba   
    public lokacija : string
    public vakcine : TVakcina
    public davalacKrvi : TIzbor
    public dan : string
    public potpis : string

}