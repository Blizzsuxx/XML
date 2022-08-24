# XML
"demo" je backend za pacijente
"clerk-b" je backend za sluzbenike i zdravstvene radnike
"frontend" je frontend za pacijente
"frontend-clerk" je frontend za sluzbenike i zdravstvene radnike

## pre pokretanja svakog projekta
pozicijonirati se u apache-tomcat-8.5.73/bin/ i pokrenuti tomcat-a pomocu startup.sh/bin skripte

## kako pokrenuti pacijenta
iz direktorijuma projekta pokrenuti "demo" projekat, (ne pokretati iz "demo" direktorijuma vec iz direktorijuma celog git projekta)
pozicijonirati se u frontend direktorijum pomocu terminala
pokrenuti "npm install" zatim "ng serve"

## kako pokrenuti Clerka
iz direktorijuma projekta pokrenuti "clerk-b" projekat, (ne pokretati iz "clerk-b" direktorijuma vec iz direktorijuma celog git projekta)
pozicijonirati se u clerk-frontend direktorijum pomocu terminala
pokrenuti "npm install" zatim "ng serve"
pozicijonirati se u clerk-b/data/gen/ pomocu konzole
instalirati http-server pomocu npm i --global http-server (na linuxu sa sudo komandom)
pokrenuti komandu http-server
