
export class Kolona {
    nazivVakcine: string = "";
    datumVakcine: string = "";
    ekstremitet: string = "";
    serija: string = "";
    proizvodjac: string = "";
    nezeljenaReakcija: string = "";
    potpisLekara: string = "";

    
}

export class Evidencija {
    institution: string = "";
    punkt: string = "";
    name : string = "";
    lastname : string = "";
    faksimil : string = "";
    telephone : string = "";
    tabela : Tabela = new Tabela();
    trajneKontradikcije: boolean = false;
    privremeneKontradikcije: string = "";
    privremeneKontradikcijeDatum: string = "";

    
}

export class Tabela{
    kolona : Kolona[] = [];
}
