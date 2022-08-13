<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:x=""
    version="2.0">

    <xsl:template match="/">










    <html>
        <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <style type="text/css">
        </style>
        </head>
        <body>
        <h3>ДИГИТАЛНИ ЗЕЛЕНИ СЕРТИФИКАТ</h3>
        <h2>Потврда о извршеној вакцинацији против COVID-19 и резултата тестирања</h1>
        <h3 > DIGITAL GREEN CERTIFICATE </h3>
        <h2 > Certificate of vaccination against COVID-19 and test results</h1>
        <h3 >INSTITUTE OF PUBLIC HEALTH OF SERBIA</h3>
        <h3 >REPUBLIC OF SERBIA</h3>


        <h2>ШИФРА ПОТВРДЕ О ВАКЦИНАЦИЈЕ</h2>
        <h1 >Sifra potvrde/Confirmation code</h2>
        
        <h3>ПОТВРДА О ИЗВРШЕНОЈ ВАКЦИНАЦИЈИ ПРОТИВ COVID-19</h3>
        <h2 >POTVRDA O IZVRSENOJ VAKCINACIJI PROTIV COVID-19</h3>
        <h2 >CONFIRMATION OF THE COVID-19 VACCINATION</h3>

            <h1> 
                Име и презиме: <b><xsl:value-of select="x:Pacijent/x:ime"/></b> <b><xsl:value-of select="x:Pacijent/x:prezime"/></b>
            </h1>
        <div >
            Ime i prezime/First and Last Name
        </div>
        <h1> 
            Датум рођења: <b><xsl:value-of select="x:Pacijent/x:datum"/></b>
        </h1>
        <div >
            Datum rodjenja/Date of birth
        </div>
        <h1> 
            Пол: <b><xsl:value-of select="x:Pacijent/x:pol"/></b>
        </h1>
        <div >
            Pol: / Gender: 
        </div>
        <h1> 
            ЈМБГ: <b><xsl:value-of select="x:Pacijent/x:jmbg"/></b>
        </h1>
        <div >
            JMBG/Personal No.
        </div>
        <h1> 
            Датум давања и број серије прве дозе вакцине: <b><xsl:value-of select="x:datumPrva"/></b>, серија: <b><xsl:value-of select="x:serija"/></b>
        </h1>
        <div >
            Datum vakcinacije/Vaccination Date
        </div>
        <h1>  
            Датум давања и број серије друге дозе вакцине: <b><xsl:value-of select="x:datumDruga"/></b>
        </h1>
        <div >
            Datum druge vakcinacije/Second Vaccination Date
        </div>
        <h1> 
            Здравствена установа која вакцинише: <b><xsl:value-of select="x:ustanova"/></b>
        </h1>
        <div >
            Zdravstevna ustanova koja vakcinise/Healthcare Institution of vaccination
        </div>
        <h1> 
            Назив вакцине: <b><xsl:value-of select="x:vakcina"/></b>
        </h1>
        <div >
            Naziv Vakcine/Name of vaccine
        </div>
        <h1> 
            Датум издавања потврде: <b><xsl:value-of select="x:datumPotvrde"/></b>
        </h1>
        <div >
            Datum izdavanja potvrde/Confirmation Release Date
        </div>
        <h1> 
            Здравствена установа: <b><xsl:value-of select="x:ustanova"/></b>
        </h1>
        <div >
            Zdravstvena ustanova/Medical Institution.
        </div>
        <h1> 
            Ова потврда важи без потписа и печата
        </h1>
        <div >
            Ova potvrda vazi bez potpisa i pecata/This confirmation is valid without signature and seals.
        </div>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
