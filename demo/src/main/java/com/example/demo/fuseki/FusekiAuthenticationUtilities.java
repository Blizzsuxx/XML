package com.example.demo.fuseki;

public class FusekiAuthenticationUtilities {
    /**
     * ExampleProperties represents the configuration for the examples.
     */

        public String endpoint = "http://localhost:8081/fuseki";
        public String dataset = "Fakultet";

        public String queryEndpoint = "query";
        public String updateEndpoint = "update";
        public String dataEndpoint = "data";


        public FusekiAuthenticationUtilities() {
            queryEndpoint = String.join("/", endpoint, dataset, queryEndpoint);
            updateEndpoint = String.join("/", endpoint, dataset, updateEndpoint);
            dataEndpoint = String.join("/", endpoint, dataset, dataEndpoint);

        }

}
