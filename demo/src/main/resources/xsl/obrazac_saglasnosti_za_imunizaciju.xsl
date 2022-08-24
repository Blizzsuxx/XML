<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:x="http://ftn.uns.ac.rs/saglasnost"
    version="2.0">

    <xsl:template match="/">










    <html>
        <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style>
                table, th, td {
                  border:1px solid black;
                  width:800px;
                }
            </style>
        </meta>
        </head>
        <body>
        <div style="position:absolute;left:350;margin-left:-397px;top:2px;width:850px;height:1441px;border-style:outset;overflow:hidden">
        
        <div style="position:absolute;left:42.52px;top:36.63px" class="cls_002"><span class="cls_002">САГЛАСНОСТ ЗА СПРОВОЂЕЊЕ</span></div>
        <div style="position:absolute;left:445.91px;top:36.63px" class="cls_003"><span class="cls_003">ИНСТИТУТ ЗА</span></div>
        <div style="position:absolute;left:445.91px;top:51.29px" class="cls_003"><span class="cls_003">ЈАВНО ЗДРАВЉЕ СРБИЈЕ</span></div>
        <div style="position:absolute;left:445.91px;top:68.49px" class="cls_003"><span class="cls_003">„Др Милан Јовановић Батут“</span></div>
        <div style="position:absolute;left:42.52px;top:60.63px" class="cls_002"><span class="cls_002">ПРЕПОРУЧЕНЕ ИМУНИЗАЦИЈЕ</span></div>
        <div style="position:absolute;left:42.52px;top:83.53px" class="cls_006"><span class="cls_006">(попуњава пацијент)</span></div>
        <div style="position:absolute;left:42.52px;top:126.41px" class="cls_007"><span class="cls_007">Држављанство</span></div>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:drzavljanstvo/x:republika_srbija">
        <div style="position:absolute;left:184.52px;top:126.41px" class="cls_008"><span class="cls_008">1) Република Србија</span></div>
        </xsl:if>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:drzavljanstvo/x:republika_srbija">
        <div style="position:absolute;left:356.36px;top:126.41px" class="cls_008"><span class="cls_008">ЈМБГ 
            
            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:drzavljanstvo/x:republika_srbija/x:jmbg"/></b>
        
        </span></div>
        </xsl:if>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:drzavljanstvo/x:stranac">
        <div style="position:absolute;left:114.52px;top:152.70px" class="cls_008"><span class="cls_008">2)

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:drzavljanstvo/x:stranac/x:naziv_stranog_drzavljanstva"/></b>

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:drzavljanstvo/x:stranac/x:br_pasosa_ili_ebs"/></b>

        </span></div>
        <div style="position:absolute;left:42.52px;top:167.30px" class="cls_003"><span class="cls_003">(назив страног држављанства) </span></div>
        <div style="position:absolute;left:306.52px;top:167.30px" class="cls_003"><span class="cls_003">(бр. пасоша или ЕБС за стране држављане)</span></div>
        </xsl:if>
        <div style="position:absolute;left:42.52px;top:191.58px" class="cls_007"><span class="cls_007">Презиме <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:prezime"/></b>
        </span></div>
        <div style="position:absolute;left:225.67px;top:191.58px" class="cls_007"><span class="cls_007">Име 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:ime"/></b>
        </span></div>
        <div style="position:absolute;left:386.65px;top:191.58px" class="cls_007"><span class="cls_007">Име родитеља 


            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:ime_roditelja"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:217.86px" class="cls_007"><span class="cls_007">Пол</span><span class="cls_008">:</span></div>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:pol/x:Musko">
        <div style="position:absolute;left:76.70px;top:217.86px" class="cls_008"><span class="cls_008">М,</span></div>
        </xsl:if>
        
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:pol/x:Zensko">
        <div style="position:absolute;left:101.72px;top:217.86px" class="cls_008"><span class="cls_008">Ж</span></div>
        </xsl:if>

        <div style="position:absolute;left:118.47px;top:217.86px" class="cls_007"><span class="cls_007">Датум рођења 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:datum_rodjenja"/></b>

        </span></div>
        <div style="position:absolute;left:383.47px;top:217.86px" class="cls_007"><span class="cls_007">Место рођења 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:mesto_rodjenja"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:244.14px" class="cls_007"><span class="cls_007">Адреса (улица и број) 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:adresa"/></b>
        </span></div>
        <div style="position:absolute;left:389.47px;top:244.14px" class="cls_007"><span class="cls_007">Место/Насеље 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:mesto"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:270.43px" class="cls_007"><span class="cls_007">Општина/Град 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:opstina"/></b>
        </span></div>
        <div style="position:absolute;left:339.47px;top:270.43px" class="cls_007"><span class="cls_007">Тел. фиксни 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:fiksni"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:296.71px" class="cls_007"><span class="cls_007">Тел. мобилни 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:mobilni"/></b>
        </span></div>
        <div style="position:absolute;left:303.49px;top:296.71px" class="cls_007"><span class="cls_007">имејл 
            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:osoba/x:e-adresa"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:321.91px" class="cls_007"><span class="cls_007">Радни статус </span><span class="cls_008">:</span></div>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:radni_status/x:zaposlen">
        <div style="position:absolute;left:158.86px;top:321.91px" class="cls_008"><span class="cls_008">запослен,</span></div>
        </xsl:if>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:radni_status/x:nezaposlen">
        <div style="position:absolute;left:176.87px;top:321.91px" class="cls_008"><span class="cls_008">незапослен,</span></div>
    </xsl:if>
    <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:radni_status/x:penzioner">

        <div style="position:absolute;left:244.82px;top:321.91px" class="cls_008"><span class="cls_008">пензионер,</span></div>
</xsl:if>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:radni_status/x:ucenik">
        <div style="position:absolute;left:308.31px;top:321.91px" class="cls_008"><span class="cls_008">ученик,</span></div>
</xsl:if>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:radni_status/x:student">
        <div style="position:absolute;left:356.13px;top:321.91px" class="cls_008"><span class="cls_008">студент,</span></div>
</xsl:if>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:radni_status/x:dete">
        <div style="position:absolute;left:408.48px;top:321.91px" class="cls_008"><span class="cls_008">дете</span></div>
</xsl:if>
        <div style="position:absolute;left:42.52px;top:347.11px" class="cls_007"><span class="cls_007">Занимање запосленог</span><span class="cls_008">:</span></div>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:zanimanje/x:zdravstvena_zastita">

        <div style="position:absolute;left:268.87px;top:347.11px" class="cls_008"><span class="cls_008">здравствена заштита,</span></div>
    </xsl:if>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:zanimanje/x:socijalna_zastita">
        <div style="position:absolute;left:268.52px;top:347.11px" class="cls_008"><span class="cls_008">социјална заштита,</span></div>
    </xsl:if>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:zanimanje/x:prosveta">

        <div style="position:absolute;left:367.67px;top:347.11px" class="cls_008"><span class="cls_008">просвета,</span></div>
    </xsl:if>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:zanimanje/x:mup">

        <div style="position:absolute;left:424.69px;top:347.11px" class="cls_008"><span class="cls_008">МУП,</span></div>
    </xsl:if>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:zanimanje/x:vojska">

        <div style="position:absolute;left:462.12px;top:347.11px" class="cls_008"><span class="cls_008">Војска РС,</span></div>
    </xsl:if>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:zanimanje/x:drugo">

        <div style="position:absolute;left:521.42px;top:347.11px" class="cls_008"><span class="cls_008">друго</span></div>

</xsl:if>


        <div style="position:absolute;left:42.52px;top:373.39px" class="cls_007"><span class="cls_007">Корисник установе соц. зашт</span><span class="cls_008">.</span></div>
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:korisnik_ustanove_soc_zastite/@izabran=true()">
        <div style="position:absolute;left:279.48px;top:373.39px" class="cls_008"><span class="cls_008">ДА,</span></div>
</xsl:if>
        
        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:korisnik_ustanove_soc_zastite/@izabran=false()">
        
        <div style="position:absolute;left:279.96px;top:373.39px" class="cls_008"><span class="cls_008">НЕ</span></div>

</xsl:if>

        <div style="position:absolute;left:310.41px;top:373.39px" class="cls_007"><span class="cls_007">Назив и општина седишта 

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:opstina_socijale"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:398.59px" class="cls_007"><span class="cls_007">Изјављујем да</span><span class="cls_008">:</span></div>

        <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:izjava/x:saglasnost/@izabran=true()">

        <div style="position:absolute;left:213.98px;top:398.59px" class="cls_007"><span class="cls_007">CAГЛACAH САМ</span><span class="cls_008">,</span></div>
    </xsl:if>
    <xsl:if test="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:izjava/x:saglasnost/@izabran=false()">

        <div style="position:absolute;left:213.47px;top:398.59px" class="cls_007"><span class="cls_007">HИСАМ</span><span class="cls_008"> </span><span class="cls_007">САГЛАСАН</span></div>
</xsl:if>
        <div style="position:absolute;left:363.47px;top:398.59px" class="cls_007"><span class="cls_008">са спровођењем активне/пасивне</span></div>
        
        <div style="position:absolute;left:42.52px;top:411.19px" class="cls_008"><span class="cls_008">имунизације (уписати назив имунолошког лека): 
            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:izjava/x:vakcina"/></b>
        </span></div>
        <div style="position:absolute;left:42.52px;top:436.39px" class="cls_007"><span class="cls_007">Лекар ми је објаснио предности и ризике од спровођења активне/пасивне имунизације наведеним имунолошким леком.</span></div>
        <div style="position:absolute;left:42.52px;top:474.19px" class="cls_007"><span class="cls_007">Потпис пацијента или законског заступника пацијента 
            <div/>

            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:potpis"/></b>
        </span></div>
        <div style="position:absolute;left:402.52px;top:474.19px" class="cls_008"><span class="cls_008">Датум: 
            <div/>
            <b><xsl:value-of select="x:dokument/x:saglasnost_za_sprovodjenje_imunizacije/x:datum"/></b>
        </span></div>
        <div style="position:absolute;left:105.29px;top:538.29px" class="cls_009"><span class="cls_009">ЕВИДЕНЦИЈА О ВАКЦИНАЦИЈИ ПРОТИВ COVID-19</span></div>
        <div style="position:absolute;left:226.94px;top:556.39px" class="cls_008"><span class="cls_008">(попуњава здравствени радник)</span></div>
        <div style="position:absolute;left:42.52px;top:581.59px" class="cls_008"><span class="cls_008">Здравствена установа</span></div>
        <div style="position:absolute;left:337.45px;top:581.59px" class="cls_008"><span class="cls_008">Вакцинацијски пункт</span></div>
        <div style="position:absolute;left:42.52px;top:606.79px" class="cls_008"><span class="cls_008">Име, презиме, факсимил и бр. телефона лекара:</span></div>

        <div style="position:absolute;bottom:150.30px;left:-500px">
        <table >
            <tr>
                <th>Назив вакцине</th>
                <th>Датум давања вакцине (V1 i V2)</th>
                <th>Начин давања вакцине</th>
                <th>Екстремитет</th>
                <th>Серија вакцине (лот)</th>
                <th>Произвођач</th>
                <th>Нежељена реакција</th>
                <th>Потпис лекара</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>ИМ</td>
                <td>1)ДР, 2)ЛР</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>ИМ</td>
                <td>1)ДР, 2)ЛР</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="8">Привремене контраиндикације
(датум утврђивања и дијагноза):</td>
            </tr>
            <tr>
                <td colspan="8">
                Одлука комисије за трајне контраиндикације (ако постоји, уписати Да)

                </td>
            </tr>
        </table>
        </div>
        <div style="position:absolute;left:42.52px;bottom:5.74px" class="cls_007"><span class="cls_007">Напомена</span><span class="cls_008">: Образац се чува као део медицинске документације пацијента.</span></div>
        </div>
        
        </body>
        </html>
        
    </xsl:template>
</xsl:stylesheet>
