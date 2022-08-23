<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    version="2.0">

    <xsl:template match="/">










    <html>
        <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        </head>
        <body>
        <h3>ДИГИТАЛНИ ЗЕЛЕНИ СЕРТИФИКАТ</h3>
        <h2>Потврда о извршеној вакцинацији против COVID-19 и резултата тестирања</h2>
        <h3 > DIGITAL GREEN CERTIFICATE </h3>
        <h2 > Certificate of vaccination against COVID-19 and test results</h2>
        <h3 >INSTITUTE OF PUBLIC HEALTH OF SERBIA</h3>
        <h3 >REPUBLIC OF SERBIA</h3>


        <div><b>Број сертификата / Certificate ID: </b> <b><xsl:value-of select="digitalniSertifikat/id"/></b> </div>
        <img>
            <xsl:attribute name="src">qr-code<xsl:value-of select="digitalniSertifikat/id"/>.jpg</xsl:attribute>
        </img>
        
        <div><b>Датум и време издавања сертификата / Date and time of issue: 
            <b><xsl:value-of select="digitalniSertifikat/datumIzdavanja"/></b> <b><xsl:value-of select="digitalniSertifikat/vreme"/></b> </b></div>

        <div><b>
                Име и презиме / Name and surname: <b><xsl:value-of select="digitalniSertifikat/Pacijent/ime"/></b> 
                <b><xsl:value-of select="digitalniSertifikat/Pacijent/prezime"/></b>
        </b></div>
        

        <h1> 
            Пол / Gender <b><xsl:value-of select="digitalniSertifikat/Pacijent/pol"/></b>
        </h1>

        <div> <b>
            Датум рођења/Date of birth: <b><xsl:value-of select="digitalniSertifikat/Pacijent/datum"/></b>
        </b></div>
        
        
        <h1> 
            ЈМБГ / Personal No.: <b><xsl:value-of select="digitalniSertifikat/Pacijent/jmbg"/></b>
        </h1>
        <div> <b>
        Број пасоша / Passport No.: <xsl:value-of select="digitalniSertifikat/Pacijent/pasos"/>
        </b></div>

        
        <h2> Вакцина / Vaccination </h2>
        <div> <b>
            Доза / dose : 1/2
            Тип / type: <b><xsl:value-of select="digitalniSertifikat/vakcinacija"/></b>
            Датум / Date: <b><xsl:value-of select="digitalniSertifikat/vakcinacija"/></b>
            Здравствена установа / Health facility: <b><xsl:value-of select="digitalniSertifikat/vakcinacija"/></b>

        </b></div>
        <div> <b>
            Доза / dose : 2/2
            Тип / type: <b><xsl:value-of select="digitalniSertifikat/vakcinacija"/></b>
            Датум / Date: <b><xsl:value-of select="digitalniSertifikat/vakcinacija"/></b>
            Здравствена установа / Health facility: <b><xsl:value-of select="digitalniSertifikat/vakcinacija"/></b>

        </b></div>

        
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
