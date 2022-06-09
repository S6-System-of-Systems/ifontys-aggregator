# Flow

De vraag is gesteld om mee te kunnen kijken in de flow van de applicatie en hebben daarvoor wat dingen voorbereid om zelf eens te kunnen testen hoe de applicatie nou precies werkt.

Zo zijn er momenteel verschillende endpoints waar naar gekeken kan worden, denk hier aan:
- `ifontys-aggregator`
- `ifontys-institute-endpoint`
- `ifontys-tus-endpoint`

**Logging**

Om de logging van de betreffende applicaties in te kunnen zien, verzoeken wij om een kijkje te nemen op [Dozzle](https://logs.meelsnet.nl/). Hier zijn de applicaties voorbereid en kan live meegekeken worden met de logs die de applicaties produceren.

**Queue's**

De queue's en de configuratie hiervan zijn terug te vinden bij de volgende url's:
- [RabbitMQ](https://queue.meelsnet.nl/)
  - Username: `merel`
  - Password: `welkom`
  - Exchange: `ifontys.exchange`

Voor de programmatische configuraties van de queues zijn de volgende bestanden belangrijk:
- [Aggregator config](https://github.com/S6-System-of-Systems/ifontys-aggregator/blob/master/src/main/java/com/ifontys/aggregator/config/RabbitConfig.java)
- [Institute config](https://github.com/S6-System-of-Systems/ifontys-institute-services/blob/main/src/main/java/com/appliedscience/api/config/RabbitConfig.java)
- [Tus endpoint config](https://github.com/S6-System-of-Systems/ifontys-tus-endpoint/blob/main/src/main/java/com/fontys_automotive/api/config/RabbitConfig.java)

**Uitvoering**

Nu alle systemen online staan en informatie m.b.t. logging etc. beschikbaar zijn, kan er een verzoek gemaakt worden naar de aggregator endpoint, dit kan met de volgende url:

[https://aggregator.meelsnet.nl/endpoint/GetTeacherData?inummer=i873955](https://aggregator.meelsnet.nl/endpoint/GetTeacherData?inummer=i873955)

**Overige verzoeken**

Er zijn overige verzoeken in het systeem, echter worden deze absoluut niet actief gebruikt en zullen ze in de nabije toekomst verwijderd of debrecated zijn:

- [Institute endpoint swagger](https://institute.meelsnet.nl/swagger-ui/index.html)
- User endpoint
  - aggregator.meelsnet.nl
    - /endpoint
      - GetTeacherData
      - parameter: i000000
- Tus endpoint api
  - tus.meelsnet.nl
    - /project
      - GET
    - /teacher
      - GET
        - /{email}
      - POST
        - [Teacher](https://github.com/S6-System-of-Systems/ifontys-tus-endpoint/blob/main/src/main/java/com/fontys_automotive/api/teacher/Teacher.java)
