package controller;


import dto.XMLDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.XMLService;

@RestController
@RequestMapping(value = "api/xml", produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
public class XMLController {

    private XMLService xmlService;

    private XMLController(XMLService service) {
        super();
        this.xmlService = service;
    }

    @PostMapping("/jaxB")
    public ResponseEntity<XMLDto> getChangedXMLJaxB(@RequestBody XMLDto dto) throws Exception{
        String response = xmlService.jaxBTestInteresovanje(dto);
        return new ResponseEntity<XMLDto>(new XMLDto(response), HttpStatus.OK);
    }
}
